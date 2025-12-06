package payments;

public class PartTimeLecturer implements Payable {
    private double rate;
    private double hours;

    public PartTimeLecturer(double rate, double hours) {
        if (rate < 0 || hours < 0) {
            throw new IllegalArgumentException("Rate and Hours cannot be negative");
        }
        this.rate = rate;
        this.hours = hours;
    }
    @Override
    public double calculatePayment() {
        return rate * hours;
    }

    @Override
    public String toString() {
        return "PartTimeLecturer{" +
                "rate=" + rate +
                ", hours=" + hours +
                '}';
    }
}
