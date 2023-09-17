package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

public class Player {
    private final String NAME;
    private Hand hand;
    private int potValue; // the amount of money the player has
    private int totalGamesWon;
    static private int totalGames;

    public Player(String NAME, int potValue) {
        this.NAME = NAME;
        this.potValue = potValue;
        this.hand = new Hand();
    }

    public String getNAME() {
        return NAME;
    }

    public Hand getHand() {
        return hand;
    }

    public int getPotValue() {
        return potValue;
    }

    public void setPotValue(int potValue) {
        this.potValue = potValue;
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

    public void clearPlayerHand() { // for when new game starts to empty the users hand of cards
        this.hand = new Hand();
    }

    static public void setTotalGames(int numOfGames) {
        totalGames = numOfGames;
    }

    static public int getTotalGames() {
        return totalGames;
    }

    static public int gameSummary(Player playerOne, Player playerTwo) {
        System.out.println("\nGames left to be played are " + totalGames + ".");
        System.out.println("Total games won by each player are as follows:\n"
                + " • " + playerOne.NAME + ": " + playerOne.getTotalGamesWon()
                + "\n • " + playerTwo.NAME + ": " + playerTwo.getTotalGamesWon()); // example for exercise purposes
        return totalGames;
    }

    static public void reduceGamePlayed() {
        totalGames -= 1;
    }

    public void gameWon() {
        totalGamesWon += 1;
    }

    private int getTotalGamesWon() {
        return totalGamesWon;
    }
}
