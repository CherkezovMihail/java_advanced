package org.example.exercises;

import java.util.*;

public class PopulationCounter {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Integer>> populationReport = new LinkedHashMap<>();
        Map<String, Integer> totalPopulationByCountries = new LinkedHashMap<>();

        while (!input.equals("report")) {

            String[] info = input.split("\\|");

            String city = info[0];
            String country = info[1];
            int population =Integer.parseInt(info[2]);

            populationReport.putIfAbsent(country, new LinkedHashMap<>());

            Map<String, Integer> cities = populationReport.get(country);

            cities.putIfAbsent(city, population);

            totalPopulationByCountries.putIfAbsent(country, 0);
            int p = totalPopulationByCountries.get(country);
            totalPopulationByCountries.put(country, population + p);

            input = scanner.nextLine();
        }

        populationReport.entrySet().stream()
                .sorted((c1, c2) -> totalPopulationByCountries.get(c2.getKey()).compareTo(totalPopulationByCountries.get(c1.getKey())))
                .forEach(con -> {
                    System.out.printf("%s (total population: %d)%n", con.getKey(), totalPopulationByCountries.get(con.getKey()));
                    con.getValue().entrySet().stream()
                            .sorted((t1, t2) -> t2.getValue().compareTo(t1.getValue())).forEach(c -> {
                                System.out.printf("=>%s: %d%n", c.getKey(), c.getValue());
                            });
                });
    }
}
