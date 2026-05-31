import abstractClasses.AbstractHero;
import enums.LogType;
import interfaces.Handler;
import interfaces.Targetable;

public class Warrior extends AbstractHero {

    private static final String ATTACK_MESSAGE = "%s damages %s for %s";

    public Warrior(String id, int dmg, Handler handler) {
        super(id, dmg, handler);
    }

    @Override
    protected void executeClassSpecificAttack(Targetable targetable, int dmg) {
       super.getHandler().handle(LogType.ATTACK,String.format(ATTACK_MESSAGE, this, targetable, dmg));
        targetable.receiveDamage(dmg);
    }


    @Override
    public void setTarget(Targetable target) {

        super.setTarget(target);
    }
}
