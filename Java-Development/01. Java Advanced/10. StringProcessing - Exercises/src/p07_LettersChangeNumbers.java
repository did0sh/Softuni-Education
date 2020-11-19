import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class p07_LettersChangeNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split("\\s+");
        int positionInAlphabetFirst = 0;
        int positionInAlphabetLast = 0;
        double totalSum = 0;

        for (String word : tokens) {
            char firstLetter = word.charAt(0);
            char lastLetter = word.charAt(word.length()-1);
            double numberInBetween = Long.parseLong(word.substring(1, word.length()-1));
            positionInAlphabetFirst = getPositionFirstLetter(firstLetter, positionInAlphabetFirst);
            positionInAlphabetLast = getPositionLastLetter(lastLetter, positionInAlphabetLast);

          totalSum += doOperations(positionInAlphabetFirst, positionInAlphabetLast, firstLetter, lastLetter, numberInBetween);
        }
        System.out.printf("%.2f", totalSum);
    }

    private static double doOperations(int positionInAlphabetFirst, int positionInAlphabetLast, char firstLetter, char lastLetter, double numberInBetween) {
        double sum = 0;
        double totalSum = 0;
        if (Character.isUpperCase(firstLetter)){
            sum = numberInBetween / positionInAlphabetFirst;
        } else if (Character.isLowerCase(firstLetter)){
            sum = numberInBetween * positionInAlphabetFirst;
        }

        if (Character.isUpperCase(lastLetter)){
            sum -= positionInAlphabetLast;
        } else if (Character.isLowerCase(lastLetter)) {
            sum += positionInAlphabetLast;
        }

        totalSum += sum;
        return totalSum;
    }

    private static int getPositionFirstLetter(char firstLetter, int positionInAlphabet) {
        if (Character.isUpperCase(firstLetter)) {
            positionInAlphabet = firstLetter - 64;
        } else if (Character.isLowerCase(firstLetter)) {
            positionInAlphabet = firstLetter - 96;
        }

        return positionInAlphabet;
    }

      private static int getPositionLastLetter (char lastLetter, int positionAlphabet){
          if (Character.isUpperCase(lastLetter)){
              positionAlphabet = lastLetter - 64;
        } else if (Character.isLowerCase(lastLetter)){
              positionAlphabet = lastLetter - 96;
        }
        return positionAlphabet;
    }
}
