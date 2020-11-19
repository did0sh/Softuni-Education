import java.util.Scanner;

public class p05_IntegerToHexAndBinary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int input = Integer.parseInt(scan.nextLine());

        String hex = Integer.toHexString(input).toUpperCase();
        String binary = Integer.toBinaryString(input);

        System.out.println(hex);
        System.out.println(binary);
    }
}
