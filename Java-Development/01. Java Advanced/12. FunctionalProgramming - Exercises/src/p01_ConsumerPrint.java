import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class p01_ConsumerPrint {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> names = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());

        Consumer<String> print = System.out::println;
        for (String name : names) {
            print.accept(name);
        }
    }
}
