package inferno_infinity.contracts.api;

public interface Weapon {
    String getName();

    void addGem(String gemType, int index);

    void removeGem( int index);
}
