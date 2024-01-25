package org.example.froggy;

import java.net.SocketImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Lake lake = null;

        while (!input.equals("END")) {

            Integer[] numbers = Arrays.stream(input.split(", "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);

            lake = new Lake(numbers);

            input = scanner.nextLine();
        }

        List<String> result = new ArrayList<>();

        for (Integer i : lake) {
            result.add(String.valueOf(i));
        }

        System.out.println(String.join(", ", result));
    }
}
