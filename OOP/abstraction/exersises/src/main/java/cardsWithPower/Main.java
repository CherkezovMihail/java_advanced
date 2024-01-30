package cardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String card = scanner.nextLine().toUpperCase();
        String cardSuit = scanner.nextLine().toUpperCase();

        Card currentCard = Card.valueOf(card);
        Suit suit = Suit.valueOf(cardSuit);

        int sumPower = CalculatePower.calculatedPower(currentCard, suit);

        System.out.printf("Card name: %s of %s; Card power: %d%n", card, cardSuit, sumPower);

    }
}
