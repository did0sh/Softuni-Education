import java.util.Scanner;

public class p06_HitTheTarget {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int divison;
        int sum;

        for (int i = 1; i <= 20 ; i++) {
            for (int j = 1; j <= 20 ; j++) {
                sum = i + j;
                if (sum == num){
                    System.out.printf("%d + %d = %d%n", i, j, sum);
                }
            }
        }

        for (int i = 1 ; i <= 20 ; i++) {
            for (int j = 1; j <= 20 ; j++) {
                divison = i - j;
                if (divison == num){
                    System.out.printf("%d - %d = %d%n", i, j, divison);
                }
            }
        }
    }
}
