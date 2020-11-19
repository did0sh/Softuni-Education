import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class p16_PoisonousPlants {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int initialPlantsCount = Integer.parseInt(reader.readLine());
        int[] plants = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] days = new int[initialPlantsCount];
        Deque<Integer> temp = new ArrayDeque<>();
        temp.push(0);

        for (int i = 1; i < plants.length; i++) {
            int maxDays = 0;

            while (temp.size() > 0 && plants[temp.peek()] >= plants[i]) {
                maxDays = Math.max(maxDays, days[temp.pop()]);
            }

            if (temp.size() > 0) {
                days[i] = maxDays + 1;
            }

            temp.push(i);
        }

        System.out.println(Arrays.stream(days).max().getAsInt());
    }
}
