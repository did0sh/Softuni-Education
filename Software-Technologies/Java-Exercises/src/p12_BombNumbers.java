import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class p12_BombNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] tokens = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int bombNumber = tokens[0];
        int bombPower = tokens[1];

        ArrayList<Integer> items = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            items.add(numbers[i]);
        }

        int indexOfBomb = items.indexOf(bombNumber);

        while (items.contains(bombNumber)){
            for (int i = indexOfBomb + 1; i <= indexOfBomb + bombPower; i++) {
                if (indexOfBomb + 1 == items.size() - 1) {
                    items.remove(indexOfBomb + 1);
                    break;
                } else {
                    items.remove(indexOfBomb + 1);
                }
            }

            items.remove(indexOfBomb);

            for (int i = indexOfBomb - 1; i >= indexOfBomb - bombPower ; i--) {
                if (i == 0){
                    items.remove(i);
                    break;
                } else {
                    items.remove(i);
                }
            }

        }

        int sum = 0;
        for (int k = 0; k < items.size(); k++) {
            sum += items.get(k);
        }

        System.out.println(sum);
    }
}
