package inferno_infinity_compareTo_feature.core.commands;


import inferno_infinity_compareTo_feature.contracts.api.Weapon;

public class CompareCommand extends BaseCommand {
    @Override
    public String execute() {
        String firstWeaponName = super.getParams()[0];
        String secondWeaponName = super.getParams()[1];

        Weapon weaponOne = getWeapons().get(firstWeaponName);
        Weapon weaponTwo = getWeapons().get(secondWeaponName);

        if (weaponOne.compareTo(weaponTwo) >= 0) {
            System.out.println(weaponOne.toString());
        }else
            System.out.println(weaponTwo.toString());
        return null;
    }

}
