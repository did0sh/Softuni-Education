import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class p01_SortEvenNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = Arrays.stream(reader.readLine().split(", ")).map(Integer::parseInt)
                .collect(Collectors.toList());

        numbers.removeIf(num -> num % 2 != 0);
        printNums(numbers);
        numbers.sort(Integer::compareTo);
        printNums(numbers);
    }
    private static void printNums(List<Integer> numbers){
        System.out.println(numbers.toString().replaceAll("[\\[\\]]", ""));
    }
}
