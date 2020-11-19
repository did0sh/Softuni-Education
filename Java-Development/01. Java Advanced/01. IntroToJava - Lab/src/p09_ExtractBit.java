import java.util.Scanner;

public class p09_ExtractBit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int index = scan.nextInt();

        int mask = num >> index;
        int bit = mask & 1;

        System.out.println(bit);
    }
}
