package wildFarm;

public abstract class Mammal extends Animal {

    private String livingRegion;

    public Mammal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    @Override
    void makeSound() {

    }

    @Override
    void eatFood(Food food) {
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %.1f, %s, %d]", getAnimalType(), getAnimalName(), getAnimalWeight(), getLivingRegion(), getFoodEaten());
    }
}
