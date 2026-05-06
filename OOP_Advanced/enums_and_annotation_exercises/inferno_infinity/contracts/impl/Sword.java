package inferno_infinity.contracts.impl;

import inferno_infinity.enumerations.WeaponTypes;

public class Sword extends BaseWeapon{
    public Sword(String name) {
        super(name, WeaponTypes.SWORD.getMinDamage(), WeaponTypes.SWORD.getMaxDamage()
                , WeaponTypes.SWORD.getSocketsCount());
    }
}
