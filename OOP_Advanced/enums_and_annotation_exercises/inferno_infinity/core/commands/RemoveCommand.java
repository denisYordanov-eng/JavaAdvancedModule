package inferno_infinity.core.commands;

import inferno_infinity.contracts.api.Weapon;

public class RemoveCommand extends BaseCommand {
    @Override
    public String execute() {
        String weaponName = super.getParams()[0];
        int socketIndex = Integer.parseInt(super.getParams()[1]);

        Weapon weapon = super.getWeapons().get(weaponName);
        if (weapon != null) {
            weapon.removeGem(socketIndex);

        }
        return null;
    }
}
