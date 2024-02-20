package militaryElite;

public enum State {

    INPROGRESS("inprogress"),
    FINISHED("finished");

    String status;

    State(String status) {
        this.status = status;
    }

    public String getStatus () {
        return status;
    }

}
