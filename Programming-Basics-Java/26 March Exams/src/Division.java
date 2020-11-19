import java.util.Scanner;

public class Division {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int count = Integer.parseInt(scan.nextLine());
        double sum2 = 0;
        double sum3 = 0;
        double sum4 = 0;

        for (int i = 0; i < count ; i++) {
            int number = Integer.parseInt(scan.nextLine());

            if (count >=1 && count <=1000){
                if (number % 2 == 0){
                    sum2 += 1;
                }

                if (number % 3 == 0){
                    sum3 += 1;
                }

                if (number % 4 == 0){
                    sum4 += 1;
                }
            }
        }

        double procent2 = (sum2 * 100)/count;
        double procent3 = (sum3 * 100)/count;
        double procent4 = (sum4 * 100)/count;

        System.out.printf("%.2f%%\n",procent2);
        System.out.printf("%.2f%%\n",procent3);
        System.out.printf("%.2f%%",procent4);
    }
}
