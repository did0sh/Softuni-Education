import java.util.Scanner;

public class p01_VariableInHexadecimalFormat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        int hexaDecimal = Integer.parseInt(input, 16);

        System.out.println(hexaDecimal);
    }
}
