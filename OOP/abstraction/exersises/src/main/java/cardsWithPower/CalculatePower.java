package cardsWithPower;

public class CalculatePower {
    public static int calculatedPower(Card cardPower, Suit suitPower) {
        return cardPower.getPower() + suitPower.getPower();
    }
}
