package zoo;

public class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void sayName() {
        System.out.printf("My name is %s%n", getName());
    }
}
