import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by user on 3.10.2017 г..
 */
public class p02_NumberChecker {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        try{
            BigInteger number = new BigInteger(scan.nextLine());
            System.out.println("integer");
        } catch (Exception ex){
            System.out.println("floating-point");
        }


    }
}
