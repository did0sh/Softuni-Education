import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p06_ExtractTags {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("<.+?>");
        String input = reader.readLine();
        StringBuilder sb = new StringBuilder();
        boolean foundMatch = false;

        while (!"END".equals(input)){
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()){
                sb.append(matcher.group() + System.lineSeparator());
                foundMatch = true;
            }
            input = reader.readLine();
        }

        if (foundMatch){
            System.out.println(sb.toString());
        }
    }
}
