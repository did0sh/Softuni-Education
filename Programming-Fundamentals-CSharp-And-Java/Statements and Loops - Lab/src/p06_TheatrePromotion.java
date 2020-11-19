import java.util.Scanner;

/**
 * Created by user on 21.9.2017 г..
 */
public class p06_TheatrePromotion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String day = scan.nextLine();
        int age = Integer.parseInt(scan.nextLine());

        int price = 0;

        if (day.equals("Weekday")) {
            if (age >= 0 && age <= 18) {
                price = 12;
            } else if (age > 18 && age <= 64) {
                price = 18;
            } else if (age > 64 && age <= 122) {
                price = 12;
            }
        } else if (day.equals("Weekend")){
            if (age >= 0 && age <= 18){
                price = 15;
            } else if (age > 18 && age <= 64){
                price = 20;
            } else if (age > 64 && age <= 122){
                price = 15;
            }
        } else if (day.equals("Holiday")){
            if (age >= 0 && age <= 18){
                price = 5;
            } else if (age > 18 && age <= 64){
                price = 12;
            } else if (age > 64 && age <= 122){
                price = 10;
            }
    }



        if (price == 0){
            System.out.println("Error!");
        } else {
            System.out.printf("%d$", price);
        }


    }
}
