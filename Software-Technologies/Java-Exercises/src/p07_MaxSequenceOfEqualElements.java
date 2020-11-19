import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class p07_MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        ArrayList<Integer> items = new ArrayList<>();
        int[] numbers = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < numbers.length; i++) {
            items.add(numbers[i]);
        }

        int start = 0;
        int length = 1;

        int bestStart = 0;
        int bestLength = 1;

        if (items.size() == 1) {
            System.out.println(items.get(0));
            return;
        }

        int currentElement = items.get(0);
        for (int i = 0; i < items.size(); i++) {

            if (i == items.size() - 1) {
                break;
            }

            if (currentElement == items.get(i + 1)) {
                length++;


                if (length > bestLength) {
                    bestLength = length;
                    bestStart = start;
                }

            } else {
                length = 1;
                start = i + 1;
                currentElement = items.get(i + 1);
            }
        }

        for (int k = bestStart; k < bestStart + bestLength; k++) {
            System.out.printf("%d ", items.get(k));
        }
    }
}
