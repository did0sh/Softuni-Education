import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

public class p05_AppliedArithmetic {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String command = reader.readLine();

        while (!"end".equals(command)) {
            switch (command) {
                case "add":
                    Function<int[], int[]> addOne = num -> {
                        for (int i = 0; i < numbers.length; i++) {
                            numbers[i]++;
                        }
                        return numbers;
                    };
                    addOne.apply(numbers);
                    break;
                case "multiply":
                    Function<int[], int[]> multiply = num -> {
                        for (int i = 0; i < numbers.length; i++) {
                            numbers[i] *= 2;
                        }
                        return numbers;
                    };
                    multiply.apply(numbers);
                    break;
                case "subtract":
                    Function<int[], int[]> subtract = num -> {
                        for (int i = 0; i < numbers.length; i++) {
                            numbers[i] -= 1;
                        }
                        return numbers;
                    };
                    subtract.apply(numbers);
                    break;
                case "print":
                    Consumer<int[]> print = num -> {
                        for (int i = 0; i < numbers.length; i++) {
                            System.out.printf("%d ",numbers[i]);
                        }
                        System.out.println();
                    };
                    print.accept(numbers);
                    break;
            }
            command = reader.readLine();
        }
    }
}
