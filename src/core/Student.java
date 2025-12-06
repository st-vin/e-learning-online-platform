package core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Student implements Comparable<Student> {
    private String regNo;
    private String name;
    private String email;
    private ArrayList<Course> courses;

    // No argument constructor
    public Student() {
        this.regNo = null;
        this.name = null;
        this.email = null;
        this.courses = new ArrayList<>();
    }

    // All argument constructor
    public Student(String regNo, String name, String email) {
        if (regNo == null || regNo.trim().isEmpty()) {
            throw new IllegalArgumentException("Registration number cannot be null or empty");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.regNo = regNo;
        this.name = name;
        this.email = email;
        this.courses = new ArrayList<>();
    }

    public Student(String regNo, String name) {
        this.regNo = regNo;
        this.name = name;
    }

    // Getters and Setters
    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        if (regNo == null || regNo.trim().isEmpty()) {
            throw new IllegalArgumentException("Registration number cannot be null or empty");
        }
        this.regNo = regNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns an unmodifiable view of the student's courses.
     * This prevents external modification of the internal list.
     */
    public List<Course> getCourses() {
        return Collections.unmodifiableList(courses);
    }

    /**
     * addCourse method maintains bidirectional relationship consistency by
     * automatically updating both the student's course list and the
     * course's student list.
     */
    public void addCourse(Course course) {
        if (course == null) {
            throw new IllegalArgumentException("Cannot add null course");
        }
        if (!courses.contains(course)) {
            courses.add(course);
            course.enrollStudentInternal(this);  // Sync the other side
        }
    }

    /**
     * PACKAGE-PRIVATE method called only by Course class to maintain
     * bidirectional relationship. This prevents infinite recursion.
     */
    void addCourseInternal(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

     // Maintains bidirectional relationship consistency.
    public void removeCourse(Course course) {
        if (course == null) {
            throw new IllegalArgumentException("Cannot remove null course");
        }
        if (courses.remove(course)) {
            course.removeStudentInternal(this);  // Sync the other side
        }
    }

     // PACKAGE-PRIVATE method called only by Course class.
    void removeCourseInternal(Course course) {
        courses.remove(course);
    }

     // Prints all courses this student is enrolled in.
    public void printCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses enrolled");
            return;
        }
        System.out.println("Courses for " + name + ":");
        for (Course course : courses) {
            System.out.println("  " + course.getCourseCode() + " - " + course.getCourseTitle());
        }
    }

    /**
     * Compares students based on their registration number.
     * Two students are equal if they have the same regNo.
     *
     * @param o the object to compare
     * @return true if students have the same regNo
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(regNo, student.regNo);
    }

    /**
     * Hash code based on registration number.
     * @return hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(regNo);
    }

    /**
     * String representation of student.
     * @return formatted string with student details
     */
    @Override
    public String toString() {
        return String.format("Student{regNo='%s', name='%s', email='%s', courses=%d}",
                regNo, name, email, courses.size());
    }
/*    @Override
    public String toString() {
        return String.format("Student{regNo='%s', name='%s', email='%s'}",
                regNo, name, email);
    }*/
    @Override
    public int compareTo(Student other) {
        return this.regNo.compareTo(other.regNo);
    }
}