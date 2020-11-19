import java.util.Scanner;

/**
 * Created by user on 29.9.2017 г..
 */
public class p06_TriplesOfLetters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());

        for (char i = 'a'; i < 'a' + num ; i++) {
            for (char j = 'a'; j <'a' + num ; j++) {
                for (char k = 'a'; k < 'a' + num  ; k++) {
                    System.out.printf("%s%s%s%n", i,j,k);
                }

            }

        }
    }
}
