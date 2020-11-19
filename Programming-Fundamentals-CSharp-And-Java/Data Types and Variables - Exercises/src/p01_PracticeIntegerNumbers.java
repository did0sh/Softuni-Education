import java.math.BigDecimal;

/**
 * Created by user on 30.9.2017 г..
 */
public class p01_PracticeIntegerNumbers {
    public static void main(String[] args) {

        byte num1 = -100;
        short num2 = 128;
        short num3 = -3540;
        int num4 = 64876;
        BigDecimal num5 = new BigDecimal("2147483648");
        long num6 = -1141583228;
        BigDecimal num7 = new BigDecimal("-1223372036854775808");

        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
        System.out.println(num4);
        System.out.println(num5);
        System.out.println(num6);
        System.out.println(num7);


    }
}
