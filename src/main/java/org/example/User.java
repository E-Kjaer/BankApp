package org.example;

import java.util.ArrayList;
import java.util.Objects;

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

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public boolean equals(User user) {
        return this.id == user.getId();
    }
}
