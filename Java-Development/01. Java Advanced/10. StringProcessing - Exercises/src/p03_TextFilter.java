import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class p03_TextFilter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split(", ");
        String text = reader.readLine();
        for (int i = 0; i < tokens.length ; i++) {
            String bannedWord = tokens[i];
            int index = text.indexOf(bannedWord);
            while (index != -1){
                text = text.replaceFirst(bannedWord, String.join("",Collections.nCopies(bannedWord.length(),  "*")));
                index = text.indexOf(bannedWord);
            }
        }
        System.out.println(text);
    }
}
