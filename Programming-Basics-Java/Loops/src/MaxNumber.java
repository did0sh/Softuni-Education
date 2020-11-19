import java.util.Scanner;

public class MaxNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int count = Integer.parseInt(scan.nextLine());
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < count ; i++) {
            int firstNumber = Integer.parseInt(scan.nextLine());
            if (firstNumber > max) {
                max = firstNumber;
            }
        }
            System.out.println(max);
        }
    }

