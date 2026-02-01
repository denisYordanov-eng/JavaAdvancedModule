package encapsulation_exercise.class_box.football_team_generator;

public class Player {
    private String name;

    private Stat stat;

    public Player(String name, Stat stat) {
        setName(name);
        setStat(stat);
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name.trim();
    }

    public void setStat(Stat stat) {
        this.stat = stat;
    }

    public String getName() {
        return name;
    }

    public double overallRating() {
        return (double) (this.stat.getSprint() + this.stat.getShooting() + this.stat.getPassing()
                + this.stat.getEndurance() + this.stat.getDribble()) / 5.0;
    }
}
