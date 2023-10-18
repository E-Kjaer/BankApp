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
        this.user.addAccount(this);
    }

    public Account(String name, User user, double balance) {
        this.id = count++;
        this.name = name;
        this.user = user;
        this.balance = balance;
        this.transactions = new ArrayList<Transaction>();
        this.user.addAccount(this);
    }

    public Account(String name, User user) {
        this.id = count++;
        this.name = name;
        this.user = user;
        this.balance = 0;
        this.transactions = new ArrayList<Transaction>();
        this.user.addAccount(this);
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

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public static int getCount() {
        return count;
    }

    public double getBalance() {
        return this.balance;
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
}
