package DefiningClass_Exercises.skatersAndBoards;

class Skater {
    private String name;
    private Skateboard skateboard;

    Skater(String name) {
        this.name = name;
    }

    Skater(Skateboard skateboard, String name) {
        this.skateboard = skateboard;
        this.name = name;
    }

    Skateboard getSkateboard() {
        return skateboard;
    }

    public void setSkateboard(Skateboard skateboard) {
        this.skateboard = skateboard;
    }
}
