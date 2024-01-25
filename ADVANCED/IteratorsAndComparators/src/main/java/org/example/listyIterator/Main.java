package org.example.listyIterator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String inputData = scanner.nextLine();

        ListyIterator listyIterator =  null;

        while (!inputData.equals("END")) {

            String[] commandArgs = inputData.split(" ");
            String command = commandArgs[0];

            switch (command) {
                case "Create":
                    if (commandArgs.length > 1) {
                        String[] elementArray = Arrays.copyOfRange(commandArgs, 1, commandArgs.length);
                        listyIterator = new ListyIterator(elementArray);
                    } else {
                        listyIterator = new ListyIterator();
                    }
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "Print":
                    try {
                        listyIterator.print();
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "PrintAll":
                    listyIterator.printAll();
                    break;
            }

            inputData = scanner.nextLine();
        }
    }
}
