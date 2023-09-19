package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private final Card[] CARDS;
    private final ArrayList<Integer> USED_CARDS;

    public Deck() {
        CARDS = new Card[52];
        USED_CARDS = new ArrayList<>();
        populateDeck();
    }

    public ArrayList<Integer> getUsedCards() {
        return USED_CARDS;
    }

    public void populateDeck() {
        int deckHighestValue = 13;
        int cardCount = 0;
        for (int cardNum = 1; cardNum <= deckHighestValue; cardNum++) {
            for (char suit : new Card().getSuit()) {
                CARDS[cardCount] = new Card(suit, cardNum);
                cardCount++;
            }
        }
    }

    public void deal(Player player) {
        boolean inUsedCards = true;
        while (inUsedCards) {
            int randomCard = new Random().nextInt(CARDS.length); // picks random number
            if (!USED_CARDS.contains(randomCard)) {
                player.getHand().getCards().add(CARDS[randomCard]); // adds the card (using index of randomCard) to the players hand
                USED_CARDS.add(randomCard); // adds the index number of the card that was drawn to know it has been used
                inUsedCards = false; // to break out of loop
            }
        }
    }

}
