package birthdayCelebrations;

public class Pet implements Birthable {

    private String name;
    private String birthBate;

    public Pet (String name, String birthBate) {
        this.name = name;
        this.birthBate = birthBate;
    }

    @Override
    public String getBirthDate() {
        return birthBate;
    }
}
