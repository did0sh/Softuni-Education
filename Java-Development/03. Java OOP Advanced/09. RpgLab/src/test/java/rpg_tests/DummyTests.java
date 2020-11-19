package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class DummyTests {
    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
    private static final int DUMMY_HEALTH = 10;
    private static final int DUMMY_EXPERIENCE = 10;
    private static final int EXPECTED_HEALTH = DUMMY_HEALTH - AXE_ATTACK;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void initializeObjects(){
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
    }
    @Test
    public void reducesHealthWhenAttacked(){
        this.axe.attack(this.dummy);
        Assert.assertEquals("Wrong health",EXPECTED_HEALTH, this.dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyThrowsExceptionWhenAttacked(){
        this.axe.attack(this.dummy);
        this.axe.attack(this.dummy);
    }

    @Test
    public void deadDummyCanGiveXP(){
        Axe axe = new Axe(AXE_ATTACK + 1, AXE_DURABILITY);
        axe.attack(this.dummy);

        Assert.assertEquals("Wrong experience value",DUMMY_EXPERIENCE, this.dummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void aliveDummyCanNotGiveXP(){
        Axe axe = new Axe(AXE_ATTACK - 1, AXE_DURABILITY);
        axe.attack(this.dummy);
        this.dummy.giveExperience();
    }
}
