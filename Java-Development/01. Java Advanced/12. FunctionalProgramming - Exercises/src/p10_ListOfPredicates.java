import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;

public class p10_ListOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int lastNumInSequence = Integer.parseInt(reader.readLine());

        int[] divisibleNumbers = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Predicate<Integer> testFunc = num -> {
            for (int i = 0; i < divisibleNumbers.length; i++) {
                if (num % divisibleNumbers[i] != 0){
                    return false;
                }
            }
            return true;
        };

        for (int i = 1; i <= lastNumInSequence; i++) {
            if (testFunc.test(i)){
                System.out.printf("%d ", i);
            }
        }
    }
}
