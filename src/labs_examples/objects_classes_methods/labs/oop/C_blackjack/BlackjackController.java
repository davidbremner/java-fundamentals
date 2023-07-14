package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.Objects;
import java.util.Scanner;

public class BlackjackController {
    public static void main(String[] args){
        // NOTE TO SELF: do final variables at the end if it can be done (and caps the variable names!)

        System.out.println("-----BlackJack game starting-----");
        playBlackJack();

        }

    private static void playBlackJack() {
        Scanner scanner = new Scanner(System.in);
        int gameStake = 100; // how much the buy in is
        System.out.println("What is your name? ");
        String usersName = scanner.nextLine();

        // creating the user and the computer bot:
        Player playerOne = new Player(usersName, gameStake);
        Player playerTwo = new Player("Computer", gameStake);

        // creating the games deck of cards:
        Deck cardDeck = new Deck();

        // deal 2 cards each:
        cardDeck.deal(playerOne);
        cardDeck.deal(playerTwo);
        cardDeck.deal(playerOne);
        cardDeck.deal(playerTwo);

        System.out.println("\nTwo cards to you " + playerOne.getName() + " and two cards to the opponent, " +
                playerTwo.getName() + ".");

        String usersAnswer = "yes"; // to trigger while loop
        int betAmount = 0;

        while ((Objects.equals(usersAnswer, "yes") || playerTwo.computerAI())) {

            if (playerOne.getPotValue() != 0) {
                System.out.println("\n" + usersName + ", your cards: " + playerOne.getHand().getCards() +
                        "\nThe value of your hand is: " + playerOne.getHand().returnScore());
                System.out.println("How much would you like to bet on your hand?\nAvailable pot: €" + playerOne.getPotValue());
                betAmount = scanner.nextInt();
                scanner.nextLine(); // throw away line
                if (playerOne.canPlaceBet(betAmount)) {
                    System.out.println("You have placed a bet of €" + betAmount +
                            ". Making the current potential winnings: €" +
                            (playerOne.calculatePot(betAmount, gameStake) + playerTwo.calculatePot(betAmount, gameStake)) +
                            ". Leaving €" + playerOne.getPotValue() + " to play with.");
                } else {
                    System.out.println("Unfortunately you don't have that much to bet with so you go all in with: €" +
                            playerOne.getPotValue() + ". Making the current potential winnings: €" +
                            (playerOne.calculatePot(playerOne.getPotValue(), gameStake) + playerTwo.calculatePot(playerTwo.getPotValue(), gameStake)) +
                            ". Leaving €" + playerOne.getPotValue() + " to play with.");
                }
            }

            if (!playerOne.getHand().isGreaterBlackjack() && Objects.equals(usersAnswer, "yes")) {
                System.out.println("\nWould you like another card from the deck? yes/no");
                usersAnswer = scanner.nextLine();
                if (Objects.equals(usersAnswer, "yes")) {
                    cardDeck.deal(playerOne);
                    System.out.println(usersName + ", your cards: " + playerOne.getHand().getCards() +
                            "\nThe value of your hand is: " + playerOne.getHand().returnScore());
                }
            }

            if (playerOne.getHand().isGreaterBlackjack() || playerOne.getPotValue() == 0) {
                usersAnswer = "no"; // ensures loop break once AI is finished and doesn't do an unnecessary loop iteration
            }

            if (playerTwo.computerAI()) { // check if computer player wants another card
                cardDeck.deal(playerTwo);
                System.out.println("\n••• " + playerTwo.getName() + " draws another card");
            } else {
                System.out.println("\n• " + playerTwo.getName() + " is sticking");
            }

            System.out.println("\nHit enter to continue..."); // slow down game and give the user time to read
            scanner.nextLine();
        }

        // displaying both players final hands:
        System.out.println("\n⫸FINAL HANDS⫷\n");
        System.out.println("➥ " + playerOne.getName() + ", your cards: " + playerOne.getHand().getCards() +
                "\nThe value of your hand is: " + playerOne.getHand().returnScore());
        System.out.println("➥ " + playerTwo.getName() + "'s cards: " + playerTwo.getHand().getCards() +
                "\nThe value of your opponent's hand is: " + playerTwo.getHand().returnScore());

        System.out.println("\nHit enter to find out who wins..."); // slow down game and give the user time to read
        scanner.nextLine();

        // calculating and announcing the winner:
        if (playerOne.getHand().isGreaterBlackjack() && !playerTwo.getHand().isGreaterBlackjack()) {
            System.out.println("The " + playerTwo.getName() + " wins!");
            System.out.println(playerTwo.getName() + " wins the entire pot of €" +
                    (playerTwo.calculatePot(gameStake) + playerOne.calculatePot(gameStake)));
        } else if (playerTwo.getHand().isGreaterBlackjack() && !playerOne.getHand().isGreaterBlackjack()) {
            System.out.println(playerOne.getName() + " wins!");
            System.out.println(playerOne.getName() + " wins the entire pot of €" +
                    (playerOne.calculatePot(gameStake) + playerTwo.calculatePot(gameStake)));
        } else if (playerTwo.getHand().isGreaterBlackjack() && playerOne.getHand().isGreaterBlackjack()) {
            System.out.println("Both players are bust (over 21), no one wins...");
            System.out.println("The House claims the entire pot of €" +
                    (playerOne.calculatePot(gameStake) + playerTwo.calculatePot(gameStake)));
        } else if (playerOne.getHand().getHandValue() > playerTwo.getHand().getHandValue()) {
            System.out.println(playerOne.getName() + " wins!");
            System.out.println(playerOne.getName() + " wins the entire pot of €" +
                    (playerOne.calculatePot(gameStake) + playerTwo.calculatePot(gameStake)));
        } else if (playerTwo.getHand().getHandValue() > playerOne.getHand().getHandValue()) {
            System.out.println("The " + playerTwo.getName() + " wins!");
            System.out.println(playerTwo.getName() + " wins the entire pot of €" +
                    (playerTwo.calculatePot(gameStake) + playerOne.calculatePot(gameStake)));
        } else {
            System.out.println("Equal points so it ends as a draw!");
            System.out.println("Both players receive their bets back of €" +
                    playerOne.calculatePot(gameStake));
        }

      scanner.close();
    }
}



