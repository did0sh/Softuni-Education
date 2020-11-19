import java.math.BigDecimal;
import java.util.Scanner;
import java.util.function.LongBinaryOperator;

/**
 * Created by user on 4.10.2017 г..
 */
public class p03_EnglishNameOfLastDigit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long number = Long.parseLong(scan.nextLine());

        number = Math.abs(number);
        returnLastDigit(number);
    }


    static void returnLastDigit (long number){
        long lastDigit = number%10;

        if (lastDigit == 0) {
            System.out.println("zero");
        } else if (lastDigit == 1) {
            System.out.println("one");
        } else if (lastDigit == 2) {
            System.out.println("two");
        } else if (lastDigit == 3) {
            System.out.println("three");
        } else if (lastDigit == 4) {
            System.out.println("four");
        } else if (lastDigit == 5) {
            System.out.println("five");
        } else if (lastDigit == 6) {
            System.out.println("six");
        } else if (lastDigit == 7) {
            System.out.println("seven");
        } else if (lastDigit == 8) {
            System.out.println("eight");
        } else if (lastDigit == 9) {
            System.out.println("nine");
        }
    }
}
