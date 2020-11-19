import java.util.Scanner;

public class ControlNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int firstNum = Integer.parseInt(scan.nextLine());
        int secondNum = Integer.parseInt(scan.nextLine());
        int controlNum = Integer.parseInt(scan.nextLine());

        int sum = 0;
        int previousSum = 0;
        int moves = 0;

        for (int i = 1; i <= firstNum ; i++) {
            for (int j = secondNum; j >= 1 ; j--) {

                moves++;
                sum = previousSum + i*2 + j*3;
                previousSum = sum;

                if (sum >= controlNum){
                    System.out.printf("%d moves%n", moves);
                    System.out.printf("Score: %d >= %d", sum, controlNum);
                    return;
                }
            }
        }
        System.out.printf("%d moves", moves);

    }
}
