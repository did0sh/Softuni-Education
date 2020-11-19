import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class p08_BoundedNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> bounds = Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> outputNums = numbers.stream().filter(x -> x >= Collections.min(bounds) && x <= Collections.max(bounds))
                .collect(Collectors.toList());

        for (Integer outputNum : outputNums) {
            System.out.printf("%d ", outputNum);
        }
    }
}
