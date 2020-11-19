import java.util.Scanner;

public class Operations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scan.nextLine());
        int secondNumber = Integer.parseInt(scan.nextLine());
        String symbol = scan.nextLine();
        int result1 = 0;
        int result2 = 0;
        int result3 = 0;
        double result4 = 0;
        int result5 = 0;

        if (symbol.equals("+")){
            result1 = firstNumber + secondNumber;
            System.out.printf("%d + %d = %d", firstNumber,secondNumber, result1);
            if (result1 % 2 == 0){
                System.out.println(" - even");
                } else {
                System.out.println(" - odd");
            }
        }

        if (symbol.equals("-")){
            result2 = firstNumber - secondNumber;
            System.out.printf("%d - %d = %d",firstNumber,secondNumber,result2);
            if (result2 % 2 == 0){
                System.out.println(" - even");
            } else {
                System.out.println(" - odd");
            }
        }

        if (symbol.equals("*")){
            result3 = firstNumber * secondNumber;
            System.out.printf("%d * %d = %d", firstNumber,secondNumber,result3);
            if (result3 % 2 == 0){
                System.out.println(" - even");
            } else {
                System.out.println(" - odd");
            }
        }

        if (symbol.equals("/")){
            if (secondNumber == 0){
                System.out.printf("Cannot divide %d by zero", firstNumber);
            } else {
                result4 = (double)firstNumber / secondNumber;
                System.out.printf("%d / %d = %.2f",firstNumber,secondNumber,result4);
            }
        }

        if (symbol.equals("%")){
            if (secondNumber == 0){
                System.out.printf("Cannot divide %d by zero", firstNumber);
            } else {
                result5 = firstNumber % secondNumber;
                System.out.printf("%d %% %d = %d", firstNumber, secondNumber,result5);
            }
        }
    }
}

