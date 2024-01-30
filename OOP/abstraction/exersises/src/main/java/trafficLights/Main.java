package trafficLights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] currentLights = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());

//        List<TrafficLight> trafficLights = new ArrayList<>();
//
//        for (String light : currentLights) {
//            TrafficLight trafficLight = new TrafficLight(light);
//            trafficLights.add(trafficLight);
//        }

        List<TrafficLight> trafficLights = Arrays.stream(currentLights)
                .map(TrafficLight::new)
                .toList();

        for (int i = 0; i < n; i++) {

            for (TrafficLight trafficLight : trafficLights) {
                trafficLight.updatelight();
            }
            System.out.println();
        }
    }
}
