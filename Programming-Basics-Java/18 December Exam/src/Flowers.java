import java.util.Scanner;

public class Flowers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberHrizantemi = Integer.parseInt(scan.nextLine());
        int numberRozi = Integer.parseInt(scan.nextLine());
        int numberLaleta = Integer.parseInt(scan.nextLine());
        String season = scan.nextLine();
        String fest = scan.next();

        double priceHrizantemi = 0.0;
        double priceRozi = 0.0;
        double priceLaleta = 0.0;


        if (season.equals("Spring") || season.equals("Summer")){
            priceHrizantemi = 2;
            priceRozi = 4.10;
            priceLaleta = 2.50;
        } else if (season.equals("Autumn") || season.equals("Winter")){
            priceHrizantemi =3.75;
            priceRozi = 4.50;
            priceLaleta = 4.15;
        }

        double price = numberHrizantemi*priceHrizantemi + numberRozi*priceRozi + numberLaleta * priceLaleta;


        if (fest.equals("Y")){
            price = price + 0.15*price;
        } else if (fest.equals("N")){
            price = price;
        }

        if (season.equals("Spring") && numberLaleta > 7) {
            price = price - 0.05 * price;
        }

            if (season.equals("Winter") && numberRozi >= 10) {
                price = price - 0.1 * price;
            }
                if ((numberHrizantemi + numberLaleta + numberRozi) > 20){
                    price = price - 0.2*price;
                }



        double endSum = price + 2;

        System.out.printf("%.2f", endSum);

    }
}
