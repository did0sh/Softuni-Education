import java.util.Scanner;

/**
 * Created by user on 25.9.2017 г..
 */
public class p01_X {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());


        for (int i = 0; i < n/2 ; i++) {
            System.out.printf("%sx%sx%s%n", repeatStr(' ', i),
                    repeatStr(' ', n - 2 - 2*i),
                    repeatStr(' ', i));
        }

        System.out.printf("%sx%s%n", repeatStr(' ', (n-1)/2),
                repeatStr(' ', (n-1)/2));

        for (int i = n/2 - 1; i >= 0 ; i--) {

            System.out.printf("%sx%sx%s%n", repeatStr(' ', i),
                    repeatStr(' ', n-2-2*i),
                    repeatStr(' ', i));
        }

    }
    private static String repeatStr (char symbol, int count){
        String result = "";

        for (int i = 0; i < count; i++) {
            result += symbol;
        }
        return result;
    }
}
