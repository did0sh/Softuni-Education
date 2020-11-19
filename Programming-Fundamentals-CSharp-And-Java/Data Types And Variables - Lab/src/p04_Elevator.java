import java.util.Scanner;

/**
 * Created by user on 29.9.2017 г..
 */
public class p04_Elevator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberOfPersons = Integer.parseInt(scan.nextLine());
        int capacity = Integer.parseInt(scan.nextLine());

        int coursesNeeded = (int)Math.ceil((double)numberOfPersons / capacity);

        System.out.println(coursesNeeded);
    }
}
