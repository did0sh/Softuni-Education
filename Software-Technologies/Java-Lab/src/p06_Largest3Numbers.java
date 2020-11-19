
import java.util.Arrays;
import java.util.Scanner;

public class p06_Largest3Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] arr = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);

        int numbers = Math.min(3, arr.length);

        for (int i = 0; i < numbers; i++) {
            System.out.println(arr[arr.length - 1 - i]);
        }
    }
}
