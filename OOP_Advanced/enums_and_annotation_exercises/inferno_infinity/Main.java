package inferno_infinity;

import inferno_infinity.contracts.api.Weapon;
import inferno_infinity.engine.Engine;
import inferno_infinity.repositories.Repository;
import inferno_infinity.repositories.WeaponRepository;

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
