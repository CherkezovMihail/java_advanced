package org.example.lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class AddVat {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double[] numbers = Arrays.stream(scanner.nextLine().split(", "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        double vat = 1.20;

        UnaryOperator<Double> addVat = d -> d * vat;

        System.out.println("Prices with VAT:");
        for (double d : numbers) {
            System.out.printf("%.2f%n", addVat.apply(d));
        }
    }
}
