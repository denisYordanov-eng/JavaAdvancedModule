package inferno_infinity_compareTo_feature.contracts.api;

public interface Weapon {
    String getName();

    void addGem(String gemType, int index);

    void removeGem( int index);
    double getLevel();

    int compareTo(Weapon weaponTwo);
}
