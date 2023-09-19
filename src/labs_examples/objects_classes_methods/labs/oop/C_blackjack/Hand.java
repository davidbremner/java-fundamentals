package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.ArrayList;

public class Hand {
    private final ArrayList<Card> CARDS;
    private int handValue;

    public Hand() {
        this.CARDS = new ArrayList<>(); // needs to be initialized in order to add randomCard to players hand
    }
    public Hand(ArrayList<Card> CARDS, int handValue) {
        this.CARDS = CARDS;
        this.handValue = handValue;
    }

    public ArrayList<Card> getCards() {
        return CARDS;
    }

    public int getHandValue() { // probably just remove. Not needed to get handValue?? As returnScore method does this
        return handValue;
    }

    public int returnScore() {
        handValue = 0;
        int jackQueenKing = 10; // jack, queen or king all equal a score of 10
        for (Card card : CARDS) {
            handValue += Math.min(card.getCardValue(), jackQueenKing); // takes number value of card, if over 10 takes value of 10
        }
        return handValue;
    }

    public boolean isGreaterBlackjack() {return handValue > 21;}
}
