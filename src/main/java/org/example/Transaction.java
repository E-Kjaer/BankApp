package org.example;

public class Transaction {
    private int id;
    private Account sender;
    private Account reciever;
    private double amount;
    private boolean isFinished;

    private static int count;

    public Transaction(Account sender, Account reciever, double amount) {
        this.id = count++;
        this.sender = sender;
        this.reciever = reciever;
        this.amount = amount;
        this.isFinished = false;
    }

    public void execute() {
        if (!this.isFinished) {
            this.reciever.deposit(this.amount);
            this.sender.withdraw(this.amount);
            this.isFinished = true;
            System.out.println("Success: Transaction is complete");
        } else {
            System.out.println("Error: Transaction has been completed");
        }
    }

    public int getId() {
        return id;
    }

    public Account getSender() {
        return sender;
    }

    public Account getReciever() {
        return reciever;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public static int getCount() {
        return count;
    }

    public boolean equals(Transaction transaction) {
        return this.id == transaction.getId();
    }
}
