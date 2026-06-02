package interfaces;

public interface AttackGroup {
    void addMember(Attacker attacker);
    void groupTarget(Targetable target);
    void groupAttack();

}
