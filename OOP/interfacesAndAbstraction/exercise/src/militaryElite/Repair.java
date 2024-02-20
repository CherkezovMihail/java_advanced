package militaryElite;

import java.util.List;

public class Repair {
    private String partsName;
    private int hoursWorked;

    public Repair (String partsName, int hoursWorked) {
        this.partsName = partsName;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String toString() {
        return String.format("Part Name: %s Hours Worked: %d", partsName, hoursWorked);
    }
}
