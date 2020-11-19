import java.util.Scanner;

/**
 * Created by user on 21.9.2017 г..
 */
public class p12_NumberChecker {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        try {
            int input = Integer.parseInt(scan.nextLine());
            System.out.println("It is a number.");
        } catch (NumberFormatException ex){
            System.out.println("Invalid input!");
        }
    }
}
