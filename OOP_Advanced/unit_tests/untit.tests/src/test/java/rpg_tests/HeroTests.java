package rpg_tests;

import interfaces.Target;

import interfaces.Weapon;
import models.Hero;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class HeroTests {

    private static final int TARGET_HEALTH = 5;
    private static final int TARGET_EXPERIENCE = 5;
    private static final int WEAPON_ATTACK_POINTS = 1;
    private static final int GET_DURABILITY = 2;
    public static final String WRONG_EXPERIENCE = "Wrong experience!";


    @Test
    public void heroGainExperienceWhenAttack() {
        Target target = Mockito.mock(Target.class);
        Mockito.when(target.isDead()).thenReturn(true);
        Mockito.when(target.giveExperience()).thenReturn(TARGET_EXPERIENCE);

        Weapon weapon = Mockito.mock(Weapon.class);
        Mockito.when(weapon.getAttackPoints()).thenReturn(WEAPON_ATTACK_POINTS);
        Mockito.when(weapon.getDurabilityPoints()).thenReturn(GET_DURABILITY);


        Hero hero = new Hero("Bob Lazar", weapon);
        hero.attack(target);

        Assert.assertEquals(WRONG_EXPERIENCE, TARGET_EXPERIENCE, hero.getExperience());
    }
}
