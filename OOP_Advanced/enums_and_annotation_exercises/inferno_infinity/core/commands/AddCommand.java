package inferno_infinity.core.commands;

import inferno_infinity.contracts.api.Weapon;

public class AddCommand extends BaseCommand {

    @Override
    public String execute() {
        String weaponName = super.getParams()[0];
        int index  = Integer.parseInt(super.getParams()[1]);
        String gemType = super.getParams()[2];
        Weapon weapon = super.getWeapons().get(weaponName);
        if(weapon != null){
            weapon.addGem(gemType, index);
        }

        return null;
    }
}
