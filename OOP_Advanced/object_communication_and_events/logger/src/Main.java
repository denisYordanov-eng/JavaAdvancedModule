
import interfaces.Attacker;
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
        attacker.setTarget(target);
        attacker.attack();
        
    }
}

