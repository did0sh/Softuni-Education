import java.util.Scanner;

public class HalfSumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int count = Integer.parseInt(scan.nextLine());
        int max = Integer.MIN_VALUE;
        int sumPlusMax = 0;
        int sumOtherNumbers = 0;

        for (int i = 0; i < count ; i++) {
            int number = Integer.parseInt(scan.nextLine());
            sumPlusMax += number;
            if (number > max){
                max = number;
            }
        }

        sumOtherNumbers = sumPlusMax - max;

        if (sumPlusMax == max * 2){
            System.out.println("Yes, Sum = " + max);
        } else {
            System.out.println("No, Diff = " + Math.abs(max - sumOtherNumbers));
        }
    }
}
