import java.util.Scanner;

public class SumOf2Nums {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int start = Integer.parseInt(scan.nextLine());
        int end = Integer.parseInt(scan.nextLine());
        int magicNum = Integer.parseInt(scan.nextLine());

        int combination = 0;

        for (int i = start; i <= end ; i++) {
            for (int j = start; j <= end ; j++) {

                combination++;

                if ( (i+j) == magicNum){
                    System.out.printf("Combination N:%d (%d + %d = %d)", combination, i,j,magicNum);
                    return;
                }
            }
        }

        System.out.printf("%d combinations - neither equals %d", combination, magicNum);
    }
}
