import java.util.Scanner;

/**
 * Created by user on 1.10.2017 г..
 */
public class p17_PrintPartOfTheASCIITable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int startChar = Integer.parseInt(scan.nextLine());
        int endChar = Integer.parseInt(scan.nextLine());


        for (int i = startChar; i <= endChar ; i++) {
            System.out.printf("%s ", (char)i);
        }

    }
}
