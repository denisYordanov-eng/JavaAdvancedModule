package inferno_infinity.core.commands;

import inferno_infinity.contracts.api.Weapon;

public class PrintCommand extends BaseCommand{
    @Override
    public String execute() {
        String name = super.getParams()[0];
        Weapon weapon = super.getWeapons().get(name);
        System.out.println(weapon.toString());
        return null;
    }
}
