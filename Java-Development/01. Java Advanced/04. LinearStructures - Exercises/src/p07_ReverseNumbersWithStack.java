import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class p07_ReverseNumbersWithStack {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        int[] input = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int num:input) {
            numbers.push(num);
        }

        while (numbers.size() > 0){
            System.out.printf("%d ", numbers.pop());
        }
    }
}
