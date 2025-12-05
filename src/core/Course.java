package core;

import java.util.*;

public class Course {
    private final String courseCode;  // Final - can't change after construction
    private String courseTitle;
    private final List<Student> students;

    public Course(String courseCode, String courseTitle) {
        if (courseCode == null || courseCode.trim().isEmpty()) {
            throw new IllegalArgumentException("Course code cannot be null or empty");
        }
        if (courseTitle == null || courseTitle.trim().isEmpty()) {
            throw new IllegalArgumentException("Course title cannot be null or empty");
        }
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.students = new ArrayList<>();
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        if (courseTitle == null || courseTitle.trim().isEmpty()) {
            throw new IllegalArgumentException("Course title cannot be null or empty");
        }
        this.courseTitle = courseTitle;
    }

    public List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }

    public boolean enrollStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Cannot enroll null student");
        }
        if (students.contains(student)) {
            return false;  // Already enrolled
        }
        students.add(student);
        student.addCourseInternal(this);
        return true;
    }

    public boolean removeStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Cannot remove null student");
        }
        boolean removed = students.remove(student);
        if (removed) {
            student.removeCourseInternal(this);
        }
        return removed;
    }

    void enrollStudentInternal(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    void removeStudentInternal(Student student) {
        students.remove(student);
    }

    public void showDetails() {
        System.out.println("Course Code: " + courseCode + "Course Title: " + courseTitle);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(courseCode, course.courseCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseCode);
    }
    @Override
    public String toString() {
        return String.format("Course{code='%s', title='%s', enrolled=%d}",
                courseCode, courseTitle, students.size());
    }
}