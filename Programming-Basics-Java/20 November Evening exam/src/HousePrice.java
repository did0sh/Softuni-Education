import java.util.Scanner;

public class HousePrice {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double smallestRoom = Double.parseDouble(scan.nextLine());
        double kitchen = Double.parseDouble(scan.nextLine());
        double price = Double.parseDouble(scan.nextLine());

        double secondRoom = smallestRoom + 0.1*smallestRoom;
        double thirdRoom = secondRoom + 0.1*secondRoom;
        double bath = smallestRoom / 2;

        double volume = smallestRoom + kitchen + secondRoom + thirdRoom + bath;

        double koridor = 0.05*volume;

        volume = volume + koridor;

        double wholePrice = volume*price;

        System.out.printf("%.2f", wholePrice);
    }
}
