import java.util.Arrays;
import java.util.Scanner;

public class p11_EqualSums {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean hasEqualSum = false;

        for (int i = 0; i < numbers.length; i++) {
            int leftSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += numbers[j];
            }

            int rightSum = 0;

            for (int k = i+1; k < numbers.length ; k++) {

                rightSum += numbers[k];
            }

            if(leftSum == rightSum){
                System.out.println(i);
                hasEqualSum = true;
                break;
            }
        }

        if(!hasEqualSum){
            System.out.println("no");
        }
        

    }
}
