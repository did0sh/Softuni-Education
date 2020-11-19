import java.util.Scanner;

public class p04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int num = Integer.parseInt(scan.nextLine());

        for (int i = 0; i <= num ; i+=2) {
            System.out.println((int)Math.pow(2, i));
        }
    }
}
