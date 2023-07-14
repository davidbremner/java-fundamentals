package labs_examples.objects_classes_methods.labs.oop.D_my_oop;

import java.util.ArrayList;

public class BankInformation {
    private String bankName;
    private double balance;
    private ArrayList<Card> cards;

    public BankInformation(String bankName, double balance, Card cards) {
        this.bankName = bankName;
        this.balance = balance;
        this.cards = new ArrayList<>();
        this.cards.add(cards);
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public double getBalance() {
        return balance;
    }

    private void setBalance(double balance) {
        this.balance = balance;
    }

    public void incomingTransaction(double moneyValue) {
        this.balance = getBalance() + moneyValue;
    }

    public boolean outgoingTransaction(double moneyValue) {
        boolean transactionSuccessful = moneyValue >= getBalance();
        setBalance(transactionSuccessful ? getBalance() - moneyValue : getBalance());
        return transactionSuccessful;
    }
}
