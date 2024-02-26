package vehicles;

public abstract class Vehicle {

    private double fuelQuantity;
    private double fuelConsumption;
    private int tankCapacity;

    public Vehicle (double fuelQuantity, double fuelConsumption, int tankCapacity) {
        setFuelQuantity(fuelQuantity);
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    abstract void drive(double km);
    abstract void refuel(double litres);

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public int getTankCapacity() {
        return tankCapacity;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity <= 0) {
            System.out.println("Fuel must be a positive number");
        } else  {
            this.fuelQuantity = fuelQuantity;
        }
    }

    public void setTankCapacity(int tankCapacity) {
        this.tankCapacity = tankCapacity;
    }
}
