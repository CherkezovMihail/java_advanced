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
            String[] carinfo = scanner.nextLine().split(" ");

            String model = carinfo[0];
            String engineModel = carinfo[1];
            Engine currentEngine = null;
            Car car = null;

            boolean engineExist = engines.stream().anyMatch(e -> e.getModel().equals(engineModel));

            if (engineExist) {
                currentEngine = engines.stream().filter(e -> e.getModel().equals(engineModel)).findFirst().get();
                if (carinfo.length == 4) {
                    car = new Car(model, currentEngine, carinfo[2], carinfo[3]);
                    cars.add(car);
                } else if (carinfo.length == 3) {
                    if (isNumeric(carinfo[2])) {
                        car = new Car(model, currentEngine, carinfo[2]);
                        cars.add(car);
                    }else {
                        String weight = "n/a";
                        car = new Car(model, currentEngine, weight, carinfo[2]);
                        cars.add(car);
                    }
                } else if (carinfo.length == 2) {
                    car = new Car(model, currentEngine);
                    cars.add(car);
                }
            }
        }
    }

    private static void readDataForEngine(int engineNumbers, Scanner scanner, List<Engine> engines) {
        for (int i = 0; i < engineNumbers; i++) {
            String[] engininfo = scanner.nextLine().split(" ");

            String model = engininfo[0];
            int power = Integer.parseInt(engininfo[1]);

            Engine engine = null;

            if (engininfo.length == 4) {
                engine = new Engine(model, power, engininfo[2], engininfo[3]);
                engines.add(engine);
            } else if (engininfo.length == 3) {
                if (isNumeric(engininfo[2])) {
                    engine = new Engine(model, power, engininfo[2]);
                    engines.add(engine);
                }else {
                    String displacement = "n/a";
                    engine = new Engine(model, power, displacement, engininfo[2]);
                    engines.add(engine);
                }
            } else if (engininfo.length == 2) {
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
