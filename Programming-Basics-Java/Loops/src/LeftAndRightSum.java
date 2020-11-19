import java.util.Scanner;

public class LeftAndRightSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int count = Integer.parseInt(scan.nextLine());
        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < count ; i++) {
            int leftNumber = Integer.parseInt(scan.nextLine());
            leftSum += leftNumber;
        }

        for (int i = 0; i < count ; i++) {
            int rightNumber = Integer.parseInt(scan.nextLine());
            rightSum += rightNumber;
        }

        if (leftSum == rightSum){
            System.out.println("Yes, sum = " + leftSum);
        } else {
            System.out.println("No, diff = " + Math.abs(leftSum - rightSum));
        }
    }
}
