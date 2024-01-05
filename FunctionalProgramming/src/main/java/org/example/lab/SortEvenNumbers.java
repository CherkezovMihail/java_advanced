package org.example.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .toList();

        List<Integer> evenNumbers = new ArrayList<>();

        numbers.stream().filter(n -> n % 2 == 0).forEach(evenNumbers::add);

        System.out.println(evenNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));

        System.out.println(evenNumbers.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));


//        System.out.print(String.join(", ", evenNumbers.stream().map(String::valueOf).toList()));
//        System.out.println();
//        System.out.print(String.join(", ", evenNumbers.stream().sorted().map(String::valueOf).toList()));


//        evenNumbers.stream().sorted().forEach(System.out::println);
    }
}
