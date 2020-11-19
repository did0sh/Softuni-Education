import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p15_ValidUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Pattern pattern = Pattern.compile("(?<=\\s|\\/|\\\\|\\(|\\)|^)([A-Za-z]{1}[A-Za-z0-9_]{2,24})(?=\\s|\\/|\\\\|\\(|\\)|$)");
        Matcher matcher = pattern.matcher(input);

        ArrayList<String> words = new ArrayList<>();

        long length = 0;
        while (matcher.find()){
            words.add(matcher.group());
        }

        long maxLength = Long.MIN_VALUE;
        String strToPrint = "";
        String secondStrToPrint = "";
        for (int i = 0; i < words.size() - 1; i++) {
            length = 0;
            String firstWord = words.get(i);
            String secondWord = words.get(i+1);

            length += firstWord.length() + secondWord.length();
            if (length > maxLength){
                maxLength = length;
                strToPrint = firstWord;
                secondStrToPrint = secondWord;
            }
        }

        System.out.println(strToPrint);
        System.out.println(secondStrToPrint);
    }
}
