package org.example.companyRoster;

import java.util.*;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Department> departments = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] employeeInfo = scanner.nextLine().split(" ");

            String name = employeeInfo[0];
            double salary = Double.parseDouble(employeeInfo[1]);
            String position = employeeInfo[2];
            String employeeDepartment = employeeInfo[3];
            String email = "";
            int age = 0;

            Employee employee = null;

            if (employeeInfo.length == 4) {
                employee = new Employee(name, salary, position, employeeDepartment);
            } else if (employeeInfo.length == 5) {
                String data = employeeInfo[4];
                if (isNumeric(data)) {
                    age = Integer.parseInt(data);
                    email = "n/a";
                } else {
                    email = data;
                    age = -1;
                }
                employee = new Employee(name, salary, position, employeeDepartment, email, age);
            } else {
                email = employeeInfo[4];
                age = Integer.parseInt(employeeInfo[5]);
                employee = new Employee(name, salary, position, employeeDepartment, email, age);
            }

            boolean departmentExist = departments.stream().anyMatch(d -> d.getName().equals(employeeDepartment));
            if (!departmentExist) {
                Department department = new Department(employeeDepartment);
                departments.add(department);
            }

            Department currentDepartment = departments.stream().filter(d -> d.getName().equals(employeeDepartment))
                    .findFirst().get();

            currentDepartment.getEmployees().add(employee);
        }
        Department higsetPaidDepartment = departments.stream()
                .max(Comparator.comparingDouble(Department::calculateAverageSalary))
                .get();

        System.out.println("Highest Average Salary: " + higsetPaidDepartment.getName());
        higsetPaidDepartment.getEmployees()
                .stream().sorted((s1, s2) -> Double.compare(s2.getSalary(), s1.getSalary()))
                .forEach(System.out::println);
    }

    public static boolean isNumeric(String str)
    {
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
}
