package cardSuit;

public class Main {
    public static void main(String[] args) {

        System.out.println("Card Suits:");

        for (Suit cardSuit : Suit.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", cardSuit.ordinal(), cardSuit.name());

        }
    }
}
