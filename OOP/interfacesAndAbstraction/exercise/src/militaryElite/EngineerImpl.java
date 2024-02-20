package militaryElite;

import java.util.*;

public class EngineerImpl extends SpecialisedSoldierImpl {
    private List<Repair> repairs;

    public EngineerImpl (int id, String firstName, String lastName, double salary, Corps corpus) {
        super(id, firstName, lastName, salary, corpus);
        this.repairs = new ArrayList<>();
    }
    public void addRepair (Repair repair) {
        this.repairs.add(repair);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString()).append(System.lineSeparator());
        sb.append("Corps: ").append(getCorps().getName()).append(System.lineSeparator());
        sb.append("Repairs: ").append(System.lineSeparator());
        repairs.forEach(r -> sb.append(r).append(System.lineSeparator()));
        return sb.toString();
    }
}
