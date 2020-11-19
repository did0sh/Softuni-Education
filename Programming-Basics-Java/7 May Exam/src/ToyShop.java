import java.util.Scanner;

public class ToyShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double tripPrice = Double.parseDouble(scan.nextLine());
        int puzzle = Integer.parseInt(scan.nextLine());
        int doll = Integer.parseInt(scan.nextLine());
        int teddyBear = Integer.parseInt(scan.nextLine());
        int minion = Integer.parseInt(scan.nextLine());
        int truck = Integer.parseInt(scan.nextLine());

        double totalPrice = -1;

        double sum = puzzle*2.60 + doll*3 + teddyBear*4.10 + minion*8.20 + truck*2;
         int toysQuantity = puzzle + doll + teddyBear + minion + truck;

        if (toysQuantity >= 50){
            totalPrice = sum - sum * 0.25;

        } else if (toysQuantity < 50) {
             totalPrice = sum;
        }

        double naem = 0.1*totalPrice;
        double profit = totalPrice - naem;

        if (profit >= tripPrice){
            System.out.printf("Yes! %.2f lv left.",profit - tripPrice);
        } else if (profit < tripPrice){
            System.out.printf("Not enough money! %.2f lv needed.", tripPrice - profit);
        }


    }
}
