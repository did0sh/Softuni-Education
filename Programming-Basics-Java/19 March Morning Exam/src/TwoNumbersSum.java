import java.util.Scanner;

public class TwoNumbersSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int firstNum = Integer.parseInt(scan.nextLine());
        int secondNum = Integer.parseInt(scan.nextLine());
        int magicNum = Integer.parseInt(scan.nextLine());
        int combination = 0;

        for (int i = firstNum; i >= secondNum ; i--) {
            for (int j = firstNum; j >= secondNum ; j--) {
                combination++;

                if (j+i == magicNum){
                    System.out.printf("Combination N:%d (%d + %d = %d)", combination, i, j, magicNum);
                    return;
                }
            }
        }
        System.out.printf("%d combinations - neither equals %d", combination, magicNum);
    }
}
