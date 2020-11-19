import java.util.Scanner;

/**
 * Created by user on 30.9.2017 г..
 */
public class p09_ReversedCharacters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char firstLetter = scan.nextLine().charAt(0);
        char secondLetter = scan.nextLine().charAt(0);
        char lastLettter = scan.nextLine().charAt(0);


        System.out.printf("%s%s%s", lastLettter,secondLetter,firstLetter);
    }
}
