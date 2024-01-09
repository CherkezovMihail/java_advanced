package org.example;

import org.example.lab.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int inputLine = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < inputLine; i++) {
            String[] carInfo = scanner.nextLine().split(" ");

//            Car car = carInfo.length == 1
//                    ? new Car(carInfo[0])
//                    : new Car((carInfo[0]), carInfo[1], Integer.parseInt(carInfo[2]));

            Car car = new Car(carInfo[0], carInfo[1], Integer.parseInt(carInfo[2]));

            cars.add(car);
        }
        for (Car c : cars) {
            System.out.println(c.carInfo());
        }

    }
}