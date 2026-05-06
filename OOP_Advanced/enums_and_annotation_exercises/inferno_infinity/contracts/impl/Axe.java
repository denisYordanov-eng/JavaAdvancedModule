package inferno_infinity.contracts.impl;

import inferno_infinity.enumerations.WeaponTypes;

public class Axe extends BaseWeapon{
    public Axe(String name) {
        super(name, WeaponTypes.AXE.getMinDamage(), WeaponTypes.AXE.getMaxDamage()
                , WeaponTypes.AXE.getSocketsCount());
    }
}
