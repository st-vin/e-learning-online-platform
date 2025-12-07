package tests.core;

import core.Course;
import core.Student;
import tests.Assertions;

import java.util.List;

public class StudentTest {

    public void testConstructorValidation() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Student(null, "Name", "e@mail.com"),
                "Student regNo null should throw");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Student("   ", "Name", "e@mail.com"),
                "Student regNo blank should throw");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Student("IN1", null, "e@mail.com"),
                "Student name null should throw");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Student("IN1", "   ", "e@mail.com"),
                "Student name blank should throw");
    }

    public void testAddCourseMaintainsBidirectionalLink() {
        Student s = new Student("IN1", "Alice", "a@mail.com");
        Course c = new Course("CS101", "Intro");

        s.addCourse(c);

        Assertions.assertTrue(s.getCourses().contains(c), "Student should contain course after add");
        Assertions.assertTrue(c.getStudents().contains(s), "Course should contain student after add");
    }

    public void testRemoveCourseMaintainsBidirectionalLink() {
        Student s = new Student("IN1", "Alice", "a@mail.com");
        Course c = new Course("CS101", "Intro");

        s.addCourse(c);
        s.removeCourse(c);

        Assertions.assertFalse(s.getCourses().contains(c), "Student should not contain course after remove");
        Assertions.assertFalse(c.getStudents().contains(s), "Course should not contain student after remove");
    }

    public void testGetCoursesUnmodifiable() {
        Student s = new Student("IN1", "Alice", "a@mail.com");
        Course c = new Course("CS101", "Intro");
        s.addCourse(c);

        List<Course> view = s.getCourses();
        Assertions.assertThrows(UnsupportedOperationException.class,
                () -> view.add(new Course("CS102", "Data")),
                "getCourses must be unmodifiable");
    }

    public void testEqualsAndHashCodeBasedOnRegNo() {
        Student s1 = new Student("IN1", "Alice", "a@mail.com");
        Student s2 = new Student("IN1", "Alice Clone", "a2@mail.com");
        Student s3 = new Student("IN2", "Bob", "b@mail.com");

        Assertions.assertTrue(s1.equals(s2), "Students with same regNo must be equal");
        Assertions.assertFalse(s1.equals(s3), "Different regNo should not be equal");
        Assertions.assertEquals(s1.hashCode(), s2.hashCode(), "Equal students must have same hashCode");
    }
}
