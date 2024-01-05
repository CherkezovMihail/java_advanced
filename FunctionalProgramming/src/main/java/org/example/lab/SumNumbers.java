package org.example.lab;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.IntStream;

public class SumNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
//
        Function<int[], String> sum = n -> "Sum = "  + Arrays.stream(n).sum();
//
//        output(sum, numbers);

        System.out.println("Count = " + numbers.length);
        System.out.println(sum.apply(numbers));
    }

//    public static void output(Function<int[], Integer> s, int[] numbers) {
//        int sum = s.apply(numbers);
//
//        System.out.printf("Count = %d%nSum = %d", numbers.length, sum);
//    }
}
