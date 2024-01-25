package org.example.carSalesman;

public class Engine {
    private String model;
    private int power;
    private String displacement;
    private String efficiency;

    public Engine(String model, int power, String displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine(String model, int power) {
        this(model, power, "n/a", "n/a");
    }

    public Engine(String model, int power, String displacement) {
        this(model, power, displacement, "n/a");
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return String.format("%s:%nPower: %d%nDisplacement: %s%nEfficiency: %S%n",
                this.getModel(), this.power, this.displacement, this.efficiency);
    }

}
