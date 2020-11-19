import java.util.Scanner;

public class Profit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int workdaysInMonth = Integer.parseInt(scan.nextLine());
        double moneyReceivedPerDay = Double.parseDouble(scan.nextLine());
        double leva = Double.parseDouble(scan.nextLine());

        double monthSalary = workdaysInMonth * moneyReceivedPerDay;
        double yearlySalary = monthSalary*12 + monthSalary*2.5;
        double danyk = 0.25*yearlySalary;

        double dohodInDollars = yearlySalary - danyk;
        double dohodInLeva = dohodInDollars * leva;

        double averageMoney = dohodInLeva / 365;

        System.out.printf("%.2f", averageMoney);
    }
}
