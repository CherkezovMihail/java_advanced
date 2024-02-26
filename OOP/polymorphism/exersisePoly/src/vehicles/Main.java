package vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = 3;

//        double fuelQuantity = 0;
//        double fuelConsumption = 0;

        Vehicle car = null;
        Vehicle truck = null;
        Bus bus = null;

        for (int i = 0; i < n; i++) {

            String[] vehicleArgs = scanner.nextLine().split(" ");

            String vehicle = vehicleArgs[0];
            double fuelQuantity = Double.parseDouble(vehicleArgs[1]);
            double fuelConsumption = Double.parseDouble(vehicleArgs[2]);
            int tankCapacity = Integer.parseInt(vehicleArgs[3]);

            switch (vehicle) {
                case "Car" :
                    car = new Car(fuelQuantity, fuelConsumption, tankCapacity);
                    break;
                case "Truck" :
                    truck = new Truck(fuelQuantity, fuelConsumption, tankCapacity);
                    break;
                case "Bus" :
                    bus = new Bus(fuelQuantity, fuelConsumption, tankCapacity);
                    break;
            }
        }

        int lines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < lines; i++) {

           String[] commands =  scanner.nextLine().split("\\s+");

           String command = commands[0];
           String vehicle = commands[1];
           double value = Double.parseDouble(commands[2]);

           if (vehicle.equals("Car")) {
               if (command.equals("Drive")) {
                   car.drive(value);
               } else if (command.equals("Refuel")) {
                   car.refuel(value);
               }
           } else if (vehicle.equals("Truck")) {
               if (command.equals("Drive")) {
                   truck.drive(value);
               } else if (command.equals("Refuel")) {
                   truck.refuel(value);
               }
           } else if (vehicle.equals("Bus")) {
               if (command.equals("Refuel")) {
                   bus.refuel(value);
               } else {
                   if (command.equals("Drive")) {
                       bus.setWithPeople(true);
                       bus.drive(value);
                   } else {
                       if (bus.getWithPeople()) {
                           bus.setWithPeople(false);
                       }
                       bus.drive(value);
                   }
               }
           }
        }
        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }
}
