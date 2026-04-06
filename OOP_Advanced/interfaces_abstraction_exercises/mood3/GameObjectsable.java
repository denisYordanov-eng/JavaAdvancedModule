package mood3;

public interface GameObjectsable<T> {
    String getUsername();
    String getHashedPassword();
    int getLevel();
    T getSpecialPoints();
    String setHashedPassword(String hashedPassword);
}
