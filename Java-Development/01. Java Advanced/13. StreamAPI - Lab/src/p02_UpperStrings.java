import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class p02_UpperStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> names = Arrays.stream(reader.readLine().split("\\s+"))
                .filter(y -> !y.isEmpty())
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        for (String name : names) {
            System.out.printf("%s ",name);
        }
    }
}
