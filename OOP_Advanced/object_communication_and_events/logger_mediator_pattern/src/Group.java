import interfaces.AttackGroup;
import interfaces.Attacker;
import interfaces.Targetable;

import java.util.ArrayList;
import java.util.List;

public class Group implements AttackGroup {
    private List<Attacker> attackerList;

    public Group() {
        attackerList = new ArrayList<>();
    }

    @Override
    public void addMember(Attacker attacker) {
        this.attackerList.add(attacker);
    }

    @Override
    public void groupTarget(Targetable target) {
        for (Attacker attacker : this.attackerList) {
            attacker.setTarget(target);
        }
    }

    @Override
    public void groupAttack() {
        for (Attacker attacker : this.attackerList) {
            attacker.attack();
        }
    }
}
