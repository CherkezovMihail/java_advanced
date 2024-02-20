package militaryElite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class CommandoImpl extends SpecialisedSoldierImpl{
    private List<Mission> missions;

    public CommandoImpl (int id, String firstName, String lastName, double salary, Corps corpus) {
        super(id, firstName, lastName, salary, corpus);
        this.missions = new ArrayList<>();
    }

    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(System.lineSeparator()).append("Corps: ").append(getCorps().getName());
        sb.append(System.lineSeparator());
        if (missions.isEmpty()) {
            sb.append("Missions:");
        }else {
            sb.append("Missions:").append(System.lineSeparator());
        }
        missions.forEach(mission -> sb.append(mission).append(System.lineSeparator()));

        return sb.toString();
    }
}
