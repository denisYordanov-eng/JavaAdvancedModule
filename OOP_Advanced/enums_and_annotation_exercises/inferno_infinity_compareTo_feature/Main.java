package inferno_infinity_compareTo_feature;

import inferno_infinity_compareTo_feature.contracts.api.Weapon;
import inferno_infinity_compareTo_feature.engine.Engine;
import inferno_infinity_compareTo_feature.repositories.Repository;
import inferno_infinity_compareTo_feature.repositories.WeaponRepository;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Repository<Weapon> weaponReadable = new WeaponRepository<>();

        Runnable engine = new Engine(reader,weaponReadable);
        engine.run();
    }
}
