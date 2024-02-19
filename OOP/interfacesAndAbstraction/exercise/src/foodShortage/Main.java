package foodShortage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Citizen> citizenList = new ArrayList<>();
        List<Rebel> rebels = new ArrayList<>();

        while (n-- != 0) {
            String[] peopleData = scanner.nextLine().split(" ");

            String name = "";
            int age = 0;

            if (peopleData.length > 3) {
                name = peopleData[0];
                age = Integer.parseInt(peopleData[1]);
                String id = peopleData[2];
                String birthDate = peopleData[3];

                Citizen citizen = new Citizen(name, age, id, birthDate);
                citizenList.add(citizen);
            }else {
                name = peopleData[0];
                age = Integer.parseInt(peopleData[1]);
                String group = peopleData[2];
                Rebel rebel = new Rebel(name, age, group);
                rebels.add(rebel);
            }
        }

        String command = scanner.nextLine();

        int totalFood = 0;

        while (!command.equals("End")) {

            String name = command;

            for (Citizen citizen : citizenList) {
                if (citizen.getName().equals(name)) {
                    citizen.buyFood();
                    totalFood += 10;
                }
            }

            for (Rebel rebel : rebels) {
                if (rebel.getName().equals(name)) {
                    rebel.buyFood();
                    totalFood += 5;
                }
            }

            command = scanner.nextLine();
        }

        System.out.println(totalFood);
    }
}
