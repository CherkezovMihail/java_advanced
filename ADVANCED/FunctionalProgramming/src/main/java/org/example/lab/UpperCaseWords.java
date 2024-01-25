package org.example.lab;

import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class UpperCaseWords {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> words = Arrays.stream(scanner.nextLine().split(" ")).toList();

        Predicate<String> isStartingWithUpperCase = w -> Character.isUpperCase(w.charAt(0));

        List<String> onlyUpperCaseWords = new ArrayList<>();

        words.stream().filter(isStartingWithUpperCase)
                .forEach(onlyUpperCaseWords::add);

        System.out.println(onlyUpperCaseWords.size());
        onlyUpperCaseWords.forEach(System.out::println);
    }

}
