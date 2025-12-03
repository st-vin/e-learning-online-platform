package core;

import java.util.ArrayList;

public class Student {
    private String regNumber;
    private String firstName;
    private String lastName;
    private String email;
    private ArrayList<Course> courses;

    // No argument constructor
    public Student() {
        regNumber = "null";
        firstName = "null";
        lastName = "null";
        email = "null";
        courses = new ArrayList<>();
    }

    // All argument constructor
    public Student(String firstName, String lastName, String email,  String regNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.regNumber = regNumber;
        courses = new ArrayList<>();
    }
    // firstName & lastname Constructor
    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        courses = new ArrayList<>();
    }

    // regNumber constructor
    public Student(String regNumber) {
        this.regNumber = regNumber;
        courses = new ArrayList<>();
    }

    // getters & setters
    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getRegNumber() {return regNumber;}
    public void setRegNumber(String regNumber) {this.regNumber = regNumber;}

    public ArrayList<Course> getCourses() {return courses;}
    public void addCourse(Course course) {courses.add(course);}

    public void printCourses() {
        for (Course course : courses) {
            System.out.println(course.getCourseCode() + " " + course.getCourseTitle());
        }
    }

}
