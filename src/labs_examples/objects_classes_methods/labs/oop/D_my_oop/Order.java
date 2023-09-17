package labs_examples.objects_classes_methods.labs.oop.D_my_oop;

public class Order {
    private final Merchant MERCHANT;
    private final String ORDER_KRN;
    private final double ORDER_VALUE;
    private double remainingDebt;
    private String completionDate;
    private boolean isActive;

    public Order(Merchant MERCHANT, String ORDER_KRN, double ORDER_VALUE) {
        this.MERCHANT = MERCHANT;
        this.ORDER_KRN = ORDER_KRN;
        this.ORDER_VALUE = ORDER_VALUE;
    }

}
