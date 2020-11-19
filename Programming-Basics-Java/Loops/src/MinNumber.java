import java.util.Scanner;

public class MinNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int count = Integer.parseInt(scan.nextLine());
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < count; i++){
            int number = Integer.parseInt(scan.nextLine());
            if (number < min){
                min = number;
            }
        }
        System.out.println(min);
    }
}
