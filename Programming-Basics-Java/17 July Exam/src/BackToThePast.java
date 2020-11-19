import java.util.Scanner;

public class BackToThePast {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double moneyReceived = Double.parseDouble(scan.nextLine());
        int yearTillHeLives = Integer.parseInt(scan.nextLine());
        double moneyLeft = 0;
        double spending = 0;
        int age = 17;

        for (int i = 1800; i <= yearTillHeLives; i++) {
            if (i % 2 == 0) {
                if (i == 1800) {
                    moneyLeft = (moneyReceived - 12000);
                } else {
                    moneyLeft = (moneyLeft-12000);
                }

            } else {
                    age+=2;
                    spending = 12000 + age * 50;
                    moneyLeft = (moneyLeft - spending);
            }
        }

        if (moneyLeft >= 0){
            System.out.printf("Yes! He will live a carefree life and will have %.2f dollars left.", moneyLeft);
        } else {
            System.out.printf("He will need %.2f dollars to survive.", Math.abs(moneyLeft));
        }

    }
}

