

import java.util.Arrays;
import java.util.Scanner;

public class p03_ThreeIntegersSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        int num3 = scan.nextInt();

        if(num1 == num2 + num3){
            if(num2 <= num3){
                System.out.printf("%d + %d = %d", num2, num3, num1);
            } else {
                System.out.printf("%d + %d = %d", num3, num2, num1);
            }

        } else if (num2 == num1 + num3){
            if(num1 <= num3){
                System.out.printf("%d + %d = %d", num1, num3, num2);
            } else {
                System.out.printf("%d + %d = %d", num3, num1, num2);
            }
        } else if (num3 == num1 + num2){
            if(num1 <= num2){
                System.out.printf("%d + %d = %d", num1, num2, num3);
            } else {
                System.out.printf("%d + %d = %d", num2, num1, num3);
            }
        } else {
            System.out.println("No");
        }

    }
}
