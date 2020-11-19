import java.util.Scanner;

public class p11 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true){
            try {
                System.out.print("Enter even number: ");
                int num = Integer.parseInt(scan.nextLine());

                if (num % 2 == 0){
                    System.out.println("Even number entered: " + num);
                    break;
                }
                System.out.println("The number is not even.");
            } catch (Exception ex){
                System.out.println("Invalid number!");
            }

        }
    }
}
