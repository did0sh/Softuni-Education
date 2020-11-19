import java.util.Scanner;

public class Problem04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int partsProject = Integer.parseInt(scan.nextLine());
        double moneyPrice = Double.parseDouble(scan.nextLine());

        double sum = 0;

        for (int i = 1; i <= partsProject; i++) {
            int pointsReceived = Integer.parseInt(scan.nextLine());

            if (i%2==0){
                sum += 2*pointsReceived;
            } else {
                sum += pointsReceived;
            }
        }

        double prize = moneyPrice * sum;

        System.out.printf("The project prize was %.2f lv.", prize);
    }
}
