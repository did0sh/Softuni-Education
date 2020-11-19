package rpg_tests;

import interfaces.Target;
import interfaces.Weapon;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.Hero;

public class HeroTests {
    private static final String HERO_NAME = "Superman";
    private static final int TARGET_XP = 5;

    @Test
    public void attackGainsXPIfTargetIsDead(){
        Weapon weaponMock = Mockito.mock(Weapon.class);
        Target targetMock = Mockito.mock(Target.class);

        Mockito.when(targetMock.isDead()).thenReturn(true);
        Mockito.when(targetMock.giveExperience()).thenReturn(TARGET_XP);

        Hero hero = new Hero(HERO_NAME, weaponMock);
        hero.attack(targetMock);

        Assert.assertEquals("Wrong experience", TARGET_XP, hero.getExperience());
    }
}
