package militaryElite;

import java.util.List;

public class SpecialisedSoldierImpl extends SolgerImpl implements SpecialisedSoldier {
    private Corps corpus;

    public SpecialisedSoldierImpl (int id, String firstName, String lastName, double salary, Corps corpus) {
        super(id, firstName, lastName, salary);
        this.corpus = corpus;
    }

    @Override
    public Corps getCorps() {
        return corpus;
    }
}
