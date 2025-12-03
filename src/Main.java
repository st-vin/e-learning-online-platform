import core.Student;
import core.Course;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Mark", "Ruffalo", "mail@mail.com", "in130002323");
        student.setLastName("Whalberg");
        System.out.println("The first name is:" + student.getFirstName());
        System.out.println("The last name is:" + student.getLastName());
        System.out.println("The registration number is:" + student.getRegNumber());
        System.out.println("The email is:" + student.getEmail());
        Course course2 = new Course("comp 306", "Python");
        Course course3 = new Course("comp 315", "Web Development");
        student.addCourse(course2);
        student.addCourse(course3);

        Course course = new Course("comp 305", "Java");

        course.enrollStudent(student);

        System.out.println("Course Code" + course.getCourseCode());
        System.out.println("Course Title" + course.getCourseTitle());
        System.out.println("Course Enrollment" + course.getStudents());
        course.printStudents();
        student.printCourses();
    }

}
