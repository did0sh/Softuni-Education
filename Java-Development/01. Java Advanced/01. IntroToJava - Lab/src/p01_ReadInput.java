import java.util.Scanner;

public class p01_ReadInput {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstWord = scan.next();
        String secondWord = scan.next();
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        int num3 = scan.nextInt();
        scan.nextLine();
        String finalWord = scan.nextLine();

        int sum = num1 + num2 + num3;
        System.out.printf("%s %s %s %d", firstWord, secondWord, finalWord, sum);

    }
}
