import java.util.Scanner;

public class Problem03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        String fruit = scan.nextLine().toLowerCase();
        String size = scan.nextLine();
        int numberOfDrinks = Integer.parseInt(scan.nextLine());

        double sum = 0;

        if (size.equals("small")){
            if (fruit.equals("watermelon")){
                sum = 2*56;
            } else if (fruit.equals("mango")){
                sum = 2*36.66;
            } else if (fruit.equals("pineapple")){
                sum = 2 * 42.10;
            } else if (fruit.equals("raspberry")){
                sum = 2*20;
            }
        } else if (size.equals("big")){
            if (fruit.equals("watermelon")){
                sum = 5*28.70;
            } else if (fruit.equals("mango")){
                sum = 5*19.60;
            } else if (fruit.equals("pineapple")){
                sum = 5 * 24.80;
            } else if (fruit.equals("raspberry")){
                sum = 5*15.20;
            }
        }

        double priceCoctail = sum * numberOfDrinks;

        if (priceCoctail >= 400 && priceCoctail <= 1000){
            priceCoctail = priceCoctail - 0.15*priceCoctail;
        } else if (priceCoctail > 1000){
            priceCoctail = priceCoctail - 0.5*priceCoctail;
        }

        System.out.printf("%.2f lv.", priceCoctail);
    }
}
