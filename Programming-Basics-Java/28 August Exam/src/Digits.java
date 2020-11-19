import java.util.Scanner;

public class Digits {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());

        int thirdNum = number%10;
        int secondNum = (number/10)%10;
        int firstNum = number/100;

        for (int row = 1; row <= firstNum + secondNum ; row++) {
            for (int col = 1; col <= firstNum + thirdNum ; col++) {
                if (number % 5 == 0){
                    number = number - firstNum;
                } else if (number % 3 == 0){
                    number = number - secondNum;
                } else {
                    number = number + thirdNum;
                }

                System.out.printf("%d ", number);
            }
            System.out.println();
        }
    }
}
