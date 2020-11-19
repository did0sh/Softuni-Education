import java.util.Scanner;

/**
 * Created by user on 30.9.2017 г..
 */
public class p08_EmployeeData {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String firstName = scan.nextLine();
        String lastName = scan.nextLine();

        byte age = Byte.parseByte(scan.nextLine());
        char gender = scan.nextLine().charAt(0);
        long personalID = Long.parseLong(scan.nextLine());
        int employeeNumber = Integer.parseInt(scan.nextLine());

        System.out.printf("First name: %s%n",firstName);
        System.out.printf("Last name: %s%n",lastName);
        System.out.printf("Age: %d%n", age);
        System.out.printf("Gender: %s%n",gender);
        System.out.printf("Personal ID: %d%n",personalID);
        System.out.printf("Unique Employee number: %d%n",employeeNumber);
    }
}
