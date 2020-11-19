import java.util.Scanner;

/**
 * Created by user on 23.9.2017 г..
 */
public class p03_RestaurantDiscount {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int groupSize = Integer.parseInt(scan.nextLine());
        String discountPackage = scan.nextLine();

        int price = 0;
        double totalPrice = 0;


        if (groupSize <= 50){
            System.out.println("We can offer you the Small Hall");
            price = 2500;
        } else if (groupSize > 50 && groupSize <= 100){
            System.out.println("We can offer you the Terrace");
            price = 5000;
        } else if (groupSize > 100 && groupSize <= 120){
            System.out.println("We can offer you the Great Hall");
            price = 7500;
        } else {
            System.out.println("We do not have an appropriate hall.");
            return;
        }


        if (discountPackage.equals("Normal")){
            price += 500;
            totalPrice = (price - price * 0.05)/ groupSize;
            System.out.printf("The price per person is %.2f$", totalPrice);
        } else if (discountPackage.equals("Gold")){
            price += 750;
            totalPrice = (price - price * 0.10)/ groupSize;
            System.out.printf("The price per person is %.2f$", totalPrice);
        } else if (discountPackage.equals("Platinum")){
            price += 1000;
            totalPrice = (price - price * 0.15)/ groupSize;
            System.out.printf("The price per person is %.2f$", totalPrice);
        }

    }
}
