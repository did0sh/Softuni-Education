import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;

public class p05_SimpleCalculator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] arguments = reader.readLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();

        Collections.addAll(stack, arguments);
        int calculation = 0;

        while (stack.size() > 1){
            int firstNum = Integer.parseInt(stack.pop());
            String operand = stack.pop();
            int secondNum = Integer.parseInt(stack.pop());
            if (operand.equals("+")){
                calculation = firstNum + secondNum;
                stack.push(String.valueOf(calculation));
            } else {
                calculation = firstNum - secondNum;
                stack.push(String.valueOf(calculation));
            }
        }
        System.out.println(stack.pop());
    }
}
