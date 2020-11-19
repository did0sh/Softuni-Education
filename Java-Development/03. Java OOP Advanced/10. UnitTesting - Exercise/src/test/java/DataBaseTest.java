import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import sun.plugin.dom.exception.InvalidStateException;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DataBaseTest {
    private static final int DEFAULT_ARRAY_LENGTH = 16;
    private static final int TEST_ARRAY = 1;

    private DataBase db;

    @Before
    public void init() throws OperationNotSupportedException {
        this.db = new DataBase(TEST_ARRAY);
    }

    @Test()
    public void testDefaultLengthEqualToCreatedArrayLength() throws OperationNotSupportedException {
        Assert.assertEquals(DEFAULT_ARRAY_LENGTH, this.db.getIntegers().length);
    }

    @Test()
    public void constructorWithoutParametersShouldNotThrowException() throws OperationNotSupportedException {
        this.db = new DataBase();
    }

    @Test()
    public void allValuesInAnEmptyArrayShouldBeNull() throws OperationNotSupportedException {
        this.db = new DataBase();
        for (Integer integer : this.db.getIntegers()) {
            if (integer != null){
                throw new InvalidStateException("Value should be null");
            }
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void passingMoreThanCapacitySizeShouldThrowAnException() throws OperationNotSupportedException {
        this.db = new DataBase(new Integer[DEFAULT_ARRAY_LENGTH + 1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void passingNullValueInConstructorShouldThrownAnException() throws OperationNotSupportedException {
        this.db = new DataBase(TEST_ARRAY, null, TEST_ARRAY);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addingNullObjectElementShouldThrowAnException() throws OperationNotSupportedException {
        this.db.add(null);
    }

    @Test()
    public void addingValidObjectToArrayShouldReturnTrue() throws OperationNotSupportedException {
        int numToAddAtFirstPosition = 5;
        this.db.add(numToAddAtFirstPosition);
        int expected = this.db.getIntegers()[1];

        Assert.assertEquals(expected, numToAddAtFirstPosition);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addingMoreElementsThanTheCapacityShouldThrowAnException() throws OperationNotSupportedException {
        for (int i = 0; i < DEFAULT_ARRAY_LENGTH; i++) {
            this.db.add(TEST_ARRAY);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removingElementsFromEmptyArrayShouldThrowAnException() throws OperationNotSupportedException {
        this.db.remove();
        this.db.remove();
    }

    @Test()
    public void removeMethodShouldRemoveTheLastItemFromArray() throws OperationNotSupportedException {
        this.db.add(5);
        this.db.add(10);
        int removeItem = this.db.remove();

        Assert.assertEquals(removeItem, 10);
    }
}