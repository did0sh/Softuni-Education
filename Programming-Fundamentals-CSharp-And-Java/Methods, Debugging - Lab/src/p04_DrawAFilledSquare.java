

import java.util.Scanner;

/**
 * Created by user on 3.10.2017 г..
 */
public class p04_DrawAFilledSquare {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int variable = n-2;


        System.out.printf("%s%n", repeatStr('-', n*2));

        while (variable > 0){
            printMiddle(n);
            variable = variable - 1;
        }

        System.out.printf("%s%n", repeatStr('-', n*2));


    }

   private static String repeatStr (char symbol, int count){
        String result = "";

        for (int i = 0; i < count; i++) {
            result += symbol;
        }
        return result;
    }

    static void printMiddle (int n){

        System.out.print("-");
        for (int i = 1; i < n ; i++) {

            System.out.print("\\/");

        }
        System.out.println("-");
    }
}

