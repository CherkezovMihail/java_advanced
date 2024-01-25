package org.example.speedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCost;
    private int distanceTraveled;

    public Car(String model, double fuelAmount, double fuelCost) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCost = fuelCost;
        this.distanceTraveled = 0;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public String getModel() {
        return model;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public boolean canTravel(int km) {
        double kmToGo = km * fuelCost;
        return kmToGo <= fuelAmount;
    }

    public void calculates(int km) {
        double kmToGo = km * fuelCost;
        fuelAmount -= kmToGo;
        distanceTraveled += km;
    }
    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.getModel(), this.getFuelAmount(), this.getDistanceTraveled());
    }
}
