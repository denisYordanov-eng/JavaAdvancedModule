package military_elite;

public class Mission implements IMission {
    private String name;

    private String state;

    public Mission(String name, String state) {
        this.name = name;
        setState(state);
    }

    public void setState(String state) {
        if (state.equals("inProgress") ||
                state.equals("Finished")) {
            this.state = state;
        }
    }
    @Override
    public String getMissionState() {
        return this.state;
    }

    @Override
    public void completeMission() {
        this.state = "Finished";
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s"
                , this.name
                , this.state);
    }
}
