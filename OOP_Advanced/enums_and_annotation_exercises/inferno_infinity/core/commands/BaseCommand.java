package inferno_infinity.core.commands;

import inferno_infinity.annotation.Inject;
import inferno_infinity.contracts.api.Weapon;
import inferno_infinity.repositories.Repository;

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
