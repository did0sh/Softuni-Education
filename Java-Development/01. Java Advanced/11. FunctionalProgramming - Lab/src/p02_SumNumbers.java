import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class p02_SumNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = Arrays.stream(reader.readLine().split(", ")).map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> sumFunc = num -> {
            int sum = 0;
            for (Integer number : numbers) {
                sum += number;
            }
            return sum;
        };

        int sum = sumFunc.apply(numbers);
        System.out.printf("Count = %d%n",numbers.size());
        System.out.printf("Sum = %d", sum);
    }
}
