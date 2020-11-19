import java.text.DecimalFormat;
import java.util.Scanner;

public class SmartLilly {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int age = Integer.parseInt(scan.nextLine());
        double priceForWashingMachine = Double.parseDouble(scan.nextLine());
        int priceForAToy = Integer.parseInt(scan.nextLine());

        int sumToys = 0;
        int sumLeva = 0;
        int totalSum = 0;
        int yearsSheHasMoney = 0;

        for (int i = 1; i <= age ; i++) {
            if (i % 2 == 0){
                sumLeva+=10;
                totalSum +=sumLeva;
                yearsSheHasMoney ++;
            } else {
                sumToys++;
            }
        }

        int sellToys = sumToys * priceForAToy;
        int brotherTakeMoney = yearsSheHasMoney;
        double moneyLeft = (totalSum + sellToys) - brotherTakeMoney;
        double difference = Math.abs(moneyLeft - priceForWashingMachine);

        if (moneyLeft >= priceForWashingMachine){
            System.out.printf("Yes! %.2f", difference);
        } else {
            System.out.printf("No! %.2f", difference);
        }
    }
}
