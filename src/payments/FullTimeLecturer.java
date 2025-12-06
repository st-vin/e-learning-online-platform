package payments;

public class FullTimeLecturer implements Payable {
    private static final double FIXED_SALARY = 50000.00;
    @Override
    public double calculatePayment() {
        return FIXED_SALARY;
    }

    @Override
    public String toString() {
        return "FullTimeLecturer [Salary = " + FIXED_SALARY + "]";
    }
}
