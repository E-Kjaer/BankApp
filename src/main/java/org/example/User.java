package org.example;

import java.util.ArrayList;

public class User {
    private int id;
    private boolean admin = false;
    private String name;
    private String email;
    private String password;
    private ArrayList<Account> accounts;

    private static int count = 0;

    public User(boolean admin, String name, String email, String password, ArrayList<Account> accounts) {
        this.admin = admin;
        this.name = name;
        this.email = email;
        this.id = count++;
        this.password = password;
        this.accounts = accounts;
    }

    public User(boolean admin, String name, String email, String password) {
        this.admin = admin;
        this.name = name;
        this.email = email;
        this.id = count++;
        this.password = password;
        this.accounts = new ArrayList<Account>();
    }

    public int getId() {
        return id;
    }

    public boolean isAdmin() {
        return admin;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return email;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public ArrayList<Account> getAccounts() {
        return this.accounts;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        User.count = count;
    }

    public void addAccount(Account account) {
        if (this.accounts.contains(account)) {
            System.out.println("Error: Account already exists.");
        } else {
            this.accounts.add(account);
        }
    }

    public void deleteAccount(int id) {
        for (Account account : this.accounts) {
            if (account.getId() == id) {
                this.accounts.remove(account);
                return;
            }
        }
        System.out.println("Error: Account not found");
    }

    public void updateAccount(Account updatedAccount) {
        for (Account account : this.accounts) {
            if (account.getId() == updatedAccount.getId()) {
                account = updatedAccount;
                return;
            }
        }
        System.out.println("Error: Account not found");
    }

    @Override
    public String toString() {
        return "Id: " + this.id + "; Name: " + this.name + "; isAdmin: " + this.admin;
    }

    public boolean equals(User user) {
        return this.id == user.getId();
    }
}
