import java.util.Scanner;

public class Fishland {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double priceSkumriq = Double.parseDouble(scan.nextLine());
        double priceCaca = Double.parseDouble(scan.nextLine());
        double palamudKg = Double.parseDouble(scan.nextLine());
        double safridKg = Double.parseDouble(scan.nextLine());
        int midiKg = Integer.parseInt(scan.nextLine());


        double pricePalamud = priceSkumriq + 0.6*priceSkumriq;
        double totalPalamud = palamudKg * pricePalamud;


        double priceSafrid =  priceCaca + 0.8*priceCaca;
        double totalSafrid = safridKg * priceSafrid;

        double totalMidi = midiKg * 7.5;

        double totalSum = totalPalamud + totalSafrid + totalMidi;

        System.out.printf("%.2f", totalSum);
    }
}
