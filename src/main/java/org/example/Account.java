package org.example;

import java.util.ArrayList;

public class Account {
    private int id;
    private String name;
    private User user;
    private double balance;
    private ArrayList<Transaction> transactions;

    private static int count;

    public Account(String name, User user, double balance, ArrayList<Transaction> transactions) {
        this.id = count++;
        this.name = name;
        this.user = user;
        this.balance = balance;
        this.transactions = transactions;
    }

    public Account(String name, User user, double balance) {
        this.id = count++;
        this.name = name;
        this.user = user;
        this.balance = balance;
        this.transactions = new ArrayList<Transaction>();
    }

    public Account(String name, User user) {
        this.id = count++;
        this.name = name;
        this.user = user;
        this.balance = 0;
        this.transactions = new ArrayList<Transaction>();
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public User getUser() {
        return user;
    }

    public double getBalance() {
        return this.balance;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Account.count = count;
    }

    public double withdraw(double amount) {
        if (this.balance >= amount && amount > 0) {
            this.balance -= amount;
            return amount;
        } else {
            System.out.println("Error: Insufficient funds");
            return -1;
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        } else {
            System.out.println("Error: Deposit amount must be greater than 0");
        }
    }

    public void addTransaction(Transaction transaction) {
        if (this.transactions.contains(transaction)) {
            System.out.println("Error: Transaction already exists.");
        } else {
            this.transactions.add(transaction);
        }
    }

    public void deleteTransaction(int id) {
        for (Transaction transaction : this.transactions) {
            if (transaction.getId() == id) {
                this.transactions.remove(transaction);
                return;
            }
        }
        System.out.println("Error: Transaction not found");
    }

    public void updateTransaction(Transaction updatedTransaction) {
        for (Transaction transaction : this.transactions) {
            if (transaction.getId() == updatedTransaction.getId()) {
                transaction = updatedTransaction;
                return;
            }
        }
        System.out.println("Error: Transaction not found");
    }

    @Override
    public String toString() {
        return "Id: " + this.id + "; Name: " + this.name + "; Balance: " + this.balance;
    }

    public boolean equals(Account account) {
        return this.id == account.getId();
    }
}
