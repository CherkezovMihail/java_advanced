package vehicles;

public class Car extends Vehicle {


    public Car(double fuelQuantity, double fuelConsumption, int tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    void drive (double km) {
        double neededLitres = km * (getFuelConsumption() + 0.9);

        if (getFuelQuantity() >= neededLitres) {
            setFuelQuantity(getFuelQuantity() - neededLitres);
            System.out.printf("Car travelled %.1f km%n", km);
        } else {
            System.out.println("Car needs refueling");
        }
    }

    @Override
    void refuel (double litres) {

        if (litres <= 0) {
            System.out.println("Fuel must be a positive number");
            return;
        }

        double newLiters = getFuelQuantity() + litres;

        if (newLiters >= getTankCapacity()) {
            System.out.println("Cannot fit fuel in tank");
        } else {
          setFuelQuantity(newLiters);
        }
    }

    @Override
    public String toString() {
        return String.format("Car: %.2f", getFuelQuantity());
    }
}
