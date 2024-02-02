package animalFarm;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());

        Optional<Chicken> chicken = Optional.empty();

        try {
            chicken = Optional.of(new Chicken(name, age));
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        chicken.ifPresent(System.out::println);
    }
}
