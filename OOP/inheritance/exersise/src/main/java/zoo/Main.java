package zoo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String snakeName = scanner.nextLine();
        String bearName = scanner.nextLine();

        Animal snake = new Snake(snakeName);
        Animal bear = new Bear(bearName);

        snake.sayName();
        bear.sayName();

    }
}
