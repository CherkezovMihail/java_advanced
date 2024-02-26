package vehicles;

public class Truck extends Vehicle {

    public Truck(double fuelQuantity, double fuelConsumption, int tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    void drive(double km) {
        double neededLiters = km * (getFuelConsumption() + 1.6);

        if (getFuelQuantity() >= neededLiters) {
            setFuelQuantity(getFuelQuantity() - neededLiters);
            System.out.printf("Truck travelled %.1f km%n", km);
        } else {
            System.out.println("Truck needs refueling");
        }
    }

    @Override
    void refuel(double litres) {

        if (litres <= 0) {
            System.out.println("Fuel must be a positive number");
            return;
        }

        double newLitres = getFuelQuantity() + (litres * 0.95);

        if (newLitres >= getTankCapacity()) {
            System.out.println("Cannot fit fuel in tank");
        } else {
            setFuelQuantity(newLitres);;
        }
    }

    @Override
    public String toString() {
        return String.format("Truck: %.2f", getFuelQuantity());
    }
}
