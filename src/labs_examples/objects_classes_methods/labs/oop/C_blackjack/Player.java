package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

public class Player {
    private String name;
    private Hand hand;
    private int potValue; // the amount of money the player has

    public Player(String name, int potValue) {
        this.name = name;
        this.potValue = potValue;
        this.hand = new Hand();
    }

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }

    public int getPotValue() {
        return potValue;
    }

    public boolean computerAI() {
        return hand.returnScore() < 16;
    }

    public boolean canPlaceBet(int betAmount) {
        return potValue >= betAmount;
    }

    public int calculatePot(int gameStake) {
        return gameStake - potValue;
    }
    public int calculatePot(int betAmount, int gameStake) {
        potValue -= betAmount;
        return gameStake - potValue;
    }
}
