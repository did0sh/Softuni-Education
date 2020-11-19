import java.util.Scanner;

/**
 * Created by user on 21.9.2017 г..
 */
public class p11_OddNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());
        boolean isEven = number%2 == 0;

        while (isEven == true){
            System.out.println("Please write an odd number.");
            number = Integer.parseInt(scan.nextLine());
            isEven = number % 2 == 0;
        }

        System.out.println("The number is: " + Math.abs(number));
    }
}
