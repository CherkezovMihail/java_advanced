package wildFarm;

public class Cat extends Felime {

    private String breed;

    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    void eatFood(Food food) {
        setFoodEaten(food.getQuantity());
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %.1f, %s, %d]", getAnimalType(), getAnimalName(), breed, getAnimalWeight(), getLivingRegion(), getFoodEaten());
    }
}
