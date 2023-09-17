package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.Arrays;

public class Card {
    private char[] suit = new char[]{'♠', '♦', '♥', '♣'};
    private int cardValue;

    public Card(){}

    public Card(char suit, int cardValue) {
        this.suit = new char[]{suit};
        this.cardValue = cardValue;
    }

    public char[] getSuit() {
        return suit;
    }

    public int getCardValue() {
        return cardValue;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + Arrays.toString(suit) +
                ", cardValue=" + cardValue +
                '}';
    }
}
