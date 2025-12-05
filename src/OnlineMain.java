import core.OnlineCourse;
import core.Course;

public class OnlineMain {
    public static void main(String[] args) {
        // a. Create a reference variable of type Course.
        Course courseRef;

        // b. Assign an object of type OnlineCourse to this reference.
        OnlineCourse onlineCourse = new OnlineCourse("CS101", "Introduction to Programming", "Zoom");
        courseRef = onlineCourse; // Assign the OnlineCourse object to the Course reference.

        // c. Call the showDetails() method on the Course reference and explain in
        // comments why the OnlineCourse's overridden method is executed.
        courseRef.showDetails();
        // Dynamic binding occurs here.
        // The JVM determines at runtime which version of the showDetails() method
        // to execute. Since courseRef is a reference to an OnlineCourse object,
        // the OnlineCourse's overridden version is called.
        // This is because the JVM uses the type of the reference (Course) to resolve
        // the method call, but the object itself is an OnlineCourse.
        // The JVM checks the object's type (OnlineCourse) and calls the
        // corresponding method.

        // Concepts explored here:
        // 1. Dynamic Binding (Runtime Polymorphism):  The ability of a program to
        //    determine which method to execute at runtime based on the actual
        //    object type, rather than the reference type.
        // 2. Method Overriding: When a subclass provides a specific implementation
        //    of a method that is already defined in its superclass.
        // 3. References vs. Objects:  A reference (like courseRef) holds the
        //    memory address of an object, but it doesn't contain the object itself.
        //    Therefore, the reference can point to different object types at different
        //    times.
        // 4. Virtual Method Calls:  Java uses virtual method calls to achieve dynamic
        //    binding. When a virtual method is called, the JVM resolves the method
        //    at runtime, regardless of the declared type of the reference.
    }
}
