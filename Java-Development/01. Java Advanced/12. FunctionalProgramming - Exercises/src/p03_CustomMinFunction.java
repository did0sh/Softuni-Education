import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class p03_CustomMinFunction {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Function<int[], Integer> findSmallestNum = num -> {
            int minNumber = Integer.MAX_VALUE;
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] < minNumber){
                    minNumber = numbers[i];
                }
            }
            return minNumber;
        };

        int min = findSmallestNum.apply(numbers);
        System.out.println(min);
    }
}
