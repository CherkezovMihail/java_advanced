package org.example.lab;

import java.util.*;

public class ProductShop {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Float>> shops = new TreeMap<>();

        while (!input.equals("Revision")) {

            String[] inputInfo = input.split(", ");

            String shop = inputInfo[0];
            String product = inputInfo[1];
            float price = Float.parseFloat(inputInfo[2]);

            shops.putIfAbsent(shop, new LinkedHashMap<>());

            Map<String, Float> products = shops.get(shop);

            products.putIfAbsent(product, price);

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Float>> el : shops.entrySet()) {
            System.out.println(el.getKey() + "->");
            el.getValue().entrySet().stream().forEach(innerEl -> {
//                System.out.println("Product: " + innerEl.getKey() + ", " + "Price: " + innerEl.getValue());
                System.out.printf("Product: %s, Price: %.1f%n", innerEl.getKey(), innerEl.getValue());
            });
        }
    }
}
