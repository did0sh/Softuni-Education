package p06_GenericCountMethodDoubles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        List<Box<Double>> items = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < n + 1; i++) {
            Double value = Double.parseDouble(reader.readLine());
            Box<Double> box = new Box<>(value);
            items.add(box);
        }

        System.out.println(countGreater(items, count));

    }
    
    private static <T extends Comparable<T>> int countGreater(List<Box<T>> boxes, int count){
        Box<T> elementToCompare = boxes.get(boxes.size() - 1);

        for (int i = 0; i < boxes.size() - 1; i++) {
            if (boxes.get(i).isGreater(elementToCompare)){
                count++;
            }
        }
        return count;
    }
}
