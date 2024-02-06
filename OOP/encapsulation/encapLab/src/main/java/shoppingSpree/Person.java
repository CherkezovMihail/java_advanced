package shoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.isEmpty() || name.trim().isEmpty() || name.equals(" ")) {
            throw new IllegalStateException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalStateException("Money cannot be negative");
        }
        this.money = money;
    }

    private void addProduct(Product productToAdd) {
        products.add(productToAdd);
    }

    public void buyProduct(Product newProduct) throws Exception {
        if (newProduct.getCost() <= money) {
            addProduct(newProduct);
            money -= newProduct.getCost();
        } else {
            String msg = String.format("%s can't afford %s", name, newProduct.getName());
            throw new IllegalArgumentException(msg);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(name).append(" - ");

        if (products.isEmpty()) {
            sb.append("Nothing bought");
        } else {
            sb.append(String.join(", ", products.stream().map(Product::getName).collect(Collectors.toList())));
        }
        return sb.toString();
    }
}
