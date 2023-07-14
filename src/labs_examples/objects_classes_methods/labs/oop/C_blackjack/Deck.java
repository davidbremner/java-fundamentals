package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private Card[] cards;
    private ArrayList<Integer> usedCards;

    public Deck() {
        cards = new Card[52];
        usedCards = new ArrayList<>();
        populateDeck();
    }

    public Card[] getCards() {
        return getCards();
    }

    public ArrayList<Integer> getUsedCards() {
        return usedCards;
    }

    public void populateDeck() {
        int deckHighestValue = 13;
        int cardCount = 0;
        for (int cardNum = 1; cardNum <= deckHighestValue; cardNum++) {
            for (char suit : new Card().getSuit()) {
                cards[cardCount] = new Card(suit, cardNum);
                cardCount++;
            }
        }
    }

    public void deal(Player player) {
        boolean inUsedCards = true;
        while (inUsedCards) {
            int randomCard = new Random().nextInt(cards.length); // picks random number
            if (!usedCards.contains(randomCard)) {
                player.getHand().getCards().add(cards[randomCard]); // adds the card (using index of randomCard) to the players hand
                usedCards.add(randomCard); // adds the index number of the card that was drawn to know it has been used
                inUsedCards = false; // to break out of loop
            }
        }
    }

}
