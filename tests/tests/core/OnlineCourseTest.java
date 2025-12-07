package tests.core;

import core.OnlineCourse;
import core.Student;
import tests.Assertions;

public class OnlineCourseTest {

    public void testPlatformGetterSetter() {
        OnlineCourse oc = new OnlineCourse("CS201", "Algorithms", "Udemy");
        Assertions.assertEquals("Udemy", oc.getPlatform(), "Platform getter should return initial value");
        oc.setPlatform("Coursera");
        Assertions.assertEquals("Coursera", oc.getPlatform(), "Platform setter should update value");
    }

    public void testEnrollInheritedBehavior() {
        OnlineCourse oc = new OnlineCourse("CS202", "Systems", "edX");
        Student s = new Student("IN10", "Jane", "j@mail.com");
        Assertions.assertTrue(oc.enrollStudent(s), "Enrollment in OnlineCourse should work");
        Assertions.assertTrue(oc.getStudents().contains(s), "OnlineCourse should contain enrolled student");
        Assertions.assertTrue(s.getCourses().contains(oc), "Student should contain OnlineCourse after enrollment");
    }
}
