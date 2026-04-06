package mood3;

public class Demon extends GameObjects<Double> implements GameObjectsable {
    private double energy;

    public Demon(String username, double specialPoints, int level) {
        super(username, specialPoints, level);
        this.energy = specialPoints;

    }


    @Override
    public String getHashedPassword() {
        int hashedPassword = super.getUsername().length() * 217;
        return String.valueOf(hashedPassword);
    }

    @Override
    public String setHashedPassword(String hashedPassword) {
        return getHashedPassword();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        return sb.toString();
    }
}
