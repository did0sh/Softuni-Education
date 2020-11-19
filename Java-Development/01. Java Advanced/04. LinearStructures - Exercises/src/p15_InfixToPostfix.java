import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class p15_InfixToPostfix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        ArrayDeque<String> operators = new ArrayDeque<>();
        ArrayDeque<String> stackNumbers = new ArrayDeque<>();


        for (int i = 0; i < input.length; i++) {
            String currentSymbol = input[i];

            if (!isOperator(currentSymbol)){
                System.out.print(currentSymbol + " ");
            } else if ("*".equals(currentSymbol) || "/".equals(currentSymbol)){
                while (!operators.isEmpty()) {
                    String previousSymbol = operators.pop();
                    if ("*".equals(previousSymbol) || "/".equals(previousSymbol)) {
                        System.out.print(previousSymbol + " ");
                    } else {
                        operators.push(previousSymbol);
                        break;
                    }
                }
                operators.push(currentSymbol);
            } else if ("+".equals(currentSymbol) || "-".equals(currentSymbol)){
                while (!operators.isEmpty()) {
                    String previousSymbol = operators.pop();
                    if ("*".equals(previousSymbol) || "/".equals(previousSymbol) ||
                            "+".equals(previousSymbol) || "-".equals(previousSymbol)) {
                        System.out.print(previousSymbol + " ");
                    } else {
                        operators.push(previousSymbol);
                        break;
                    }
                }
                operators.push(currentSymbol);
            } else if ("(".equals(currentSymbol)) {
                operators.push(currentSymbol);
            } else if (")".equals(currentSymbol)) {
                while (!"(".equals(operators.peek())) {
                    System.out.print(operators.pop() + " ");
                }
                operators.pop();
            }
        }

        while (!operators.isEmpty()) {
            System.out.print(operators.poll() + " ");
        }
    }

    private static boolean isOperator(String symbol){
        return "+".equals(symbol) || "-".equals(symbol) || "*".equals(symbol) || "/".equals(symbol)
                || "^".equals(symbol) || "(".equals(symbol) || ")".equals(symbol);
    }
}
