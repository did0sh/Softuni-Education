package p04_ListUtilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        Collections.addAll(integerList, 1, 2, 18, 0, -1, 10);

        Integer maxInteger = ListUtils.getMax(integerList);
        Integer minInteger = ListUtils.getMin(integerList);

        System.out.println(maxInteger);
        System.out.println(minInteger);
    }
}
