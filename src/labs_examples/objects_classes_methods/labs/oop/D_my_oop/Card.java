package labs_examples.objects_classes_methods.labs.oop.D_my_oop;

public class Card {
    private final long CARD_NUMBER;
    private final String EXPIRY_DATE;
    private boolean isActive;

    public Card(long CARD_NUMBER, String EXPIRY_DATE) {
        this.CARD_NUMBER = CARD_NUMBER;
        this.EXPIRY_DATE = EXPIRY_DATE;
        this.isActive = true; // update this with an if statement/try-catch if already expired
    }

    public long getCARD_NUMBER() {
        return CARD_NUMBER;
    }
    public String getEXPIRY_DATE() {
        return EXPIRY_DATE;
    }
}
