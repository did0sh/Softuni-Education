import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class p03_FirstName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> names = Arrays.stream(reader.readLine().split("\\s+")).sorted().collect(Collectors.toList());
        List<String> letters = Arrays.stream(reader.readLine().split("\\s+"))
                .distinct()
                .map(String::toLowerCase)
                .collect(Collectors.toList());

        Optional<String> findName = names.stream().filter(name -> {
            if (letters.contains(String.valueOf(name.toLowerCase().charAt(0)))){
                return true;
            }
            return false;
        }).findFirst();

            if (findName.isPresent()){
                System.out.println(findName.get());
            } else {
                System.out.println("No match");
            }
    }
}
