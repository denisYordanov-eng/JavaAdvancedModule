package inferno_infinity.contracts.impl;

import inferno_infinity.enumerations.WeaponTypes;

public class Knife extends BaseWeapon{
    public Knife(String name) {
        super(name, WeaponTypes.KNIFE.getMinDamage(), WeaponTypes.KNIFE.getMaxDamage()
                , WeaponTypes.KNIFE.getSocketsCount());
    }
}
