package borderControl;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        List<Robot> robots = new ArrayList<>();
        List<Citizen> citizens = new ArrayList<>();

        while (!command.equals("End")) {

            String[] commandArgs = command.split(" ");

            String id = "";

            if (commandArgs.length > 2) {
                String name = commandArgs[0];
                int age = Integer.parseInt(commandArgs[1]);
                id = commandArgs[2];

                Citizen citizen = new Citizen(name, age, id);
                citizens.add(citizen);
            }else {
                String model = commandArgs[0];
                id = commandArgs[1];

                Robot robot = new Robot(id, model);
                robots.add(robot);
            }

            command = scanner.nextLine();
        }

        String lastDigits = scanner.nextLine();

        citizens.stream().filter(c -> c.getId().substring(c.getId().length() - 3).equals(lastDigits)).forEach(c -> System.out.println(c.getId()));
        robots.stream().filter(r -> r.getId().substring(r.getId().length() - 3).equals(lastDigits)).forEach(r -> System.out.println(r.getId()));

//        for (Robot robot : robots) {
//            String robotIdlastThreeDigits = robot.getId().substring(robot.getId().length() - 3);
//            if (robotIdlastThreeDigits.equals(lastDigits)) {
//                System.out.println(robot.getId());
//            }
//        }
    }
}
