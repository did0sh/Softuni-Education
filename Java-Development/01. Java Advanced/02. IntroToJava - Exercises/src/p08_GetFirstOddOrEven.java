import java.util.Scanner;

public class p08_GetFirstOddOrEven {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] numbers = scan.nextLine().split("\\s+");
        String[] input = scan.nextLine().split("\\s+");

        int countNums = Integer.parseInt(input[1]);
        String oddOrEven = input[2];
        int evenCounter = 0;
        int oddCounter = 0;

        if (oddOrEven.equals("even")) {
            for (String num : numbers) {
                if (Integer.parseInt(num) % 2 == 0 && countNums > evenCounter) {
                    System.out.printf("%d ", Integer.parseInt(num));
                    evenCounter++;
                }
            }
        } else if (oddOrEven.equals("odd")) {
            for (String num : numbers) {
                if (Integer.parseInt(num) % 2 != 0 && countNums > oddCounter) {
                    System.out.printf("%d ", Integer.parseInt(num));
                    oddCounter++;
                }
            }

        }
    }
}

