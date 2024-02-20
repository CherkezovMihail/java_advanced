package militaryElite;

import java.util.List;

public class Mission {
    private String codeName;

    private State state;

    public Mission (String codeName, State state) {
        this.codeName = codeName;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Code name: " + codeName + "State: " + state.getStatus();
    }
}
