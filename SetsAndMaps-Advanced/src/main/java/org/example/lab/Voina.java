package org.example.lab;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Voina {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstPlayerDeck = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        Set<Integer> secondPlayerDeck = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        int count = 50;

        while (count-- > 0) {

             int playerOneFirstCard = firstPlayerDeck.iterator().next();
             firstPlayerDeck.remove(playerOneFirstCard);

             int playerTwoFirstCard = secondPlayerDeck.iterator().next();
             secondPlayerDeck.remove(playerTwoFirstCard);

             if (playerOneFirstCard > playerTwoFirstCard) {
                 firstPlayerDeck.add(playerTwoFirstCard);
                 firstPlayerDeck.add(playerOneFirstCard);
             } else if (playerTwoFirstCard > playerOneFirstCard) {
                 secondPlayerDeck.add(playerOneFirstCard);
                 secondPlayerDeck.add(playerTwoFirstCard);
             }

             if (firstPlayerDeck.isEmpty() || secondPlayerDeck.isEmpty()) {
                 break;
             }
        }

        if (firstPlayerDeck.size() > secondPlayerDeck.size()) {
            System.out.println("First player win!");
        } else if (secondPlayerDeck.size() > firstPlayerDeck.size()) {
            System.out.println("Second player win!");
        }else {
            System.out.println("Draw!");
        }

    }
}
