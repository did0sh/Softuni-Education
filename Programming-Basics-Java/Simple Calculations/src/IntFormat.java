import java.util.Scanner;

public class IntFormat {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a=7;
        System.out.printf(":%d\n", a);
        System.out.printf(":%3d\n", a);
        System.out.printf(":%03d\n", a);
    }
}

