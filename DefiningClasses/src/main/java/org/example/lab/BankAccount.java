package org.example.lab;

public class BankAccount {
    private static int nextId = 1;
    private static double interestRate = 0.02;
    private int id;
    private double balance;

    public BankAccount() {
        this.id = nextId;
        nextId++;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public double getInterest(int year) {
        return this.balance * year * interestRate;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public int getId() {
        return this.id;
    }
}
