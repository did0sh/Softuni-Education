import java.util.Scanner;

/**
 * Created by user on 1.10.2017 г..
 */
public class p13_VowelOrDigit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char input = scan.nextLine().charAt(0);

        if (input == 'a' || input == 'e' || input == 'i' || input == 'o' || input == 'u'){
            System.out.println("vowel");
        } else if (input >= 48 && input <= 57){  // numbers from 0 to 9 in ASCII TABLE
            System.out.println("digit");
        } else {
            System.out.println("other");
        }

    }
}
