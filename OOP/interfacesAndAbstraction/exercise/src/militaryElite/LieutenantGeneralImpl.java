package militaryElite;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LieutenantGeneralImpl extends SolgerImpl {

    private List<PrivateImpl> privatesSolgers;

    public LieutenantGeneralImpl (int id, String firstName, String lastName, double salary) {
        super(id,firstName, lastName, salary);
        this.privatesSolgers = new ArrayList<>();
    }
    public void addPrivate(PrivateImpl privateImpl) {
        privatesSolgers.add(privateImpl);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());
        if (privatesSolgers.isEmpty()) {
            sb.append("Privates:");
        }else {
            sb.append("Privates:").append(System.lineSeparator());
        }
        privatesSolgers.forEach(p -> sb.append(p).append(System.lineSeparator()));
        return sb.toString();
    }
}
