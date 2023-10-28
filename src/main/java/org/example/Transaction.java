package org.example;

public class Transaction {
    private int id;
    private Account sender;
    private Account reciever;
    private double amount;
    private boolean finished;

    private static int count;

    public Transaction(Account sender, Account reciever, double amount) {
        this.id = count++;
        this.sender = sender;
        this.reciever = reciever;
        this.amount = amount;
        this.finished = false;
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
        return finished;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Transaction.count = count;
    }

    public void execute() {
        if (!this.finished) {
            this.reciever.deposit(this.amount);
            this.sender.withdraw(this.amount);
            this.finished = true;
            System.out.println("Success: Transaction is complete");
        } else {
            System.out.println("Error: Transaction has been completed");
        }
    }

    @Override
    public String toString() {
        return "Id: " + this.id +
                "; Amount: " + this.amount +
                "; Sender: " + this.sender.getId() +
                "; Reciever: " + this.reciever.getId();
    }

    public boolean equals(Transaction transaction) {
        return this.id == transaction.getId();
    }
}
