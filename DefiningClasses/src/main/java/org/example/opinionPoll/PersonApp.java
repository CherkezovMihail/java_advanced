package org.example.opinionPoll;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> test = new HashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] personInfo = scanner.nextLine().split(" ");

            Person person = new Person(personInfo[0], Integer.parseInt(personInfo[1]));

            people.add(person);

        }

        Predicate<Person> filterPerson = p -> p.getAge() > 30;

        people.stream().filter(filterPerson)
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .forEach(System.out::println);
    }
}
