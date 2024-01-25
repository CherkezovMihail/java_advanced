package org.example.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAgeSecond {

    public static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();

        while (n-- > 0) {

            String[] input = scanner.nextLine().split(", ");

            String name = input[0];
            int age = Integer.parseInt(input[1]);

            Person person = new Person(name, age);

            people.add(person);
        }

        String condition = scanner.nextLine();
        int ageCondition = Integer.parseInt(scanner.nextLine());
        String printFormat = scanner.nextLine();

        Predicate<Person> filterByAge = getFilter(condition, ageCondition);
        Consumer<Person> printOutput = getOutput(printFormat);

        people.stream()
                .filter(filterByAge)
                .forEach(printOutput);

    }

    private static Consumer<Person> getOutput(String printFormat) {
        switch (printFormat) {
            case "name":
                return p -> System.out.println(p.getName());
            case "age":
                return p -> System.out.println(p.getAge());
            case "name age":
                return p -> System.out.printf("%s - %d%n", p.getName(), p.getAge());
            default:
                throw new IllegalArgumentException("Unknown format" + printFormat);
        }
    }

    private static Predicate<Person> getFilter(String condition, int ageCondition) {
        switch (condition) {
            case "older":
                return p -> p.getAge() >= ageCondition;
            case "ypunger":
                return  p -> p.getAge() <= ageCondition;
            default:
                throw new IllegalArgumentException("Unknown condition" + condition);
        }
    }
}
