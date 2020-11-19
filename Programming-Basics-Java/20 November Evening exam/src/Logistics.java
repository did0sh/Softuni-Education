import java.util.Scanner;

public class Logistics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());

        int volumeTons = 0;
        int sum3Tons = 0;
        int sum11Tons = 0;
        int sumMoreTons = 0;

        for (int i = 0; i < number ; i++) {
            int tons = Integer.parseInt(scan.nextLine());

            volumeTons += tons;

            if (tons <= 3){
                sum3Tons += tons;
            } else if (tons > 3 && tons <= 11){
                sum11Tons += tons;
            } else if (tons > 11){
                sumMoreTons += tons;
            }
        }

        double average = (sum3Tons * 200 + sum11Tons*175 + sumMoreTons*120)/(double)volumeTons;

        double procentMikrobus = (sum3Tons*100)/(double)volumeTons;
        double procentTruck = (sum11Tons*100)/(double)volumeTons;
        double procentTrain = (sumMoreTons*100)/(double)volumeTons;

        System.out.printf("%.2f%n", average);
        System.out.printf("%.2f%%%n", procentMikrobus);
        System.out.printf("%.2f%%%n", procentTruck);
        System.out.printf("%.2f%%%n", procentTrain);
    }
}
