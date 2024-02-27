package wildFarm;

public class Mouse extends Mammal {

    public Mouse(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    void eatFood(Food food) {

        if (!food.getClass().getName().contains("Vegetable")) {
            System.out.printf("%ss are not eating that type of food!%n", getAnimalType());
            setFoodEaten(0);
        } else {
            setFoodEaten(food.getQuantity());
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
