import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class p06_DecimalToBinaryConverter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(reader.readLine());
        if (input == 0){
            System.out.println(input);
            return;
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        while (input != 0){
           int binary = input % 2;
            stack.push(binary);
            input /= 2;
        }

        while (stack.size() > 0){
            System.out.print(stack.pop());
        }
    }
}
