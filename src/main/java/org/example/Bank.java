package org.example;

import java.util.ArrayList;

public class Bank {
    private ArrayList<User> users;
    private int id;
    private String name;

    public Bank(ArrayList<User> users, int id, String name) {
        this.users = users;
        this.id = id;
        this.name = name;
    }

    public Bank(int id, String name) {
        this.users = new ArrayList<User>();
        this.id = id;
        this.name = name;
    }

    public Bank() {
        this.users = new ArrayList<User>();
        this.id = -1;
        this.name = "";
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public User getUser(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addUser(User user) {
        if (this.users.contains(user)) {
            System.out.println("Error: User already exists.");
        } else {
            this.users.add(user);
        }
    }

    public void deleteUser(int id) {
        for (User user : this.users) {
            if (user.getId() == id) {
                this.users.remove(user);
                return;
            }
        }
        System.out.println("Error: User not found");
    }

    public  void updateUser(User updatedUser) {
        for (User user : this.users) {
            if (user.getId() == updatedUser.getId()) {
                user = updatedUser;
                return;
            }
        }
        System.out.println("Error: User not found");
    }
}
