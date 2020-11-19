import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by user on 4.10.2017 г..
 */
public class p04_NumberInReversedOrder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        BigDecimal d = new BigDecimal(scan.nextLine());
        String input = d.toString(); // cast to string
        String reversed = new StringBuffer(input).reverse().toString(); //reverse method
        System.out.println(reversed);


    }
}
