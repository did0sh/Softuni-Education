import java.util.Scanner;

public class AlcoholMarket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double whiskeyPrice = Double.parseDouble(scan.nextLine());
        double quantityBeer = Double.parseDouble(scan.nextLine());
        double quantityWine = Double.parseDouble(scan.nextLine());
        double quantityRakia = Double.parseDouble(scan.nextLine());
        double quantityWhiskey = Double.parseDouble(scan.nextLine());

        double priceRakia = whiskeyPrice / 2.0;
        double priceWine = priceRakia - 0.4*priceRakia;
        double priceBeer = priceRakia - 0.8*priceRakia;

        double sumRakia = quantityRakia * priceRakia;
        double sumWine = quantityWine * priceWine;
        double sumBeer = quantityBeer * priceBeer;
        double sumWhiskey = quantityWhiskey * whiskeyPrice;

        double result = sumBeer + sumRakia + sumWine + sumWhiskey;

        System.out.printf("%.2f", result);
    }
}
