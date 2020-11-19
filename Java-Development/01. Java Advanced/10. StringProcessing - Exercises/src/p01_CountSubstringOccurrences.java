import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p01_CountSubstringOccurrences {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine().toLowerCase();
        String substring = reader.readLine().toLowerCase();

        int count = 0;
        int index = text.indexOf(substring);
        while (index != -1){
            count++;
            index = text.indexOf(substring, index + 1);
        }

        System.out.println(count);
    }
}
