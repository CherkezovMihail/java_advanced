package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner =  new Scanner(System.in);

        int n = scanner.nextInt();

        printTopPart(n);
        printMiddlePart(n);
        printBottomPart(n);

    }

    private static void printBottomPart(int n) {
        for (int row = n - 1; row >= 1; row--) {
            printRow(n, row);
        }
    }

    private static void printMiddlePart(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print("* ");
        }
        System.out.println();
    }

    private static void printTopPart(int n) {
        for (int row = 1; row <= n - 1; row++) {
            printRow(n, row);
        }
    }

    private static void printRow(int n, int row) {
        for (int space = 1; space <= n - row; space++) {
            System.out.print(" ");
        }
        for (int star = 1; star <= row ; star++) {
            System.out.print("* ");
        }
        System.out.println();
    }
}