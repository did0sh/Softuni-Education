import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p07_ValidUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Pattern pattern = Pattern.compile("^[\\w-]{3,16}$");
        boolean foundMatch = false;
        StringBuilder sb = new StringBuilder();

        while (!"END".equals(input)){
            Matcher matcher = pattern.matcher(input);
            if (matcher.matches()){
                sb.append("valid" + System.lineSeparator());
                foundMatch = true;
            } else {
                sb.append("invalid" + System.lineSeparator());
            }
            input = reader.readLine();
        }

        if (foundMatch){
            System.out.println(sb.toString());
        }
    }
}
