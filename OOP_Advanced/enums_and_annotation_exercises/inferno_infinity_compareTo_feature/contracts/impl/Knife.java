package inferno_infinity_compareTo_feature.contracts.impl;

import inferno_infinity_compareTo_feature.enumerations.WeaponTypes;

public class Knife extends BaseWeapon{
    public Knife(String name) {
        super(name, WeaponTypes.KNIFE.getMinDamage(), WeaponTypes.KNIFE.getMaxDamage()
                , WeaponTypes.KNIFE.getSocketsCount());
    }
}
