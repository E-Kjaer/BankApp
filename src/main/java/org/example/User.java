package org.example;

import java.util.ArrayList;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private ArrayList<Account> accounts;

    private static int count;

    public User(String name, String email, String password, ArrayList<Account> accounts) {
        this.name = name;
        this.email = email;
        this.id = count++;
        this.password = password;
        this.accounts = accounts;
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.id = count++;
        this.password = password;
        this.accounts = new ArrayList<Account>();

        count++;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public static int getCount() {
        return count;
    }

    public ArrayList<Account> getAccounts() {
        return this.accounts;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
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

    public boolean equals(User user) {
        return this.id == user.getId();
    }
}
