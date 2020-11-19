import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class p08_FindTheSmallestElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> func = num -> {
            int minNum = Integer.MAX_VALUE;
            int currIndexMinNum = -1;
            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.get(i) <= minNum){
                    minNum = numbers.get(i);
                    currIndexMinNum = i;
                }
            }
            return currIndexMinNum;
        };

        int minIndex = func.apply(numbers);
        System.out.println(minIndex);
    }
}
