package tests;

import java.lang.reflect.Method;

public class TestRunner {
    public static void main(String[] args) {
        Class<?>[] testClasses = new Class<?>[] {
                tests.core.StudentTest.class,
                tests.core.CourseTest.class,
                tests.core.OnlineCourseTest.class
        };

        int total = 0;
        int passed = 0;
        for (Class<?> clazz : testClasses) {
            for (Method m : clazz.getDeclaredMethods()) {
                if (m.getName().startsWith("test") && m.getParameterCount() == 0) {
                    total++;
                    try {
                        Object instance = clazz.getDeclaredConstructor().newInstance();
                        m.invoke(instance);
                        passed++;
                        System.out.println("[PASS] " + clazz.getSimpleName() + "." + m.getName());
                    } catch (Throwable t) {
                        System.out.println("[FAIL] " + clazz.getSimpleName() + "." + m.getName());
                        Throwable cause = t.getCause() != null ? t.getCause() : t;
                        cause.printStackTrace(System.out);
                    }
                }
            }
        }
        System.out.println("\n==== TEST SUMMARY ====");
        System.out.println("Passed: " + passed + "/" + total);
        if (passed != total) {
            System.exit(1);
        }
    }
}
