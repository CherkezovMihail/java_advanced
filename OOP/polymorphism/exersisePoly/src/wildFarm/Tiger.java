package wildFarm;

public class Tiger extends Felime {

    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    void eatFood(Food food) {
        if (!food.getClass().getName().equals("Meat")) {
            System.out.printf("%ss are not eating that type of food!%n", getAnimalType());
        } else {
            setFoodEaten(food.getQuantity());
        }
    }
}
