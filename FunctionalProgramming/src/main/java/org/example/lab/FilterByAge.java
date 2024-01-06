package org.example.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilterByAge {

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

        List<Person> filterPeopleByAge = filterByAge(condition, ageCondition, people);

        printOutput(filterPeopleByAge, printFormat);
    }

    private static List<Person> filterByAge (String condition, int age, List<Person> people) {

        List<Person> filterPeopleByAge = new ArrayList<>();

        switch (condition) {
            case "older" :
                people.forEach(p -> {
                    if (p.getAge() >= age) {
                        filterPeopleByAge.add(p);
                    }
                });
                break;
            case "younger" :
                people.forEach(p -> {
                    if (p.getAge() <= age) {
                        filterPeopleByAge.add(p);
                    }
                });
                break;

        }
        return filterPeopleByAge;
    }

    private static void  printOutput(List<Person> filterPerson, String printFormat) {
        List<String> output = new ArrayList<>();

        switch (printFormat) {
            case "name age" :
                filterPerson.forEach(p -> System.out.printf("%s - %d%n", p.getName(), p.getAge()));
                break;
            case "name" :
                filterPerson.forEach(p -> System.out.println(p.getName()));
                break;
            case "age" :
                filterPerson.forEach(p -> System.out.println(p.getAge()));
                break;
        }
    }
}
