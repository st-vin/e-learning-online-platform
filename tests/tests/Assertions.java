package tests;

public final class Assertions {
    private Assertions() {}

    public static void assertTrue(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }

    public static void assertFalse(boolean condition, String message) {
        if (condition) throw new AssertionError(message);
    }

    public static void assertEquals(Object expected, Object actual, String message) {
        if (expected == null && actual == null) return;
        if (expected != null && expected.equals(actual)) return;
        throw new AssertionError(message + " | expected=" + expected + ", actual=" + actual);
    }

    public static void assertNotNull(Object obj, String message) {
        if (obj == null) throw new AssertionError(message);
    }

    public static void assertThrows(Class<? extends Throwable> expected, Runnable runnable, String message) {
        try {
            runnable.run();
        } catch (Throwable t) {
            if (expected.isInstance(t)) {
                return; // success
            }
            throw new AssertionError(message + " | expected exception: " + expected.getName() + ", but got: " + t.getClass().getName(), t);
        }
        throw new AssertionError(message + " | expected exception: " + expected.getName() + ", but nothing was thrown");
    }
}
