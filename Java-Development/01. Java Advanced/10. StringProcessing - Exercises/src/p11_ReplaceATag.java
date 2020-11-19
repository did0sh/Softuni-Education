import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p11_ReplaceATag {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        StringBuilder sb = new StringBuilder();
        while (!"END".equals(input)){
            sb.append(input).append("\n");
            input = reader.readLine();
        }

        Pattern pattern = Pattern.compile("<a(.*?)>(.*?)<\\/a>", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(sb.toString());
        String result = "";

        while (matcher.find(0)){
            int startIndex = matcher.start();
            int endIndex = matcher.end();
            result = "[URL" + (matcher.group(1)) + "]" + (matcher.group(2)) + "[/URL]";
             sb = sb.replace(startIndex, endIndex, result);
             matcher = pattern.matcher(sb.toString());
        }

        System.out.println(sb.toString());
    }
}
