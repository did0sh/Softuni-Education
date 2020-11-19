import java.util.Scanner;

/**
 * Created by user on 21.9.2017 г..
 */
public class p08_SumOddNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int sumOfOddnumbers = 0;
        int currentNum = 1;

        for (int i = 1; i <= n ; i++) {
            sumOfOddnumbers += currentNum;
            System.out.println(currentNum);
            currentNum+=2;
        }

        System.out.println("Sum: " + sumOfOddnumbers);
    }
}
