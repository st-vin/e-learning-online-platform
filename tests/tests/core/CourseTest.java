package tests.core;

import core.Course;
import core.Student;
import tests.Assertions;

import java.util.List;

public class CourseTest {

    public void testConstructorValidation() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Course(null, "Title"),
                "Course code null should throw");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Course("   ", "Title"),
                "Course code blank should throw");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Course("CS101", null),
                "Course title null should throw");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Course("CS101", "   "),
                "Course title blank should throw");
    }

    public void testEnrollStudentMaintainsBidirectionalLink() {
        Course c = new Course("CS101", "Intro");
        Student s = new Student("IN1", "Alice", "a@mail.com");

        boolean enrolled = c.enrollStudent(s);
        Assertions.assertTrue(enrolled, "First enrollment should return true");
        Assertions.assertTrue(c.getStudents().contains(s), "Course should contain student after enroll");
        Assertions.assertTrue(s.getCourses().contains(c), "Student should contain course after enroll");
    }

    public void testEnrollStudentDuplicatePrevention() {
        Course c = new Course("CS101", "Intro");
        Student s = new Student("IN1", "Alice", "a@mail.com");

        Assertions.assertTrue(c.enrollStudent(s), "First enrollment should be true");
        Assertions.assertFalse(c.enrollStudent(s), "Duplicate enrollment should be false");
        Assertions.assertEquals(1, c.getStudents().size(), "Only one enrollment expected");
        Assertions.assertEquals(1, s.getCourses().size(), "Only one course expected on student side");
    }

    public void testRemoveStudentMaintainsBidirectionalLink() {
        Course c = new Course("CS101", "Intro");
        Student s = new Student("IN1", "Alice", "a@mail.com");
        c.enrollStudent(s);

        boolean removed = c.removeStudent(s);
        Assertions.assertTrue(removed, "Removal should return true");
        Assertions.assertFalse(c.getStudents().contains(s), "Course should not contain student after removal");
        Assertions.assertFalse(s.getCourses().contains(c), "Student should not contain course after removal");
    }

    public void testGetStudentsUnmodifiable() {
        Course c = new Course("CS101", "Intro");
        Student s = new Student("IN1", "Alice", "a@mail.com");
        c.enrollStudent(s);

        List<Student> view = c.getStudents();
        Assertions.assertThrows(UnsupportedOperationException.class,
                () -> view.add(new Student("IN2", "Bob", "b@mail.com")),
                "getStudents must be unmodifiable");
    }

    public void testEqualsAndHashCodeBasedOnCode() {
        Course c1 = new Course("CS101", "Intro");
        Course c2 = new Course("CS101", "Intro 2");
        Course c3 = new Course("CS102", "Data");

        Assertions.assertTrue(c1.equals(c2), "Courses with same code must be equal");
        Assertions.assertFalse(c1.equals(c3), "Different codes should not be equal");
        Assertions.assertEquals(c1.hashCode(), c2.hashCode(), "Equal courses must have same hashCode");
    }
}
