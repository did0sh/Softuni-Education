import java.text.DecimalFormat;
import java.util.Scanner;

public class FruitsAndVegetables {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double priceVegetables = Double.parseDouble(scan.nextLine());
        double priceFruits = Double.parseDouble(scan.nextLine());
        int vegetablesKg = Integer.parseInt(scan.nextLine());
        int fruitsKg = Integer.parseInt(scan.nextLine());

        DecimalFormat df = new DecimalFormat("#.################");

        double sum = (priceVegetables * vegetablesKg) + (priceFruits * fruitsKg);
        System.out.println(df.format(sum/1.94));
    }
}
