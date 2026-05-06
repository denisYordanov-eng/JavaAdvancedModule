package inferno_infinity_compareTo_feature.core.commands;

import inferno_infinity_compareTo_feature.annotation.Inject;
import inferno_infinity_compareTo_feature.contracts.api.Weapon;
import inferno_infinity_compareTo_feature.repositories.Repository;

public abstract class BaseCommand implements Executable {
    @Inject
    private String[] params;
    @Inject
    private Repository<Weapon> weapons;

    protected BaseCommand() {

    }

    public String[] getParams() {
        return params;
    }

    public Repository<Weapon> getWeapons() {
        return weapons;
    }
}
