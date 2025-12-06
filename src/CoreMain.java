import core.Student;
import core.Course;

public class CoreMain {
    public static void main(String[] args) {
        Student student = new Student("in130002323", "Mark", "m@mail.com");
        Student student2 = new Student("in140001823", "Maria", "maria@mail.com");
        Student student3 = new Student("in130003323", "Marty", "marty@email.com");
        Student student5 = new Student("in140001823", "Maria", "maria@mail.com");

        Course course = new Course("CS101", "Java Programming");

        // Option 1: Enroll from the course side
        course.enrollStudent(student);
        course.enrollStudent(student2);
        course.enrollStudent(student3);
        course.enrollStudent(student5);
        // Result: student is in course.getStudents() AND course is in student.getCourses()

        // Option 2: Add from student side
        Course course2 = new Course("CS102", "Data Structures");
        student.addCourse(course2);
        // Result: course2 is in student.getCourses() AND student is in course2.getStudents()

        // Both sync
        System.out.println("Student's courses:");
        student.printCourses();

        System.out.println("\nCourse enrollments:");
        String string = course.getStudents().toString();
        System.out.println(string);
        course.showDetails();
    }

}