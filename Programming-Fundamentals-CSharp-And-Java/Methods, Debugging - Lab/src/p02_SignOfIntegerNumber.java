import java.util.Scanner;

/**
 * Created by user on 3.10.2017 г..
 */
public class p02_SignOfIntegerNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        printSign(n);

    }

    static void printSign(int number) {
        if (number < 0){
            System.out.printf("The number %d is negative.", number);
        } else if (number > 0){
            System.out.printf("The number %d is positive.", number);
        } else {
            System.out.printf("The number %d is zero.", number);
        }
    }
}
