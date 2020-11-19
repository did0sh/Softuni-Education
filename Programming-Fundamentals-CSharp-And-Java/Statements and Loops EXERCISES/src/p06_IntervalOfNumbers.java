import java.util.Scanner;

/**
 * Created by user on 23.9.2017 г..
 */
public class p06_IntervalOfNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num1 = Integer.parseInt(scan.nextLine());
        int num2 = Integer.parseInt(scan.nextLine());

        if (num1 > num2){
            for (int i = num2;  i <= num1 ; i++) {
                System.out.println(i);
            }

        } else if (num2 > num1){
            for (int i = num1; i <= num2 ; i++) {
                System.out.println(i);
            }
        }

    }
}
