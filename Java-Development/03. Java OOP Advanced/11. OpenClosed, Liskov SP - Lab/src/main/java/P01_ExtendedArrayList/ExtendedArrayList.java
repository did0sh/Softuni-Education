package P01_ExtendedArrayList;

import java.util.ArrayList;
import java.util.Iterator;

public class ExtendedArrayList<T extends Comparable<T>> extends ArrayList<T>{

    public T min(){
        Iterator<T> iterator = super.iterator();
        if (iterator.hasNext()){
            T min = iterator.next();

            while (iterator.hasNext()){
                T nextElement = iterator.next();
                if (nextElement.compareTo(min) < 0){
                    min = nextElement;
                }
            }
            return min;
        }

        return null;
    }

    public T max(){
        Iterator<T> iterator = super.iterator();
        if (iterator.hasNext()){
            T max = iterator.next();

            while (iterator.hasNext()){
                T nextElement = iterator.next();
                if (nextElement.compareTo(max) > 0){
                    max = nextElement;
                }
            }
            return max;
        }

        return null;
    }
}
