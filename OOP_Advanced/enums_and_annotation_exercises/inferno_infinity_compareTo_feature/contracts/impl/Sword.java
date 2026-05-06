package inferno_infinity_compareTo_feature.contracts.impl;

import inferno_infinity_compareTo_feature.enumerations.WeaponTypes;

public class Sword extends BaseWeapon{
    public Sword(String name) {
        super(name, WeaponTypes.SWORD.getMinDamage(), WeaponTypes.SWORD.getMaxDamage()
                , WeaponTypes.SWORD.getSocketsCount());
    }
}
