import javax.naming.OperationNotSupportedException;
import java.util.Arrays;

public class DataBase {
    private Integer[] integers;
    private static final Integer CAPACITY = 16;
    private int index;

    public DataBase(Integer... integers) throws OperationNotSupportedException {
        this.setIntegers(integers);
        this.index = integers.length;
    }

    public Integer[] getIntegers() {
        return this.integers;
    }

    public void setIntegers(Integer... integers) throws OperationNotSupportedException {
        if (integers.length > CAPACITY) {
            throw new OperationNotSupportedException("Invalid array length");
        }

        for (Integer integer : integers) {
            if (integer == null) {
                throw new OperationNotSupportedException();
            }
        }

        this.integers = Arrays.copyOf(integers, CAPACITY);
    }

    public void add(Integer item) throws OperationNotSupportedException {
        if (item == null){
            throw new OperationNotSupportedException();
        }
        if (this.index >= CAPACITY) {
            throw new OperationNotSupportedException("DatabaseImpl cannot store more than 16 elements");
        }
        this.integers[index++] = item;
    }

    public Integer remove() throws OperationNotSupportedException {
        if (this.index == 0) {
            throw new OperationNotSupportedException();
        }
        Integer lastElement = this.integers[--this.index];
        this.integers[this.index] = null;
        return lastElement;
    }
}
