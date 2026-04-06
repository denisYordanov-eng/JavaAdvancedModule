package mood3;

public class Archangel extends GameObjects<Integer> implements GameObjectsable {
    private int mana;

    public Archangel(String username, int specialPoints, int level) {
        super(username, specialPoints, level);
        this.mana = specialPoints;
    }

    @Override
    public String getHashedPassword() {
        StringBuilder sb = new StringBuilder();
        String reversedUsername = sb.append(getUsername()).reverse().toString();
        int numPart = getUsername().length() * 21;
        return reversedUsername + numPart;
    }


    @Override
    public String setHashedPassword(String hashedPassword) {
        return getUsername();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\"%s\" | \"%s\" -> %s"
                , super.getUsername()
                , getHashedPassword()
                , super.getClass().getSimpleName()));
        sb.append(System.lineSeparator());
        sb.append(String.format("%.0f", super.calculateFinalPoints()));
        return sb.toString();
    }
}
