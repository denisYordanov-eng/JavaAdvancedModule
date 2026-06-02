package abstractClasses;

import enums.LogType;
import interfaces.Attacker;
import interfaces.Handler;
import interfaces.Targetable;

public abstract class AbstractHero implements Attacker{

    private static final String TARGET_NULL_MESSAGE = "interfaces.Target null";
    private static final String NO_TARGET_MESSAGE = "%s has no target";
    private static final String TARGET_DEAD_MESSAGE = "%s is dead";
    private static final String SET_TARGET_MESSAGE = "%s targets %s";

    private String id;
    private int dmg;
    private Targetable targetable;
    private Handler handler;

    public AbstractHero(String id, int dmg,Handler handler) {
        this.id = id;
        this.dmg = dmg;
        this.handler = handler;
    }

    protected Handler getHandler() {
        return this.handler;
    }

    public void setTarget(Targetable targetable) {
        if (targetable == null) {
          this.handler.handle(LogType.ERROR,TARGET_NULL_MESSAGE);
        } else {
            this.targetable = targetable;
           this.handler.handle(LogType.TARGET, String.format(SET_TARGET_MESSAGE, this, targetable));
        }
    }

    public final void attack() {
        if (this.targetable == null) {
            this.handler.handle(LogType.ERROR,String.format(NO_TARGET_MESSAGE, this));
        } else if (this.targetable.isDead()) {
            this.handler.handle(LogType.ATTACK,String.format(TARGET_DEAD_MESSAGE, targetable));
        } else {
            this.executeClassSpecificAttack(this.targetable, this.dmg);
        }
    }

    @Override
    public String toString() {
        return this.id;
    }

    protected abstract void executeClassSpecificAttack(Targetable targetable, int dmg);
}
