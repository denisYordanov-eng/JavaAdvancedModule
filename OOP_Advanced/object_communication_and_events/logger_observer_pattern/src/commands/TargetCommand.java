package commands;

import interfaces.Attacker;
import interfaces.Command;
import interfaces.Targetable;

public class TargetCommand implements Command {
    private Attacker attacker;
    private Targetable target;

    public TargetCommand(Attacker attacker, Targetable target) {
        this.attacker = attacker;
        this.target = target;
    }

    @Override
    public void execute() {
        this.attacker.setTarget(target);
    }
}
