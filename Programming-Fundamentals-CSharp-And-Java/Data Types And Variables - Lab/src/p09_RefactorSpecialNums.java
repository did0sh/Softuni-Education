import java.util.Scanner;

/**
 * Created by user on 29.9.2017 г..
 */
public class p09_RefactorSpecialNums {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numbers = Integer.parseInt(scan.nextLine());
        int sum = 0;
        int currentNum = 0;
        String correct = "True";
        String incorrect = "False";

        for (int i = 1; i <= numbers; i++)
        {
            currentNum = i;
            while (i > 0)
            {
                sum += i % 10;
                i = i / 10;
            }

            if ((sum == 5) || (sum == 7) || (sum == 11)){
                System.out.printf("%d -> %s%n", currentNum, correct);
            } else {
                System.out.printf("%d -> %s%n", currentNum, incorrect);
            }

            sum = 0;
            i = currentNum;
        }

    }
}
