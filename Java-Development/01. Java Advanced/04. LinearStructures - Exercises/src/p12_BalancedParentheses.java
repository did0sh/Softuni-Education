import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class p12_BalancedParentheses {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] input = reader.readLine().toCharArray();
        ArrayDeque<Character> stack = new ArrayDeque<>();

        if (input.length % 2 != 0){
            System.out.println("NO");
            return;
        }
        for (int i = 0; i < input.length; i++) {
            if (input[i] == '[' || input[i] == '{' || input[i] == '('){
                stack.push(input[i]);
            } else {
                char currentElement = stack.pop();

                if (input[i] == ']'){
                    input[i] = '[';
                } else if (input[i] == '}'){
                    input[i] = '{';
                } else if (input[i] == ')'){
                    input[i] = '(';
                }

                if (input[i] != currentElement){
                    System.out.println("NO");
                    return;
                }
            }
        }

        System.out.println("YES");
    }
}
