import java.util.Scanner;

public class Money {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int bitcoin = Integer.parseInt(scan.nextLine());
        double chinaIuana = Double.parseDouble(scan.nextLine());
        double comission = Double.parseDouble(scan.nextLine());

        int bitcoinLeva = bitcoin * 1168;
        double chinaIuanaDollars = chinaIuana * 0.15;

        double chinaIuanaLeva = chinaIuanaDollars * 1.76;

        double sum = bitcoinLeva + chinaIuanaLeva;
        double sumInEuro = sum / 1.95;

        double comissionResult = (comission * sumInEuro) / 100;
        double finalResult = sumInEuro - comissionResult;

        System.out.printf("%.2f", finalResult);

    }
}
