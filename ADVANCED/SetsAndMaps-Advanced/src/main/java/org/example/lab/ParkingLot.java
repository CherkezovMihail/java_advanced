package org.example.lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Set<String> cars = new LinkedHashSet<>();

        while (!input.equals("END")) {

            String[] data = input.split(", ");

            if (data[0].equals("IN")) {
                cars.add(data[1]);
            } else {
                cars.remove(data[1]);
            }

            input = scanner.nextLine();
        }

        if (cars.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car : cars) {
                System.out.println(car);
            }
        }

    }
}
