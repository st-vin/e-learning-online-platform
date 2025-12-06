package exceptions;

/**
 * Custom exception thrown when a requested student's grade
 * cannot be found in the HashMap.
 */
public class GradeNotFoundException extends Exception {

    // Constructor that accepts custom error message.
    public GradeNotFoundException(String message) {
        super(message);
    }
}
