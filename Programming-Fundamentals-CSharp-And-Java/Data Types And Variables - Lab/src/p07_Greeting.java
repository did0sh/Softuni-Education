import java.util.Scanner;

/**
 * Created by user on 29.9.2017 г..
 */
public class p07_Greeting {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String firstname = scan.nextLine();
        String lastname = scan.nextLine();

        int age = Integer.parseInt(scan.nextLine());

        System.out.printf("Hello, %s %s. You are %d years old.", firstname,lastname,age);
    }
}
