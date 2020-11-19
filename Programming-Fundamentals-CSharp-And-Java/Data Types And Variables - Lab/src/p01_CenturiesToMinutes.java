import java.util.Scanner;

/**
 * Created by user on 29.9.2017 г..
 */
public class p01_CenturiesToMinutes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int centuries = Integer.parseInt(scan.nextLine());

        int years = centuries * 100;
        int days = (int)(years * 365.2422);
        int hours = days * 24;
        int minutes = 60 * hours;

        System.out.printf("%d centuries = %d years = %d days = %d hours = %d minutes", centuries, years, days, hours, minutes);
    }
}
