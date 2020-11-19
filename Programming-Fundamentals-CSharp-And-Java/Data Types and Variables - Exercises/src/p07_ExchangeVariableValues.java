import java.util.Scanner;

/**
 * Created by user on 30.9.2017 г..
 */
public class p07_ExchangeVariableValues {
    public static void main(String[] args) {

        int a = 5;
        int b = 10;

        int reminder = a;

        System.out.printf("Before:%n");
        System.out.printf("a = %d%n", reminder);
        System.out.printf("b = %d%n", b);


        a = b;
        b = reminder;


        System.out.printf("After:%n");
        System.out.printf("a = %d%n", a);
        System.out.printf("b = %d%n", b);
    }
}
