package commands;

import interfaces.Attacker;
import interfaces.Command;

public class AttackCommand implements Command {
    Attacker attacker;

    public AttackCommand(Attacker attacker) {
        this.attacker = attacker;
    }

    @Override
    public void execute() {
        attacker.attack();
    }
}
