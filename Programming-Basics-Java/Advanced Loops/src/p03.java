import java.util.Scanner;

public class p03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());

        for (int i = 0; i <= num ; i++) {
            System.out.println((int)Math.pow(2, i));
        }
    }
}
