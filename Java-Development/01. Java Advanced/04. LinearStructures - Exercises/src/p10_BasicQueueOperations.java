import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;

public class p10_BasicQueueOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] components = reader.readLine().split("\\s+");
        int numberToAdd = Integer.parseInt(components[0]);
        int numbersToRemove = Integer.parseInt(components[1]);
        int checkNum = Integer.parseInt(components[2]);
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int[] numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < numberToAdd; i++) {
            queue.offer(numbers[i]);
        }
        for (int i = 0; i < numbersToRemove; i++) {
            queue.removeFirst();
        }
        if (queue.contains(checkNum)){
            System.out.println(true);
        } else {
            if (queue.size() == 0){
                System.out.println(0);
            } else {
                System.out.println(Collections.min(queue));
            }
        }
    }
}
