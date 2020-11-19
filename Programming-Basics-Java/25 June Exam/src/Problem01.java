import java.util.Scanner;

public class Problem01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int days = Integer.parseInt(scan.nextLine());
        int bakers = Integer.parseInt(scan.nextLine());
        int cakes = Integer.parseInt(scan.nextLine());
        int gofreti = Integer.parseInt(scan.nextLine());
        int pancakes = Integer.parseInt(scan.nextLine());


        int sumCakes = cakes * 45;
        double sumGofreti = gofreti * 5.80;
        double sumPancakes = pancakes * 3.20;

        double totalSumForADay = (sumCakes + sumGofreti + sumPancakes)*bakers;
        double sumFromCampaign = totalSumForADay * days;

        double sumAfterTax = sumFromCampaign - 0.125*sumFromCampaign;

        System.out.printf("%.2f", sumAfterTax);

    }
}
