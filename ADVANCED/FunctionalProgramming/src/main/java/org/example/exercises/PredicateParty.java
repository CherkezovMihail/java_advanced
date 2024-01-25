package org.example.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        String command = scanner.nextLine();

        List<String> fNames = new ArrayList<>();

        while (!command.equals("Party!")) {

            String[] commandArgs = command.split(" ");

            String action = commandArgs[0];
            String criteria = commandArgs[1];
            int n = 0;
            String subString = "";

            if (criteria.equals("Length")) {
                n = Integer.parseInt(commandArgs[2]);
            } else {
                subString = commandArgs[2];
            }

            fNames = filterNames(names, action, criteria, n, subString);

            command = scanner.nextLine();
        }

        if (fNames.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.println(fNames.stream().sorted().collect(Collectors.joining(", ")) + " are going to the party!");
        }
    }

    private static List<String> filterNames(List<String> names, String action, String criteria, int n, String subString) {
        if (action.equals("Remove")) {
            if (criteria.equals("Length")) {
                names.removeIf(name -> name.length() == n);
            } else if (criteria.equals("StartsWith") || criteria.equals("EndsWith")) {
                names.removeIf(name -> name.contains(subString));
            }
        } else if (action.equals("Double")) {
            if (criteria.equals("Length")) {
                List<String> toAdd = new ArrayList<>();
                for (String name : names) {
                    if (name.length() == n) {
                        toAdd.add(name);
                    }
                }
                names.addAll(toAdd);
            } else if (criteria.equals("StartsWith") || criteria.equals("EndsWith")) {
                List<String> toAdd = new ArrayList<>();
                for (String name : names) {
                    if (name.contains(subString)) {
                        toAdd.add(name);
                    }
                }
                names.addAll(toAdd);
            }
        }
        return names;
    }
}
