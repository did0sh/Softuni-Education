import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class p06_MagixExcheangableWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, Character> chars = new HashMap<>();

        String[] tokens = reader.readLine().split("\\s+");
        String firstWord = tokens[0];
        String secondWord = tokens[1];
        String leftPart = "";

        if (firstWord.length() > secondWord.length()) {
            leftPart = firstWord.substring(secondWord.length());
            firstWord = firstWord.substring(0,secondWord.length());
        } else if (secondWord.length() > firstWord.length()){
            leftPart = secondWord.substring(firstWord.length());
            secondWord = secondWord.substring(0,firstWord.length());
        }

        char[] fwChars = firstWord.toCharArray();
        char[] swChars = secondWord.toCharArray();
        boolean areExchangable = exchange(fwChars, swChars, chars, leftPart);

        System.out.println(areExchangable);

    }

    private static boolean exchange(char[] fwChars, char[] swChars, Map<Character, Character> chars, String leftPart) {

        boolean areExchangable = true;
        for (int i = 0; i < fwChars.length; i++) {
            if (!chars.containsKey(fwChars[i])) {
                if (!chars.containsValue(swChars[i])){
                    chars.put(fwChars[i], swChars[i]);
                } else {
                    areExchangable = false;
                    return areExchangable;
                }
            } else {
                if (chars.get(fwChars[i]) != swChars[i]) {
                    areExchangable = false;
                    return areExchangable;
                }
            }
        }

        if (!leftPart.equals("")){
            char[] lpChars = leftPart.toCharArray();
            int countExchangable = 0;
            for (int i = 0; i < lpChars.length; i++) {
                for (Map.Entry<Character, Character> entry : chars.entrySet()) {
                    if (entry.getKey() != lpChars[i] && entry.getValue() != lpChars[i]){
                        areExchangable = false;
                    } else {
                        countExchangable++;
                        break;
                    }
                }
            }
            if (countExchangable == lpChars.length){
                areExchangable = true;
            }
        }

        return areExchangable;
    }
}
