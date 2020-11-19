import java.util.Scanner;

/**
 * Created by user on 3.10.2017 г..
 */
public class p03_PrintingTriangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        printTriangle(n);
    }

    static void printNumbers(int start, int end){

        for (int i = start; i <= end ; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    
    static void printTriangle (int n){
        for (int j = 1; j <= n ; j++) {

            printNumbers(1,j);
        }

        for (int j = n - 1; j >= 1 ; j--) {

            printNumbers(1,j);
        }
    }
}
