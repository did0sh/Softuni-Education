package p09_CustomListIterator;

import java.util.List;

public class Sorter<T extends Comparable<T>> extends CustomListImpl<T> {
    public static <T extends Comparable<T>> void sort(CustomListImpl<T> list){
        List<T> data = list.getList();
        for (int i = 0; i < data.size() - 1; i++) {
            T currentElement = data.get(i);
            T nextElement = data.get(i + 1);

            if (currentElement.compareTo(nextElement) > 0){
                data.set(i, nextElement);
                data.set(i + 1, currentElement);
                i = -1;
            }
        }
    }
}
