package labs_examples.input_output.labs.Exercise_04;

public class Transaction {
    private String firstName;
    private String lastName;
    private String email;
    private String paymentMethod;
    private double purchaseAmount;
    private String currency;

    public Transaction() {}

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setPurchaseAmount(double purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", purchaseAmount=" + purchaseAmount +
                ", currency='" + currency + '\'' +
                '}';
    }
}
