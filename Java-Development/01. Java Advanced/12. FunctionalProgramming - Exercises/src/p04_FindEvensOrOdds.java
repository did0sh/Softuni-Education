import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.function.Function;
        import java.util.function.Predicate;

public class p04_FindEvensOrOdds {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] components = reader.readLine().split("\\s+");
        int lowerBound = Integer.parseInt(components[0]);
        int upperBound = Integer.parseInt(components[1]);
        String type = reader.readLine();


        Predicate<Integer> testFunc = num -> {
            switch (type){
                case "odd":
                    if (num % 2 == 1 || num % 2 == -1){
                        return true;
                    }
                    break;
                case "even":
                    if (num % 2 == 0){
                        return true;
                    }
                    break;
            }
            return false;
        };

        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = lowerBound; i <= upperBound ; i++) {
            if(testFunc.test(i)){
                numbers.add(i);
            }
        }

        for (Integer number : numbers) {
            System.out.printf("%d ", number);
        }
    }
}
