package militaryElite;

public enum Corps {

    MARINES("Marines"),
    AIRFORCES("Airforces");

    String name;

    Corps(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
