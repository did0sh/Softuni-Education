import java.util.Scanner;

public class p03_FormattingNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        double b = scan.nextDouble();
        double c = scan.nextDouble();

        String hex = Integer.toHexString(a).toUpperCase();
        String binary = String.format("%10s", Integer.toBinaryString(a)).replace(" ", "0");

        System.out.printf("|%-10s|%s|%10.2f|%-10.3f|", hex, binary, b, c);
    }
}
