package org.example.carSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarSalesmanApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int engineNumbers = Integer.parseInt(scanner.nextLine());

        List<Engine> engines = new ArrayList<>();
        List<Car> cars = new ArrayList<>();

        readDataForEngine(engineNumbers, scanner, engines);

        int carNumbers = Integer.parseInt(scanner.nextLine());

        readDataForCar(carNumbers, scanner, cars, engines);

        cars.forEach(System.out::println);

    }

    private static void readDataForCar(int carNumbers, Scanner scanner, List<Car> cars, List<Engine>engines) {
        for (int i = 0; i < carNumbers; i++) {
            String[] carInfo = scanner.nextLine().split(" ");

            String model = carInfo[0];
            String engineModel = carInfo[1];
            Engine currentEngine = null;
            Car car = null;

            boolean engineExist = engines.stream().anyMatch(e -> e.getModel().equals(engineModel));

            if (engineExist) {
                currentEngine = engines.stream().filter(e -> e.getModel().equals(engineModel)).findFirst().get();
                if (carInfo.length == 4) {
                    car = new Car(model, currentEngine, carInfo[2], carInfo[3]);
                    cars.add(car);
                } else if (carInfo.length == 3) {
                    if (isNumeric(carInfo[2])) {
                        car = new Car(model, currentEngine, carInfo[2]);
                        cars.add(car);
                    }else {
                        String weight = "n/a";
                        car = new Car(model, currentEngine, weight, carInfo[2]);
                        cars.add(car);
                    }
                } else if (carInfo.length == 2) {
                    car = new Car(model, currentEngine);
                    cars.add(car);
                }
            }
        }
    }

    private static void readDataForEngine(int engineNumbers, Scanner scanner, List<Engine> engines) {
        for (int i = 0; i < engineNumbers; i++) {
            String[] enginInfo = scanner.nextLine().split(" ");

            String model = enginInfo[0];
            int power = Integer.parseInt(enginInfo[1]);

            Engine engine = null;

            if (enginInfo.length == 4) {
                engine = new Engine(model, power, enginInfo[2], enginInfo[3]);
                engines.add(engine);
            } else if (enginInfo.length == 3) {
                if (isNumeric(enginInfo[2])) {
                    engine = new Engine(model, power, enginInfo[2]);
                    engines.add(engine);
                }else {
                    String displacement = "n/a";
                    engine = new Engine(model, power, displacement, enginInfo[2]);
                    engines.add(engine);
                }
            } else if (enginInfo.length == 2) {
                engine = new Engine(model, power);
                engines.add(engine);
            }
        }
    }

    public static boolean isNumeric(String str)
    {
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
}
