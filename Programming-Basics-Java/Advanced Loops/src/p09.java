import java.util.Scanner;

public class p09 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());
        int sumDigits = 0;

        while (num > 0){
            sumDigits = sumDigits + num%10;
            num = num/10;
        }
        System.out.println(sumDigits);

    }
}
