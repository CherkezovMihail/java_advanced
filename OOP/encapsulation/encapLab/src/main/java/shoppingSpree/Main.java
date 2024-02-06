package shoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        String[] persons = scanner.nextLine().split(";");
        String[] products = scanner.nextLine().split(";");

        List<Person> personsList = new ArrayList<>();
        List<Product> productsList = new ArrayList<>();

        createPersonAndAddToPersons(persons, personsList);
        createProductAndAddToProducts(products, productsList);

        String dataInput = scanner.nextLine();

        while (!dataInput.equals("END")) {
            String[] splittedData = dataInput.split(" ");

            String personName = splittedData[0];
            String productToBye = splittedData[1];

            Person findPerson = personsList.stream().filter(p -> p.getName().equals(personName)).toList().get(0);
            Product findProduct = productsList.stream().filter(p -> p.getName().equals(productToBye)).toList().get(0);

            try {
               findPerson.buyProduct(findProduct);
               System.out.printf("%s bought %s%n", findPerson.getName(), findProduct.getName());
           } catch (IllegalArgumentException ex) {
               System.out.println(ex.getMessage());
           }

            dataInput = scanner.nextLine();
        }

        personsList.forEach(System.out::println);
    }

    private static void createProductAndAddToProducts(String[] products, List<Product> productList) {

        for (String prod : products){
            String productName = "";
            double price = 0.0;

            String[] splitProd = prod.split("=");
            productName = splitProd[0];
            price = Double.parseDouble(splitProd[1]);

            Optional<Product> currentProduct = Optional.empty();


            try {
                currentProduct = Optional.of(new Product(productName, price));
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
                exit(0);
            }
            currentProduct.ifPresent(productList::add);
        }
    }

    private static void createPersonAndAddToPersons(String[] persons, List<Person> personList) {

        for (String per : persons) {
            String personName = "";
            double money = 0.0;

            String[] splitP = per.split("=");
            personName = splitP[0];
            money = Double.parseDouble(splitP[1]);

            Optional<Person> currentPerson = Optional.empty();

            try {
                currentPerson = Optional.of(new Person(personName, money));
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
                exit(0);
            }
            currentPerson.ifPresent(personList::add);
        }
    }
}
