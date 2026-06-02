package commands;

import interfaces.AttackGroup;
import interfaces.Command;
import interfaces.Targetable;

public class GroupTargetCommand implements Command {
    private AttackGroup attackers;
    private Targetable target;

    public GroupTargetCommand(AttackGroup attackers, Targetable target) {
        this.attackers = attackers;
        this.target = target;
    }

    @Override
    public void execute() {
        this.attackers.groupTarget(this.target);
    }
}
