package core;
import java.util.ArrayList;

public class Course {
    private String courseCode;
    private String courseTitle;
    private ArrayList<Student> students;

    // no argument constructor
    public Course(){
        students = new ArrayList<>();
        courseCode  = "null";
        courseTitle = "null";
    }

    // courseCode & courseTitle constructor
    public Course(String courseCode, String courseTitle) {
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        students = new ArrayList<>();
    }

    // getters & setters
    public String  getCourseCode() {return courseCode;}
    public void setCourseCode(String courseCode) {this.courseCode = courseCode;}

    public String getCourseTitle() {return courseTitle;}
    public void setCourseTitle(String courseTitle) {this.courseTitle = courseTitle;}

    public ArrayList<Student> getStudents() {return students;}
    //public void setStudents() {this.students = students;}
    public void enrollStudent(Student student) {students.add(student);}
    public void removeStudent(Student student) {students.remove(student);}
    //public void setStudents(ArrayList<Student> students) {this.students = students;}

    public void printStudents(){
        for(Student student : students){
            System.out.println(student.getFirstName() + " " + student.getLastName());
        }
    }
}
