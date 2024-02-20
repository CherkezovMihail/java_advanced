package militaryElite;

import com.sun.nio.sctp.SctpSocketOption;

public class SpyImpl implements Spy {

    private int id;
    private String firstName;
    private String lastName;
    private String codeNumber;

    public SpyImpl (int id, String firstName, String lastName, String codeNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.codeNumber = codeNumber;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getCodeNumber() {
        return codeNumber;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %d%nCode Number: %s", getFirstName(), getLastName(), getId(), getCodeNumber());
    }
}
