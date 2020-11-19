import java.util.Scanner;

public class Problem03_GreetingByName {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //System.out.print("Enter your name = ");
        String name = scan.nextLine();
        System.out.printf("Hello, %s!", name);
    }
}
