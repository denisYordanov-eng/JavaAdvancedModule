package inferno_infinity.core.commands;

import inferno_infinity.contracts.api.Weapon;
import inferno_infinity.factories.WeaponFactory;

public class CreateCommand extends BaseCommand {

    @Override
    public String execute() {
        String type = super.getParams()[0];
        String name = super.getParams()[1];
        Weapon weapon = null;
        switch (type) {
            case "AXE":
                weapon = WeaponFactory.createAxeWeapon(name);
                break;
            case "SWORD":
                weapon = WeaponFactory.createSwordWeapon(name);
                break;
            case "KNIFE":
                weapon = WeaponFactory.createKnifeWeapon(name);
                break;
        }
        if(weapon != null) {
            super.getWeapons().add(weapon);
        }
        return null;
    }
}
