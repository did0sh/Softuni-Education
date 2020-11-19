package app.models.actions;

import app.contracts.Action;
import app.contracts.Targetable;
import app.models.participants.Warrior;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;


public class OneVsOneTest {
    private Action oneVsOne;
    private List<Targetable> targetables;
    private Warrior targetable1;
    private Warrior targetable2;
    private static final double DELTA = 1e-15;

    @Before
    public void setUp() throws Exception {
        this.oneVsOne = new OneVsOne();
        this.targetables = new ArrayList<>();

        this.targetable1 = Mockito.mock(Warrior.class);
        this.targetable2 = Mockito.mock(Warrior.class);

        Mockito.when(targetable1.getDamage()).thenReturn(9.0);
        Mockito.when(targetable1.getName()).thenReturn("Pesho");
        Mockito.when(targetable1.getHealth()).thenReturn(400.0);

        Mockito.when(targetable2.getDamage()).thenReturn(399.0);
        Mockito.when(targetable2.getName()).thenReturn("Gosho");
        Mockito.when(targetable2.getHealth()).thenReturn(9.5);


        this.targetables.add(targetable1);
        this.targetables.add(targetable2);
    }

    @Test()
    public void target2ShouldNotBeAlive() {

        this.oneVsOne.executeAction(this.targetables);
        Assert.assertTrue(!this.targetable2.isAlive());
    }

    @Test()
    public void executeActionShouldReturnErrorMessage() {
        this.targetables.add(this.targetable1);

        String expected = "There should be exactly 2 participants for OneVsOne!";
        String actual = this.oneVsOne.executeAction(this.targetables);

        Assert.assertEquals(expected, actual);
    }

    @Test()
    public void executeActionShouldWorkCorrect() {

        StringBuilder sb = new StringBuilder();

        sb.append(String.format(String.format("%s is victorious!%s%s", this.targetable1.getName(), System.lineSeparator(),
                this.targetable1.toString())));

        String actual = this.oneVsOne.executeAction(this.targetables);

        Assert.assertEquals(sb.toString(), actual);
    }

    @Test
    public void winnerLevelsUpCorrectly(){
        double startingStrenth = targetable1.getStrength();
        this.oneVsOne.executeAction(this.targetables);

        Assert.assertEquals(startingStrenth , targetable1.getStrength(),DELTA);
    }
}