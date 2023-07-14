package labs_examples.objects_classes_methods.labs.oop.D_my_oop;

public class CustomerProfile {
    private final String CUSTOMER_NAME;
    private final String DOB;
    private String address;
    private BankInformation bankInformation;
    private Order[] customerOrders;
    private Card[] cards;
    private PaymentHistory paymentHistory;

    public CustomerProfile(String CUSTOMER_NAME, String DOB, String address, BankInformation bankInformation) {
        this.CUSTOMER_NAME = CUSTOMER_NAME;
        this.DOB = DOB;
        this.address = address;
        this.bankInformation = bankInformation;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCUSTOMER_NAME() {
        return CUSTOMER_NAME;
    }

    public String getDOB() {
        return DOB;
    }

    public String getAddress() {
        return address;
    }

}
