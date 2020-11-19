import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class p08_BasicStackOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] components = reader.readLine().split(" ");
        int numbersToPush = Integer.parseInt(components[0]);
        int numbersToPop = Integer.parseInt(components[1]);
        int checkNumber = Integer.parseInt(components[2]);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int minNum = Integer.MAX_VALUE;

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < numbersToPush; i++) {
            stack.push(numbers[i]);
        }
        for (int i = 0; i < numbersToPop; i++) {
            stack.pop();
        }
        if (stack.contains(checkNumber)){
            System.out.println(true);
        } else if (stack.size() == 0) {
            System.out.println(0);
        } else {
            while (stack.size() > 0){
                int currNum = stack.pop();
                if (currNum < minNum){
                    minNum = currNum;
                }
            }
            System.out.println(minNum);
        }
    }
}
