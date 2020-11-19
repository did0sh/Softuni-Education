import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Predicate;

public class p07_PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(reader.readLine());
        String[] words = reader.readLine().split("\\s+");

        Predicate<String> testFunc = word ->{
            if (word.length() <= length){
                return true;
            }
            return false;
        };

        for (String word : words) {
            if (testFunc.test(word)){
                System.out.println(word);
            }
        }
    }
}
