import java.util.Scanner;

public class p10 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());

        boolean isPrime = true;
        int divider = 2;

        if (num < 2){
            isPrime = false;
        }else {
            while (true){
                if (num == 2){
                    isPrime = true;
                } else if (num % divider == 0) {
                    isPrime = false;
                    break;
                }
                divider++;

                if (divider == num){
                    break;
                }
            }

        }

        if (isPrime){
            System.out.println("Prime");
        } else {
            System.out.println("Not prime");
        }

    }
}
