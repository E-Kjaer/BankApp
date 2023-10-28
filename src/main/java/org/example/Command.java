package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Command {
    public Bank bank;
    private Scanner scanner;
    public User activeUser;
    public boolean isDone = false;

    public Command(Bank bank) {
        this.bank = bank;
        this.scanner = new Scanner(System.in);
        this.activeUser = null;
    }

    public void identifyUser() {
        System.out.print("Please enter id of user: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Please enter password of user: ");
        String password = scanner.nextLine();

        for (User user : this.bank.getUsers()) {
            if (user.getId() == id && user.checkPassword(password)) {
                this.activeUser = user;
                System.out.println("# Welcome " + this.activeUser.getName() + " #\n");
                return;
            }
        }
        System.out.println("Error: User not found");
    }

    public void executeCommands() {
        //Check if user is admin
        if (activeUser.isAdmin()) {
            System.out.print("Select admin command:\n" +
                    "Add user: AU\n" +
                    "Delete user: DU\n" +
                    "Update user: UU\n" +
                    "Print users: PU\n" +
                    "Add account: AA\n" +
                    "Delete account: DA\n" +
                    "Exit: X\n" +
                    "> ");
        } else {
            System.out.print("Select command:\n" +
                    "Exit: X\n" +
                    "> ");
        }

        String input = "";
        while (input.equals("")) {
           input = scanner.nextLine();
        }

        //Check if user is admin
        if (activeUser.isAdmin()) {
            switch (input.toUpperCase()) {
                case "AU" -> addUser();
                case "DU" -> deleteUser();
                case "UU" -> updateUser();
                case "PU" -> printUsers();
                case "AA" -> addAccount();
                case "DA" -> deleteAccount();
                case "X" -> exit();
                default -> System.out.println("Error: Command not recognised");
            }
        } else {
            switch (input.toUpperCase()) {
                case "X" -> exit();
                default -> System.out.println("Error: Command not recognised");
            }
        }

    }

    public void addUser() {
        System.out.println("Command: Add User");
        System.out.println("Enter admin: ");
        boolean admin = Boolean.getBoolean(scanner.nextLine());
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        bank.addUser(new User(admin, name, email, password));

        System.out.println("User: '" + name + "' Successfully added to the system\n");
    }

    public void deleteUser() {
        System.out.println("Command: Delete User");
        System.out.print("Enter id of user to be deleted: ");

        int id = Integer.parseInt(scanner.nextLine());
        bank.deleteUser(id);

        System.out.println("User deleted\n");
    }

    public void updateUser() {
        System.out.println("Command: Update User");
        System.out.println("Enter admin: ");
        boolean admin = Boolean.getBoolean(scanner.nextLine());
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        //Add try catch, to check if user is updated correctly
        bank.updateUser(new User(admin, name, email, password));

        System.out.println("User: '" + name + "' Successfully updated in system\n");
    }

    public void printUsers() {
        System.out.println("Command: Print Users");
        for (User user : bank.getUsers()) {
            System.out.println("Id: " + user.getId() + " Name: " + user.getName());
        }
        System.out.println();
    }

    public void addAccount() {
        System.out.println("Command: Add Account");
        User user;
        double balance;

        if (activeUser.isAdmin()) {
            System.out.print("Enter id of user: ");
            user = bank.getUser(Integer.parseInt(scanner.nextLine()));
            System.out.println("Enter balance for new account: ");
            balance = Double.parseDouble(scanner.nextLine());
        } else {
            user = activeUser;
            balance = 0;
        }

        System.out.print("Enter name of account: ");
        String name = scanner.nextLine();

        Account account = new Account(name, user, balance);
        user.addAccount(account);
    }

    public void deleteAccount() {
        System.out.println("Command: Delete Account");
        User user;

        if (activeUser.isAdmin()) {
            System.out.print("Enter id of user: ");
            user = bank.getUser(Integer.parseInt(scanner.nextLine()));
        } else {
            user = activeUser;
        }

        System.out.println("List of accounts:");
        user.getAccounts().forEach(acc -> System.out.println(acc.toString()));
        System.out.print("Select account to delete: ");

        user.deleteAccount(Integer.parseInt(scanner.nextLine()));
    }

    public void updateAccount() {
        System.out.println("Command: Update Account");
        User user;

        if (activeUser.isAdmin()) {

        }
    }

    public void exit() {
        this.isDone = true;
    }
}
