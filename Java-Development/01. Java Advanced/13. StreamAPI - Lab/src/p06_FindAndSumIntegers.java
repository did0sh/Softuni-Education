import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class p06_FindAndSumIntegers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Optional<Integer> sum = Arrays.stream(reader.readLine().split("\\s+"))
                .filter(str -> {
                    try {
                        int num = Integer.parseInt(str);
                        return true;
                    }catch (Exception e){
                        return false;
                    }
                }).map(Integer::parseInt)
                .reduce((x,y) -> x + y);

        if (sum.isPresent()){
            System.out.println(sum.get());
        } else {
            System.out.println("No match");
        }
    }
}
