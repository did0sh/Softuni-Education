import java.util.Scanner;

public class p06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());

        while (num < 1 || num > 100){
            System.out.println("Invalid number!");
            num = Integer.parseInt(scan.nextLine());
        }
        System.out.println("The number is: " + num);
    }
}
