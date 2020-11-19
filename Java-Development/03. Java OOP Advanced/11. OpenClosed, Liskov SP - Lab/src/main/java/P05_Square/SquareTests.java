package P05_Square;

import org.junit.Assert;
import org.junit.Test;
import sun.plugin.dom.exception.InvalidStateException;

public class SquareTests {
    @Test
    public void getSidesTest() {
        Rectangle square = new Square(5, 5);
        Assert.assertEquals(5, square.getWidth());
        Assert.assertEquals(5, square.getHeight());
    }

    @Test(expected = InvalidStateException.class)
    public void shouldThrowExceptionIfItHasDifferentSides() {
        Rectangle square = new Square(5, 10);
    }

    @Test
    public void testArea(){
        Rectangle square = new Square(5, 5);
        int expected = 25;
        int actual = square.getArea();

        Assert.assertEquals(expected, actual);
    }
}
