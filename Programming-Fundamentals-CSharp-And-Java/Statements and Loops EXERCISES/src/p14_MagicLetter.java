import java.util.Scanner;

/**
 * Created by user on 24.9.2017 г..
 */
public class p14_MagicLetter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char start = scan.nextLine().charAt(0);
        char end = scan.nextLine().charAt(0);
        char unvalidLetter = scan.nextLine().charAt(0);

        for (char i = start; i <= end ; i++) {
            for (char j = start; j <= end ; j++) {
                for (char k = start; k <= end ; k++) {

                    if (i != unvalidLetter && j != unvalidLetter && k != unvalidLetter){
                        System.out.printf("%s%s%s ",i,j,k);
                    }
                }

            }

        }
    }
}
