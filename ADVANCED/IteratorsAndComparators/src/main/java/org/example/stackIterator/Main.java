package org.example.stackIterator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.SimpleTimeZone;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String inputCommand = scanner.nextLine();

        StackIterator stackIterator = null;

        while (!inputCommand.equals("END")) {

            String[] splitInput = inputCommand.split(" ");

            String command = splitInput[0];

            switch (command) {
                case "Push":
                    String[] nums = Arrays.copyOfRange(splitInput, 1, splitInput.length);
                    String numbersAsString = "";

                    for (int i = 0; i < nums.length; i++) {
                        String currentNum = nums[i];
                        numbersAsString += currentNum;
                    }

                    List<Integer> numbers = Arrays.stream(numbersAsString.split(","))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList());

                    stackIterator = new StackIterator(numbers);
                    break;
                case "Pop":
                    stackIterator.pop();
                    break;
            }

            inputCommand = scanner.nextLine();
        }

        if (stackIterator.getElements().isEmpty()) {
            System.out.println("No elements");
        }else {
            int cnt = 0;
            while (cnt != 2) {
                for (Integer i : stackIterator) {
                    System.out.println(i);
                }
                cnt += 1;
            }
        }
    }
}
