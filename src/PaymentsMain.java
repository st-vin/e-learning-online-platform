import core.Student;
import payments.FullTimeLecturer;
import payments.PartTimeLecturer;
import payments.Payable;

import java.util.*;

/**
 * A test class demonstrating:
 * - Interface polymorphism with Payable
 * - Payment calculations for full-time and part-time lecturers
 * - Sorting students using the Comparable interface
 * - Edge case handling
 */
public class PaymentsMain {

    public static void main(String[] args) {

        System.out.println("--- Testing Payable Implementations ---");

        // Full-time lecturer test
        Payable ft = new FullTimeLecturer();
        System.out.println(ft + " -> Payment: " + ft.calculatePayment());

        // Part-time lecturer tests (including an edge case)
        Payable pt1 = new PartTimeLecturer(20, 1500);
        Payable pt2 = new PartTimeLecturer(400, 2000);

        System.out.println(pt1 + " -> Payment: " + pt1.calculatePayment());
        System.out.println(pt2 + " -> Payment: " + pt2.calculatePayment());

        System.out.println("\n--- Testing Student Sorting Using Comparable ---");

        List<Student> list = new ArrayList<>();
        list.add(new Student("CT202/1234/20", "Alice"));
        list.add(new Student("CT202/0456/20", "Brian"));
        list.add(new Student("CT202/9876/20", "Mary"));

        System.out.println("Before Sorting:");
        list.forEach(System.out::println);

        Collections.sort(list); // Uses compareTo()

        System.out.println("\nAfter Sorting:");
        list.forEach(System.out::println);
    }
}