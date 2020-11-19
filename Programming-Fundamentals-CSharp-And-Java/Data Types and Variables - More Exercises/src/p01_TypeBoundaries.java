import java.util.Scanner;
import com.sun.jmx.snmp.SnmpUnsignedInt;

/**
 * Created by user on 2.10.2017 г..
 */
public class p01_TypeBoundaries {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String type = scan.nextLine();



        if (type.equals("int")){

            System.out.println(Integer.MAX_VALUE);
            System.out.println(Integer.MIN_VALUE);

        } else if (type.equals("uint")){

            System.out.println(SnmpUnsignedInt.MAX_VALUE);
            System.out.println(0);

        } else if (type.equals("long")) {

            System.out.println(Long.MAX_VALUE);
            System.out.println(Long.MIN_VALUE);

        } else if (type.equals("byte")) {

            System.out.println(255);
            System.out.println(0);

        } else if (type.equals("sbyte")){

            System.out.println(Byte.MAX_VALUE);
            System.out.println(Byte.MIN_VALUE);

        }
    }
}
