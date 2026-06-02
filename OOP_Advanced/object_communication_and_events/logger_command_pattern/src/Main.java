
import commands.AttackCommand;
import commands.CommandExecutor;
import commands.TargetCommand;
import interfaces.Attacker;
import interfaces.Command;
import interfaces.Handler;
import interfaces.Targetable;
import loggers.CombatLogger;
import loggers.EventLogger;


public class Main {
    public static void main(String[] args) {
        Handler combatLogger = new CombatLogger();
        Handler eventLogger = new EventLogger();
        combatLogger.setSuccessor(eventLogger);

        Attacker attacker =  new Warrior("Pesho", 10, combatLogger);

        Targetable target = new Dragon("Gosho",10, 5, combatLogger);

        CommandExecutor commandExecutor = new CommandExecutor();
        Command setTarget = new TargetCommand(attacker, target);
        Command attackerCommand = new AttackCommand(attacker);

       commandExecutor.execute(setTarget);
       commandExecutor.execute(attackerCommand);
        
    }
}

