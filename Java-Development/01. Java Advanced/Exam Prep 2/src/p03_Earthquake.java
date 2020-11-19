import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p03_Earthquake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        ArrayDeque<List<Integer>> result = new ArrayDeque<>();
        List<Integer> finalRes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            List<Integer> tempList= new ArrayList<>();
            for (int num : nums) {
                tempList.add(num);
            }
            result.offer(tempList);
        }

        while (!result.isEmpty()){
            List<Integer> numbers = result.removeFirst();
            int wave = numbers.get(0);
            for (int i = 1; i < numbers.size(); i++) {
                if (wave < numbers.get(i)){
                    result.addLast(numbers.subList(i, numbers.size()));
                    break;
                }
            }
            finalRes.add(wave);
        }

        System.out.println(finalRes.size());
        for (Integer num : finalRes) {
            System.out.printf("%d ", num);
        }
    }
}
