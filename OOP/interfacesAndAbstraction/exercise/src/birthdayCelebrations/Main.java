package birthdayCelebrations;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        List<Citizen> citizens = new ArrayList<>();
        List<Pet> pets = new ArrayList<>();
        List<Robot> robots = new ArrayList<>();

        while (!command.equals("End")) {

            String[] input = command.split(" ");

            String species = input[0];

            String name = "";
            String id = "";
            String birthDay = "";

            switch (species) {
                case "Citizen" : {
                    name = input[1];
                    int age = Integer.parseInt(input[2]);
                    id = input[3];
                    birthDay = input[4];

                    Citizen citizen = new Citizen(name, age, id, birthDay);
                    citizens.add(citizen);
                    break;
                } case "Robot" : {
                    String model = input[1];
                    id = input[2];

                    Robot robot = new Robot(model, id);
                    robots.add(robot);
                    break;
                } case "Pet" : {
                    name = input[1];
                    birthDay = input[2];

                    Pet pet = new Pet(name, birthDay);
                    pets.add(pet);
                    break;
                }
            }
            command = scanner.nextLine();
        }

        String yeear = scanner.nextLine();

        citizens.stream().filter(c -> c.getBirthDate().contains(yeear)).forEach(c -> System.out.println(c.getBirthDate()));
        pets.stream().filter(p -> p.getBirthDate().contains(yeear)).forEach(p -> System.out.println(p.getBirthDate()));

    }
}
