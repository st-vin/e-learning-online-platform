import exceptions.GradeNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // 1. Data storage using hashmap
        HashMap<String, Integer> studentGrades = new HashMap<>();

        // add sample student entries
        studentGrades.put("Alicia", 70);
        studentGrades.put("Brandon", 97);
        studentGrades.put("Claire", 84);


        // 2. Iteration over hashmap using enhanced for-loop
        for (Map.Entry<String, Integer> entry : studentGrades.entrySet()) {
            System.out.println("Name: " + entry.getKey() + " | Grade: " + entry.getValue());
        }

        // 3. Exception Handling: Missing student grade
        String studentToFind = "Daniel"; // student not added in the map
        try {
            int grade = getStudentGrade(studentGrades, studentToFind);
            System.out.println("\nGrade for " + studentToFind + " is " + grade);
        } catch (GradeNotFoundException ex) {
            System.out.println("\nError: " + ex.getMessage());
        }
    }

    private static int getStudentGrade(HashMap<String, Integer> gradesMap, String studentName)
        throws GradeNotFoundException {

            // Key missing → throw custom exception
            if (!gradesMap.containsKey(studentName)) {
                throw new GradeNotFoundException(
                        "Grade not found for student: " + studentName
                );
            }

            // Key exists but value may be null (legal HashMap scenario)
            Integer grade = gradesMap.get(studentName);

            if (grade == null) {
                throw new GradeNotFoundException(
                        "Grade for student '" + studentName + "' is stored as null."
                );
            }

            return grade;
        }
    }
