import java.util.Scanner;

/**
 * Created by user on 1.10.2017 г..
 */
public class p16_ComparingFloats {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double eps = 0.000001;
        double firsNum = Double.parseDouble(scan.nextLine());
        double secondNum = Double.parseDouble(scan.nextLine());

        boolean areEqual = true;

        if (Math.abs(firsNum-secondNum) >= eps){
            areEqual = false;
        } else if (Math.abs(firsNum-secondNum) < eps){
            areEqual = true;
        }

        String equal = Boolean.toString(areEqual);
        System.out.printf("%s", equal.substring(0,1).toUpperCase() + equal.substring(1));
    }
}
