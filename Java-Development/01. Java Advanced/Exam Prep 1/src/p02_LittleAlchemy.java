import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class p02_LittleAlchemy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        String[] tokens = reader.readLine().split(" ");
        for (int i = 0; i < tokens.length; i++) {
            queue.offer(Integer.parseInt(tokens[i]));
        }

        String input = reader.readLine();
        while (!"revision".equalsIgnoreCase(input)){
            String[] commands = input.split(" ");
            String command = commands[0];
            int num = Integer.parseInt(commands[2]);

            switch (command){
                case "Apply":
                    while (num > 0){
                        if (queue.isEmpty()){
                            break;
                        }
                        int manipulatedNum = queue.getFirst();
                        if (manipulatedNum - 1 == 0){
                            stack.add(manipulatedNum);
                            queue.removeFirst();
                            num--;
                        } else {
                            queue.addLast(manipulatedNum - 1);
                            queue.removeFirst();
                            num--;
                        }
                    }
                    break;
                case "Air":
                    if (!stack.isEmpty()){
                        int lastNum = stack.pop();
                        queue.addLast(num);
                    }
                    break;
            }
            input = reader.readLine();
        }
        for (Integer integer : queue) {
            System.out.printf("%d ", integer);
        }
        System.out.println();
        System.out.println(stack.size());
    }
}
