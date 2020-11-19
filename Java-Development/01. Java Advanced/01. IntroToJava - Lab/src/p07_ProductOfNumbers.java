import java.math.BigInteger;
import java.util.Scanner;

public class p07_ProductOfNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int startNum = scan.nextInt();
        int temp = startNum;
        int endNum = scan.nextInt();
        BigInteger product = BigInteger.ONE;

        do {
           BigInteger number = new BigInteger(String.valueOf(startNum));
           product = product.multiply(number);
           startNum++;
        }while (startNum <= endNum);

        System.out.printf("product[%d..%d] = %d", temp, endNum, product);
    }
}
