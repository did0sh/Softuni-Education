package p03_GenericSwapMethodStrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        List<Box<String>> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String value = reader.readLine();
            Box<String> box = new Box<>(value);
            items.add(box);
        }

        int[] indexes = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        swap(items, indexes[0], indexes[1]);

        items.forEach(System.out::print);
    }
    private static <T> void swap(List<Box<T>> boxes, int firstIndex, int secondIndex){
        Box<T> temp = boxes.get(firstIndex);
        boxes.set(firstIndex, boxes.get(secondIndex));
        boxes.set(secondIndex, temp);
    }
}
