package p05_NullFinder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        Collections.addAll(integers, 1, 2, null, 3, null);

        List<Integer> integerNulls = ListUtils.getNullIndices(integers);

        List<String> strings = new ArrayList<>();
        Collections.addAll(strings, "A", null, null, "D");

        List<Integer> stringNulls = ListUtils.getNullIndices(strings);


        System.out.println(integerNulls);
        System.out.println(stringNulls);

    }
}
