package org.example.lab;

import java.util.*;

public class Cities {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, List<String>>> continents = new LinkedHashMap<>();

        for (int i = 0; i < rows; i++) {

            String[] input = scanner.nextLine().split(" ");

            String continent = input[0];
            String country = input[1];
            String city = input[2];

            continents.putIfAbsent(continent, new LinkedHashMap<>());

            Map<String, List<String>> countries = continents.get(continent);
            countries.putIfAbsent(country, new ArrayList<>());

            List<String> cities = countries.get(country);
            cities.add(city);

        }

        for (Map.Entry<String, Map<String, List<String>>> entry : continents.entrySet()) {
            System.out.println(entry.getKey() + ":");
            entry.getValue().entrySet().forEach(inner -> {
                String res = String.join(", ", inner.getValue());
                System.out.printf("  %s -> %s%n", inner.getKey(), res);
            });

        }
    }
}
