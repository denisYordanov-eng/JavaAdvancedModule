package inferno_infinity.factories;

import inferno_infinity.contracts.api.Weapon;
import inferno_infinity.contracts.impl.Axe;
import inferno_infinity.contracts.impl.Knife;
import inferno_infinity.contracts.impl.Sword;

public final class WeaponFactory {
    private WeaponFactory(){}

    public static Weapon createAxeWeapon(String name){
        return new Axe(name);
    }
    public static Weapon createSwordWeapon(String name){
        return new Sword(name);
    }
    public static Weapon createKnifeWeapon(String name){
        return new Knife(name);
    }
}
