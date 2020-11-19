package app.models.participants;

import app.contracts.Hero;
import app.contracts.Targetable;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

public class WarriorTest {
    private Warrior warrior;

    @Before
    public void setUp() throws Exception {
        this.warrior = new Warrior();
    }

    @Test
    public void receiveReward() throws IllegalAccessException {
        this.warrior.receiveReward(100);
        double expectedGold = 300;
        try {
            Field gold = this.warrior.getClass().getDeclaredField("gold");
            gold.setAccessible(true);
            double actual = (double) gold.get(this.warrior);
            Assert.assertEquals(expectedGold, actual, 0.1);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void takeDamage() {
        this.warrior.takeDamage(30);
        double expectedLeftHealth = 20;
        double actual = this.warrior.getHealth();

        Assert.assertEquals(expectedLeftHealth, actual, 0.1);
    }

//    @Test
//    public void giveReward() {
//        Targetable target = new Boss();
//        this.warrior.giveReward(target);
//
//        double leftWarriorGold = 0;
//        try {
//            Field gold = this.warrior.getClass().getDeclaredField("gold");
//            gold.setAccessible(true);
//            double actual = (double) gold.get(this.warrior);
//            Assert.assertEquals(leftWarriorGold, actual, 0.1);
//        } catch (NoSuchFieldException | IllegalAccessException e) {
//            e.printStackTrace();
//        }
//    }

    @Test
    public void isAliveWhenInitialized() {
        boolean expected = true;
        boolean actual = this.warrior.isAlive();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void staysAliveWhenTakesNotEnoughDamage() {
        boolean expected = true;
        this.warrior.takeDamage(30);

        boolean actual = this.warrior.isAlive();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isDeadWhenTakeMoreDamage() {
        boolean expected = false;
        this.warrior.takeDamage(50);

        boolean actual = this.warrior.isAlive();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkHealthWhenlevelUp() {
        this.warrior.levelUp();
        double expectedHealth = 100;
        double actual = this.warrior.getHealth();

        Assert.assertEquals(expectedHealth, actual, 0.1);
    }

    @Test
    public void checkDexterityWhenlevelUp() {
        this.warrior.levelUp();
        int expectedDexterity = 8;
        int actual = this.warrior.getDexterity();

        Assert.assertEquals(expectedDexterity, actual);
    }

    @Test
    public void checkIntelligenceWhenlevelUp() {
        this.warrior.levelUp();
        int expectedIntelligence = 2;
        int actual = this.warrior.getIntelligence();

        Assert.assertEquals(expectedIntelligence, actual);
    }

    @Test
    public void checkStrengthWhenlevelUp() {
        this.warrior.levelUp();
        int expectedStrength = 10;
        int actual = this.warrior.getStrength();

        Assert.assertEquals(expectedStrength, actual);
    }
}