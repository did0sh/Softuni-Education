import java.util.Scanner;

public class GrapeAndRakiya {
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);

        double lozeVolume = Double.parseDouble(scan.nextLine());
        double kilograms = Double.parseDouble(scan.nextLine());
        double brak = Double.parseDouble(scan.nextLine());

        double grapeLeft = (lozeVolume * kilograms) - brak;

        double rakiyaKg = 0.45 * grapeLeft;
        double rakiyaLiters = rakiyaKg / 7.5;
        double rakiaPrihod = rakiyaLiters * 9.80;

        double grapeForSale = grapeLeft * 0.55;
        double grapePrihod = grapeForSale * 1.50;

        System.out.printf("%.2f%n", rakiaPrihod);
        System.out.printf("%.2f",grapePrihod);

    }
}
