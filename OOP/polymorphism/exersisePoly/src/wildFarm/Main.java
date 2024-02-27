package wildFarm;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        int line = 0;

        List<Animal> animals = new ArrayList<>();
        List<Food> foodList = new ArrayList<>();

        while (!command.equals("End")) {

            String[] inputData = command.split("\\s+");

            String animalType = "";
            String animalName = "";
            Double animalWeight = 0.0;
            String animalLivingRegion = "";
            String catBreed = "";

            Animal cat = null;
            Animal zebra = null;
            Animal mouse = null;
            Animal tiger = null;

            Food food = null;

            if (line % 2 == 0) {
                animalType = inputData[0];
                animalName = inputData[1];
                animalWeight = Double.parseDouble(inputData[2]);
                animalLivingRegion = inputData[3];
                if (animalType.equals("Cat")) {
                    catBreed = inputData[4];
                }
                switch (animalType) {
                    case "Cat" :
                        cat = new Cat(animalName, animalType, animalWeight, animalLivingRegion, catBreed);
                        animals.add(cat);
                        break;
                    case "Mouse" :
                        mouse = new Mouse(animalName, animalType, animalWeight, animalLivingRegion);
                        animals.add(mouse);
                        break;
                    case "Tiger" :
                        tiger = new Tiger(animalName, animalType, animalWeight, animalLivingRegion);
                        animals.add(tiger);
                        break;
                    case "Zebra" :
                        zebra = new Zebra(animalName, animalType, animalWeight, animalLivingRegion);
                        animals.add(zebra);
                        break;
                }
            } else {
                String foodType = inputData[0];
                Integer foodQuantity = Integer.parseInt(inputData[1]);

                food = switch (foodType) {
                    case "Vegetable" -> new Vegetable(foodQuantity);
                    case "Meat" -> new Meat(foodQuantity);
                    default -> food;
                };
                foodList.add(food);
            }

            command = scanner.nextLine();
            line ++;
        }

        for (int i = 0; i < animals.size(); i++) {

            Animal currentAnimal = animals.get(i);
            Food currentFood = foodList.get(i);

            currentAnimal.makeSound();
            currentAnimal.eatFood(currentFood);

            if (currentAnimal.getAnimalType().equals("Cat")) {
                System.out.println(currentAnimal);
            } else {
                System.out.println(currentAnimal);
            }
        }

        animals = new ArrayList<>();
        foodList = new ArrayList<>();

    }
}
