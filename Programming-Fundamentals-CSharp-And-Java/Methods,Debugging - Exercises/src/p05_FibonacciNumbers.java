import java.util.Scanner;

/**
 * Created by user on 4.10.2017 г..
 */
public class p05_FibonacciNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);



        int n = Integer.parseInt(scan.nextLine());
        int output = fibonacciNums(n);
        System.out.println(output);



    }

    static int fibonacciNums (int n){

        int firstNum = 0;
        int secondNum = 1;
        int sum = 1;

        for (int i = 0; i < n ; i++) {

            sum = firstNum+secondNum;
            firstNum = secondNum;
            secondNum = sum;
        }


        return sum;
    }
}
