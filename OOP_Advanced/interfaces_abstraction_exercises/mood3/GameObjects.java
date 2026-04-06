package mood3;

public abstract class GameObjects<T extends Number> implements GameObjectsable {
    private String username;
    private String hashedPassword;
    private int level;
    private T specialPoints;

    public GameObjects(String username, T specialPoints, int level) {
        this.username = username;
        this.specialPoints = specialPoints;
        this.level = level;
        this.hashedPassword = "";
    }

    protected double calculateFinalPoints() {
        return this.getSpecialPoints().doubleValue() * this.getLevel();
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getHashedPassword() {
        return this.hashedPassword;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public T  getSpecialPoints() {
        return this.specialPoints;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\"%s\" | \"%s\" -> %s"
                , getUsername()
                , getHashedPassword()
                , getClass().getSimpleName()));
        sb.append(System.lineSeparator());
        sb.append(String.format("%.1f", calculateFinalPoints()));
        return sb.toString();
    }
}
