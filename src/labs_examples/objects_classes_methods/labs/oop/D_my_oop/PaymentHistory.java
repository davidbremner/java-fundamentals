package labs_examples.objects_classes_methods.labs.oop.D_my_oop;

public class PaymentHistory {
    private int numOfLatePayments;
    private int numOfCreditMarks;

    public PaymentHistory(int numOfLatePayments, int numOfCreditMarks) {
        this.numOfLatePayments = numOfLatePayments;
        this.numOfCreditMarks = numOfCreditMarks;
    }

    public void addLatePayment() {
        numOfLatePayments += 1;
    } // to come from ServicingSystem

    public void addCreditMark() {
        numOfCreditMarks += 1;
    } // to come from ServicingSystem
}
