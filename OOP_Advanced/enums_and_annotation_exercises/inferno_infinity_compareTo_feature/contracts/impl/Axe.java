package inferno_infinity_compareTo_feature.contracts.impl;

import inferno_infinity_compareTo_feature.enumerations.WeaponTypes;

public class Axe extends BaseWeapon{
    public Axe(String name) {
        super(name, WeaponTypes.AXE.getMinDamage(), WeaponTypes.AXE.getMaxDamage()
                , WeaponTypes.AXE.getSocketsCount());
    }
}
