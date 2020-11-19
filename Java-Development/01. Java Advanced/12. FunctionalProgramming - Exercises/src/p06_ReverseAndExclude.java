import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class p06_ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> nums = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int divisibleNum = Integer.parseInt(reader.readLine());
        Collections.reverse(nums);

        Function<List<Integer>, List<Integer>> func = num -> {
            for (int i = 0; i < nums.size(); i++) {
                if (nums.get(i) % divisibleNum == 0){
                    nums.remove(i);
                    i--;
                }
            }
            return nums;
        };

        func.apply(nums);
        nums.forEach(num -> System.out.printf("%d ", num));
    }
}
