package org.example.lab;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankAccountApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Integer, BankAccount> bankAccounts = new HashMap<>();

        while (!input.equals("End")) {

            String[] data = input.split(" ");

            String command = data[0];

            switch (command) {
                case "Create" -> {
                    BankAccount ba = new BankAccount();
                    bankAccounts.put(ba.getId(), ba);
                    System.out.printf("Account ID%d created%n", ba.getId());
                }
                case "Deposit" -> {
                    int id = Integer.parseInt(data[1]);
                    double amount = Double.parseDouble(data[2]);

                    if (containsId(bankAccounts, id)) {
                        BankAccount currentBa = bankAccounts.get(id);
                        currentBa.deposit(amount);
                        System.out.printf("Deposited %.0f to ID%d%n", amount, id);

                    } else {
                        System.out.println("Account does not exist");
                    }
                }
                case "SetInterest" -> {
                    double interestRate = Double.parseDouble(data[1]);
                    BankAccount.setInterestRate(interestRate);
                }
                case "GetInterest" -> {
                    int id = Integer.parseInt(data[1]);
                    int year = Integer.parseInt(data[2]);

                    if (containsId(bankAccounts, id)) {
                        BankAccount currentBa = bankAccounts.get(id);
                        System.out.printf("%.2f%n", currentBa.getInterest(year));
                    } else {
                        System.out.println("Account does not exist");
                    }
                }
            }
            input = scanner.nextLine();
        }
    }
    private static boolean containsId(Map<Integer, BankAccount> bankAccounts, int id) {
        return bankAccounts.containsKey(id);
    }
}
