
import java.util.Scanner;

public class p02_SumTwoNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double num1 = Double.parseDouble(scan.nextLine());
        double num2 = Double.parseDouble(scan.nextLine());
        double result = num1 + num2;
        System.out.println(result);
    }
}

