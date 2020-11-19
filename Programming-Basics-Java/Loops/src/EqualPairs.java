import java.util.Scanner;

public class EqualPairs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int count = Integer.parseInt(scan.nextLine());
        int prevSum = 0;
        int maxDiff = 0;

        for (int i = 0; i < count; i++) {
            int firstNumber = Integer.parseInt(scan.nextLine());
            int secondNumber = Integer.parseInt(scan.nextLine());
            int currentSum = firstNumber + secondNumber;

            if (i != 0) {


                if (prevSum != currentSum) {
                    int currentDiff = Math.abs(currentSum - prevSum);

                    if (currentDiff > maxDiff) {
                        maxDiff = currentDiff;
                    }
                }
            }
                prevSum = currentSum;
            }

        if (maxDiff == 0) {
            System.out.println("Yes, value=" + prevSum);
        } else {
            System.out.println("No, maxdiff=" + maxDiff);
        }
    }
}
