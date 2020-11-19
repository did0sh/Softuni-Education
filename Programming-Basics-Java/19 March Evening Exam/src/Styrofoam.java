import java.util.Scanner;

public class Styrofoam {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        double houseVolume = Double.parseDouble(scan.nextLine());
        int windows = Integer.parseInt(scan.nextLine());
        double styrofoam = Double.parseDouble(scan.nextLine());
        double styrofoamPrice = Double.parseDouble(scan.nextLine());

        double volumeLeft = houseVolume - windows * 2.4;
        double pribavqne = volumeLeft + 0.1*volumeLeft;
        double packetsNeeded = Math.ceil(pribavqne / styrofoam);
        double priceForAllPackets = packetsNeeded * styrofoamPrice;

        double difference = Math.abs(budget - priceForAllPackets);

        if (priceForAllPackets <= budget){
            System.out.printf("Spent: %.2f%n", priceForAllPackets);
            System.out.printf("Left: %.2f", difference);
        } else {
            System.out.printf("Need more: %.2f",difference);
        }
    }
}
