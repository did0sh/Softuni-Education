import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class p07_MatchingBrackets {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        ArrayDeque<Integer> stack  = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '('){
                stack.push(i);
            } else if (ch == ')'){
                int index = stack.pop();
                String output = input.substring(index, i+1);
                System.out.println(output);
            }
        }
    }
}
