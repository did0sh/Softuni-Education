package p07_GenericAddAllMethod;

import java.util.ArrayList;
import java.util.List;

public class ListUtils<T> {

    public static <T extends Comparable<T>> T getMin(List<T> list){
        if (list.size() == 0){
            throw new IllegalArgumentException("Empty list.");
        }

        T min = list.get(0);

        for (int i = 1; i < list.size() ; i++) {
            if (min.compareTo(list.get(i)) > 0){
                min = list.get(i);
            }
        }

        return min;
    }

    public static <T extends Comparable<T>> T getMax(List<T> list){
        if (list.size() == 0){
            throw new IllegalArgumentException("Empty list.");
        }

        T max = list.get(0);

        for (int i = 1; i < list.size() ; i++) {
            if (max.compareTo(list.get(i)) < 0){
                max = list.get(i);
            }
        }

        return max;
    }


    public static List<Integer> getNullIndices(List<?> list){
        List<Integer> nulls = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null){
                nulls.add(i);
            }
        }

        return nulls;
    }


    public static <T> void flatten(List<? super T> dest, List<List<? extends T>> source){

        for (List<? extends T> inner : source) {
            dest.addAll(inner);
        }

        System.out.println(dest);
    }

    public static <T> void addAll(List<? super T> dest, List<? extends T> source){

        dest.addAll(source);

        System.out.println(dest);
    }
}
