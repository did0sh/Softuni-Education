import java.util.Scanner;

/**
 * Created by user on 4.10.2017 г..
 */
public class p01_HelloName {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        printName(name);
    }

    static void printName (String name){
        System.out.printf("Hello, %s!", name);
    }
}
