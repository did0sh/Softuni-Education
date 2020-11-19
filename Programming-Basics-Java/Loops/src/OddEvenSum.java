import java.util.Scanner;

public class OddEvenSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int count = Integer.parseInt(scan.nextLine());
        int evenSum = 0;
        int oddSum = 0;

        for (int i = 0; i < count ; i++) {
            int number = Integer.parseInt(scan.nextLine());
            if (i % 2 == 0){
                evenSum += number;
            } else {
                oddSum += number;
            }
        }
        int diff = Math.abs(evenSum - oddSum);

        if (diff == 0){
            System.out.println("Yes Sum = " + evenSum);
        } else {
            System.out.println("No Diff = " + diff);
        }

    }
}
