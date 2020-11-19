import java.util.Scanner;

/**
 * Created by user on 23.9.2017 г..
 */
public class p04_Hotel {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String month = scan.nextLine();
        int nightsCount = Integer.parseInt(scan.nextLine());

        double priceStudio = 0;
        double priceDouble = 0;
        double priceSuite = 0;

        int nightsStudio = 0;

        if (month.equals("May") || month.equals("October")){
          priceStudio = 50;
          priceDouble = 65;
          priceSuite = 75;

          if (nightsCount > 7) {
              priceStudio *= 0.95;
          }

            if (month.equals("October") && nightsCount > 7){
                nightsStudio = nightsCount - 1;
            } else {
                nightsStudio = nightsCount;
            }

            System.out.printf("Studio: %.2f lv.%n", priceStudio * nightsStudio);
            System.out.printf("Double: %.2f lv.%n", priceDouble * nightsCount);
            System.out.printf("Suite: %.2f lv.%n", priceSuite * nightsCount);






        } else if (month.equals("June") || month.equals("September")){
            priceStudio = 60;
            priceDouble = 72;
            priceSuite = 82;

            if (nightsCount > 14){
                priceDouble *= 0.9;
            }

            if (month.equals("September") && nightsCount > 7){
                nightsStudio = nightsCount - 1;
            } else {
                nightsStudio = nightsCount;
            }

            System.out.printf("Studio: %.2f lv.%n", priceStudio * nightsStudio);
            System.out.printf("Double: %.2f lv.%n", priceDouble * nightsCount);
            System.out.printf("Suite: %.2f lv.%n", priceSuite * nightsCount);






        } else if (month.equals("July") || month.equals("August") || month.equals("December")){
            priceStudio = 68;
            priceDouble = 77;
            priceSuite = 89;

            if (nightsCount > 14){
                priceSuite *= 0.85;
            }

            System.out.printf("Studio: %.2f lv.%n", priceStudio * nightsCount);
            System.out.printf("Double: %.2f lv.%n", priceDouble * nightsCount);
            System.out.printf("Suite: %.2f lv.%n", priceSuite * nightsCount);
        }



    }
}
