import java.util.Scanner;

/**
 * Created by user on 29.9.2017 г..
 */
public class p05_SpecialNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());
        int sum = 0;

        String correct = "True";
        String incorrect = "False";


        for (int i = 1; i <= num ; i++) {

            sum = 0;
            if (i < 10){
                sum += i;
            } else {
                sum += i%10 + i/10;
            }

            if (sum == 5 || sum == 7 || sum == 11){
                System.out.printf("%d -> %s%n", i, correct);
            } else {
                System.out.printf("%d -> %s%n", i, incorrect);
            }
        }

    }
}
