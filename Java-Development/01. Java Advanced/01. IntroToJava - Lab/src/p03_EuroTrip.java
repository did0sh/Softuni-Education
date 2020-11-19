import java.math.BigDecimal;
import java.util.Scanner;

public class p03_EuroTrip {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double input = scan.nextDouble();
        double pricePerKilo = 1.20;
        BigDecimal exchangeRate = new BigDecimal("4210500000000");

        BigDecimal totalPriceLeva = new BigDecimal(pricePerKilo * input);
        BigDecimal totalPriceDeutscheMarks = totalPriceLeva.multiply(exchangeRate);

        System.out.printf("%.2f marks", totalPriceDeutscheMarks);
    }
}

