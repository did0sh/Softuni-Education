import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class p04_AddVat {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Double> doubles = Arrays.stream(reader.readLine().split(", ")).map(Double::parseDouble).collect(Collectors.toList());

        Function<List<Double>, List<Double>> addVat = num ->{
            List<Double> vatNumbers = new ArrayList<>();
            for (Double aDouble : doubles) {
                vatNumbers.add(aDouble * 1.2);
            }
            return vatNumbers;
        };

        List<Double> numbers = addVat.apply(doubles);
        Consumer<List<Double>> print = num ->{
            System.out.printf("Prices with VAT:%n");
            numbers.forEach(el -> System.out.printf("%.2f%n", el));
        };

        print.accept(numbers);
    }
}
