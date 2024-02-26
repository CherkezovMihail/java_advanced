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
                animalName = inputData[0];
                animalWeight = Double.parseDouble(inputData[2]);
                animalLivingRegion = inputData[3];
                if (animalType.equals("Cat")) {
                    catBreed = inputData[4];
                }
                switch (animalType) {
                    case "Cat" :
                        cat = new Cat(animalName, animalType, animalWeight, animalLivingRegion, catBreed);
                        break;
                    case "Mouse" :
                        mouse = new Mouse(animalName, animalType, animalWeight, animalLivingRegion);
                        break;
                    case "Tiget" :
                        tiger = new Tiger(animalName, animalType, animalWeight, animalLivingRegion);
                        break;
                    case "Zebra" :
                        zebra = new Zebra(animalName, animalType, animalWeight, animalLivingRegion);
                        break;
                }
            } else {
                String foodType = inputData[0];
                Integer foodQuantity = Integer.parseInt(inputData[1]);

                switch (foodType) {
                    case "Vegatbe":
                        food = new Vegetable(foodQuantity);
                        break;
                    case "Meat" :
                        food = new Meat(foodQuantity);
                        break;
                }
            }




            command = scanner.nextLine();
            line ++;
        }

    }
}
