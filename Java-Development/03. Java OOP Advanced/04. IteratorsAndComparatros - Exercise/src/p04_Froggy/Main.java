package p04_Froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer[] numbers = Arrays.stream(reader.readLine().split("[,\\s]+"))
                .map(Integer::parseInt).toArray(Integer[]::new);

        Lake lake = new Lake(numbers);

        List<Integer> result = new ArrayList<>();
        for (Integer integer : lake) {
            result.add(integer);
        }

        System.out.println(result.toString().replace("[", "").replace("]", ""));

    }
}
