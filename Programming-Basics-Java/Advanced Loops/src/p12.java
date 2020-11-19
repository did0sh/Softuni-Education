import java.util.Scanner;

public class p12 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());

        int f0 = 1;
        int f1 = 1;
        for (int i = 0; i < num - 1 ; i++) {
            int fNext = f0 + f1;
            f0 = f1;
            f1 = fNext;
        }
        System.out.println(f1);
    }
}
