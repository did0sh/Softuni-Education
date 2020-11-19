import java.util.Scanner;

/**
 * Created by user on 1.10.2017 г..
 */
public class p14_IntegerToHexAndBinary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int decimal = Integer.parseInt(scan.nextLine());

        String hexaDecimal = Integer.toHexString(decimal).toUpperCase();
        String binaryDecimal = Integer.toBinaryString(decimal);

        System.out.println(hexaDecimal);
        System.out.println(binaryDecimal);
    }
}
