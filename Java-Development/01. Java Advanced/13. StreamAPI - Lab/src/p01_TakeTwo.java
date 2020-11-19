import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class p01_TakeTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> nums = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .distinct()
                .filter(num -> num >= 10 && num <= 20)
                .limit(2)
                .collect(Collectors.toList());

        for (Integer num : nums) {
            System.out.printf("%d ", num);
        }
    }
}
