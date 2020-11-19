import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;

public class p02_LittleAlchemy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        ArrayDeque<Integer> stackOfGold = new ArrayDeque<>();

        int[] numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int number : numbers) {
            queue.offer(number);
        }

        String input = reader.readLine();
        while (!"Revision".equalsIgnoreCase(input)){
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            if (command.equalsIgnoreCase("apply") && !queue.isEmpty()){
                int countNum = Integer.parseInt(tokens[2]);
               while (countNum > 0) {
                   if (!queue.isEmpty()){
                       int lastNum = queue.poll();
                       if (lastNum - 1 == 0) {
                           stackOfGold.push(lastNum);
                       } else {
                           queue.offer(lastNum - 1);
                       }
                   } else {
                       break;
                   }

                   countNum--;
               }
            } else if (command.equalsIgnoreCase("air") && !stackOfGold.isEmpty()){
                int lastGoldNum = Integer.parseInt(tokens[2]);
                stackOfGold.pop();
                queue.offer(lastGoldNum);
            }
            input = reader.readLine();
        }

        queue.forEach(num -> System.out.printf("%d ", num));
        System.out.println();
        System.out.println(stackOfGold.size());
    }
}
