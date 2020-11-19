import java.util.Scanner;

/**
 * Created by user on 24.9.2017 г..
 */
public class p12_TestNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int firstDigit = Integer.parseInt(scan.nextLine());
        int secondDigit = Integer.parseInt(scan.nextLine());
        int maxSum = Integer.parseInt(scan.nextLine());
        int multiplySum = 0;
        int combinationsCount = 0;

        for (int i = firstDigit; i >= 1; i--) {
            for (int j = 1; j <= secondDigit; j++) {

                multiplySum += (3 * i * j);
                combinationsCount++;

                if (multiplySum >= maxSum) {
                    System.out.printf("%d combinations%n", combinationsCount);
                    System.out.printf("Sum: %d >= %d", multiplySum, maxSum);
                    return;
                }
            }
        }

        System.out.printf("%d combinations%n", combinationsCount);
        System.out.printf("Sum: %d", multiplySum);
    }
}
