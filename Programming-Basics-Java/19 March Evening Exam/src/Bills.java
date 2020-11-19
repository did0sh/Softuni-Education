import java.util.Scanner;

public class Bills {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int months = Integer.parseInt(scan.nextLine());
        double sumElectricity = 0;

        double waterPrice = months * 20;
        double internetPrice = months * 15;

        double sumOthersAMonth = 0;
        double sumOthers = 0;

        for (int i = 0; i < months ; i++) {
            double electricityPrice = Double.parseDouble(scan.nextLine());

            sumElectricity += electricityPrice;

            sumOthersAMonth = (electricityPrice + 20 + 15) + 0.2*(electricityPrice + 20 + 15);
            sumOthers += sumOthersAMonth;


        }

        double average = (sumElectricity + waterPrice + internetPrice + sumOthers)/ months;

        System.out.printf("Electricity: %.2f lv%n",sumElectricity);
        System.out.printf("Water: %.2f lv%n",waterPrice);
        System.out.printf("Internet: %.2f lv%n",internetPrice);
        System.out.printf("Other: %.2f lv%n",sumOthers);
        System.out.printf("Average: %.2f lv%n",average);


    }
}
