import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by user on 30.9.2017 г..
 */
public class p10_CenturiesToNanoseconds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        BigInteger thousand = new BigInteger("1000");
        BigInteger sixty = new BigInteger("60");

        byte centuries = Byte.parseByte(scan.nextLine());

        short years = (short) (100 * centuries);
        int days = (int)(years * 365.2422);
        int hours = days * 24;
        int minutes = hours * 60;


        BigInteger seconds = BigInteger.valueOf(minutes).multiply(sixty);
        BigInteger miliseconds = seconds.multiply(thousand);
        BigInteger microseconds = miliseconds.multiply(thousand);
        BigInteger nanoseconds = microseconds.multiply(thousand);


        System.out.printf("%d centuries = " +
                "%d years = " +
                "%d days = " +
                "%d hours = " +
                "%d minutes = " +
                "%d seconds = " +
                "%s milliseconds = " +
                "%s microseconds = " +
                "%s nanoseconds", centuries, years, days, hours, minutes, seconds, miliseconds, microseconds, nanoseconds);

    }
}
