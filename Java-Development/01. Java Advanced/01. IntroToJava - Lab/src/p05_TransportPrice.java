import java.util.Scanner;

public class p05_TransportPrice {
    public static void main(String[] args) {
        double priceOfTrip = 0;

        double initialTaxiTax = 0.7;
        double dayTaxi = 0.79;
        double nightTaxi = 0.9;

        double dayAndNightBus = 0.09;
        double dayAndNightTrain = 0.06;

        Scanner scan = new Scanner(System.in);
        int kilometers = Integer.parseInt(scan.nextLine());
        String type = scan.nextLine();

        if (kilometers < 20){
            if (type.equals("day")){
                priceOfTrip = initialTaxiTax + dayTaxi * kilometers;
            } else if (type.equals("night")){
                priceOfTrip = initialTaxiTax + nightTaxi * kilometers;
            }
        } else if (kilometers < 100) {
            priceOfTrip = dayAndNightBus * kilometers;
        } else {
            priceOfTrip = dayAndNightTrain * kilometers;
        }

        System.out.printf("%.2f", priceOfTrip);
    }
}
