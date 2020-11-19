package P03_DependencyInversionSkeleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;

        PrimitiveCalculator calculator = new PrimitiveCalculator();

        while (!"end".equalsIgnoreCase(input = reader.readLine())){
            String[] cmdArgs = input.split(" ");
            if (cmdArgs[0].equals("mode")){
                char operationType = cmdArgs[1].charAt(0);
                calculator.changeStrategy(operationType);
            } else {
                System.out.println(calculator.performCalculation(Integer.parseInt(cmdArgs[0]), Integer.parseInt(cmdArgs[1])));
            }
        }
    }
}
