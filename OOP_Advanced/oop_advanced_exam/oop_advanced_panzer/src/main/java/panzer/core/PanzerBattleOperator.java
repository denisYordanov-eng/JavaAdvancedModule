package panzer.core;

import panzer.contracts.BattleOperator;
import panzer.contracts.Vehicle;

public class PanzerBattleOperator implements BattleOperator {
    @Override
    public String battle(Vehicle attacker, Vehicle target) {
        double attackerWeight = attacker.getTotalWeight();
        long attackerAttack = attacker.getTotalAttack();
        long attackerDefense = attacker.getTotalDefense();
        long attackerHitPoints = attacker.getTotalHitPoints();

        double targetWeight = target.getTotalWeight();
        long targetAttack = target.getTotalAttack();
        long targetDefense = target.getTotalDefense();
        long targetHitPoints = target.getTotalHitPoints();

        boolean isAttackerTurn = true;

        while (attackerHitPoints > 0 && targetHitPoints > 0) {
            if (isAttackerTurn) {
                long damage = (long) Math.max(0, Math.ceil(attackerAttack - (targetDefense + (targetWeight / 2))));
                targetHitPoints -= damage;
                isAttackerTurn = false;
            } else {
                long damage = (long) Math.max(0, Math.ceil(targetAttack - (attackerDefense + (attackerWeight / 2))));
                attackerHitPoints -= damage;
                isAttackerTurn = true;
            }
        }

        if (attackerHitPoints <= 0) {
            return target.getModel();
        } else {
            return attacker.getModel();
        }

    }
}
