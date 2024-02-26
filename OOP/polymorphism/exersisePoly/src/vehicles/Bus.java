package vehicles;

public class Bus extends Vehicle {

    private boolean withPeople = false;

    public Bus(double fuelQuantity, double fuelConsumption, int tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    public void setWithPeople(boolean withPeople) {
        this.withPeople = withPeople;
    }

    public boolean getWithPeople() {
        return withPeople;
    }

    @Override
    void drive (double km) {

        double neededLiters = 0;

        if (withPeople) {
            neededLiters = km * (getFuelConsumption() + 1.4);
        } else {
            neededLiters = km * getFuelConsumption();
        }

        if (getFuelQuantity() >= neededLiters) {
            setFuelQuantity(getFuelQuantity() - neededLiters);
            System.out.printf("Bus travelled %.1f km%n", km);
        } else {
            System.out.println("Bus needs refueling");
        }
    }

    @Override
    void refuel(double litres) {

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
        return String.format("Bus: %.2f", getFuelQuantity());
    }
}
