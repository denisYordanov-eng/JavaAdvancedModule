package rpg_tests;

import impl.Axe;
import impl.Dummy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DummyTests {

    public static final int HEALTH_WHEN_DUMMY_WANTED_DEAD = 2;
    public static final int EXPERIENCE = 2;
    public static final int ATTACK = 1;
    public static final int DURABILITY = 10;
    public static final int ATTACK_WHEN_DUMMY_WANTED_DEAD = 2;
    public static final int HEALTH_DUMMY_CANT_GIVE_XP = 10;

    private  Dummy dummy;
    private  Axe axe;

    @Before
    public void setup() {
        axe = new Axe(ATTACK, DURABILITY);
        dummy = new Dummy(HEALTH_DUMMY_CANT_GIVE_XP, EXPERIENCE);
    }

    @Test
    public void dummyLosesHealthProperly() {

        dummy = new Dummy(HEALTH_WHEN_DUMMY_WANTED_DEAD,EXPERIENCE);
        axe = new Axe(ATTACK_WHEN_DUMMY_WANTED_DEAD, DURABILITY);
        axe.attack(dummy);
        Assert.assertEquals("Dummy not loses health!", 0,dummy.getHealth());
    }

    @Test(expected=IllegalStateException.class)
    public void deadDummyThrowsExceptionWhenAttack(){
         dummy = new Dummy(HEALTH_WHEN_DUMMY_WANTED_DEAD, EXPERIENCE);
         axe = new Axe(ATTACK_WHEN_DUMMY_WANTED_DEAD, DURABILITY);

        axe.attack(dummy);
        axe.attack(dummy);

        Assert.assertEquals("Attack dead dummy!",0, dummy.getHealth());
    }
    @Test()
        public void dummyDeadCanGiveXp(){
         dummy = new Dummy(2, EXPERIENCE);
         axe = new Axe(3, DURABILITY);

        axe.attack(dummy);


        Assert.assertEquals("Dummy is dead!",EXPERIENCE, dummy.giveExperience());
    }

    @Test(expected=IllegalStateException.class)
    public void aliveDummyCantGiveXp(){
         dummy = new Dummy(HEALTH_DUMMY_CANT_GIVE_XP , EXPERIENCE);

        dummy.giveExperience();


    }

}
