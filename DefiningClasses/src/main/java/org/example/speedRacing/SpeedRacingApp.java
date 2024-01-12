package org.example.speedRacing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpeedRacingApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] carInfo = scanner.nextLine().split(" ");

            String model = carInfo[0];
            double fuelAmount = Double.parseDouble(carInfo[1]);
            double fuelCost = Double.parseDouble(carInfo[2]);

            Car car = new Car(model, fuelAmount, fuelCost);
            cars.add(car);
        }

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            String[] commandArgs = command.split(" ");

            String action = commandArgs[0];
            String model = commandArgs[1];
            int amountKm = Integer.parseInt(commandArgs[2]);

            for (Car car : cars) {
                if (car.getModel().equals(model)) {
                    if (car.canTravel(amountKm)) {
                        car.calculates(amountKm);
                        break;
                    } else {
                        System.out.print("Insufficient fuel for the drive\n");
                        break;
                    }
                }
            }
            command = scanner.nextLine();
        }

        cars.forEach(System.out::println);
    }
}
