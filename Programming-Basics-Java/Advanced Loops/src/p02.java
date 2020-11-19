import java.util.Scanner;

public class p02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());

        for (int i = num; i >=1 ; i--) {
            System.out.println(i);
        }
    }
}
