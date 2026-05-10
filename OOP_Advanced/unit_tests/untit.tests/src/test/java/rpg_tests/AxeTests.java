package rpg_tests;

import impl.Axe;
import impl.Dummy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AxeTests {


    public static final int ATTACK_POINTS = 10;
    public static final int DURABILITY_POINTS = 10;
    public static final int HEALTH = 10;
    public static final int EXPERIENCE = 10;


    @Test
    public void weaponAttackLosesDurability(){
        Axe axe = new Axe(ATTACK_POINTS, DURABILITY_POINTS);
        Dummy dummy = new Dummy(HEALTH, EXPERIENCE);

        axe.attack(dummy);

        Assert.assertEquals("Wrong durability!",9, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void brokenWeaponAttack(){
        Axe axe = new Axe(ATTACK_POINTS, DURABILITY_POINTS);
        Dummy dummy = new Dummy(HEALTH, EXPERIENCE);

        axe.attack(dummy);
        axe.attack(dummy);

        Assert.assertEquals(9, axe.getDurabilityPoints());
    }
}
