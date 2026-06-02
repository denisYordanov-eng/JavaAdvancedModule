
import commands.*;
import interfaces.*;
import loggers.CombatLogger;
import loggers.EventLogger;


public class Main {
    public static void main(String[] args) {
        Handler combatLogger = new CombatLogger();
        Handler eventLogger = new EventLogger();
        combatLogger.setSuccessor(eventLogger);

        Attacker attacker = new Warrior("Pesho", 10, combatLogger);
        Attacker attacker2 = new Warrior("Ivan", 5, combatLogger);
        Attacker attacker3 = new Warrior("Tosho", 5, combatLogger);
        Attacker attacker4 = new Warrior("Strahil", 10, combatLogger);
        Attacker attacker5 = new Warrior("Filip", 10, combatLogger);
        Attacker attacker6 = new Warrior("Stamat", 10, combatLogger);

        Targetable target = new Dragon("Gosho", 50, 5, combatLogger);

        CommandExecutor commandExecutor = new CommandExecutor();

        AttackGroup group = new Group();
        group.addMember(attacker);
        group.addMember(attacker2);
        group.addMember(attacker3);
        group.addMember(attacker4);
        group.addMember(attacker5);
        group.addMember(attacker6);

        Command setTarget = new GroupTargetCommand(group, target);
        Command attackerCommand = new GroupAttackCommand(group);

        commandExecutor.execute(setTarget);
        commandExecutor.execute(attackerCommand);
    }
}

