import java.util.Arrays;
import java.util.Scanner;

public class p09_MostFrequentNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        int[] numbers = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        int mostFrequenNum = 0;
        int biggestFrequency = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            int currentNum = numbers[i];
            int count = 0;


            for (int j = i + 1; j < numbers.length ; j++) {
                if (currentNum == numbers[j]){
                    count++;
                }
            }

            if(count > biggestFrequency){
                biggestFrequency = count;
                mostFrequenNum = currentNum;
            }
        }

        System.out.println(mostFrequenNum);
    }
}
