import java.util.Scanner;

public class Problem11_USDToBGN {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double dollars = Double.parseDouble(scan.nextLine());
        double constant = 1.79549;
        double leva = dollars * constant;
        String currency = "BGN";
        System.out.printf("%.2f %s", leva, currency);
    }
}
