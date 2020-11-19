import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p12_ExtractEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Pattern pattern = Pattern.compile("(^| )([A-Za-z0-9]+[.\\-_]?[A-Za-z0-9]+@([A-Za-z]+[-]?[A-Za-z]+\\.)+[A-Za-z]+)($| |\\.|,)");
        Matcher matcher = pattern.matcher(input);

        while (!"end".equals(input)){
            while (matcher.find()){
                System.out.println(matcher.group(2));
            }
            input = reader.readLine();
        }
    }
}
