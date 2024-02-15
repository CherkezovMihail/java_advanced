package Restaurant;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        BigDecimal price = BigDecimal.valueOf(24.50);

        Salmon salmon = new Salmon("Salmon", price);

        System.out.println(salmon.getGrams());
        System.out.println(salmon.getPrice());
        System.out.println(salmon.getName());

    }
}
