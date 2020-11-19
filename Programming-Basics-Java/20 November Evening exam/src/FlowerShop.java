import java.util.Scanner;

public class FlowerShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int magnolii = Integer.parseInt(scan.nextLine());
        int ziumbiuli = Integer.parseInt(scan.nextLine());
        int rozi = Integer.parseInt(scan.nextLine());
        int kaktusi = Integer.parseInt(scan.nextLine());
        double priceForGift = Double.parseDouble(scan.nextLine());

        double sum = magnolii*3.25 + ziumbiuli*4 + rozi*3.50 + kaktusi*8;
        double danyk = 0.05*sum;

        double profit = sum - danyk;

        double difference = Math.abs(priceForGift - profit);

        if (profit >= priceForGift){
            System.out.printf("She is left with %.0f leva.", Math.floor(difference));
        } else {
            System.out.printf("She will have to borrow %.0f leva.", Math.ceil(difference));
        }
    }
}
