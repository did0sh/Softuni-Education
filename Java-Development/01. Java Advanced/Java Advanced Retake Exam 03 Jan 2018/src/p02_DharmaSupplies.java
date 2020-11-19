import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class p02_DharmaSupplies {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern patternCrates = Pattern.compile("\\[.*?\\]");
        int countLines = 0;
        int countAllCrates = 0;
        int countValidCrates = 0;
        boolean foundMatch = false;

        String input = reader.readLine();
        List<String> allInputs = new ArrayList<>();

        while (!"collect".equalsIgnoreCase(input)){
            countLines++;
            allInputs.add(input);
            Matcher matcher = patternCrates.matcher(input);
            while (matcher.find()){
                countAllCrates++;
            }
            input = reader.readLine();
        }

        int n = countAllCrates / countLines;
        Pattern pattern = Pattern.compile("\\[(#([\\d]{"+n+"}|[a-z]{"+n+"}))([A-Za-z0-9\\s]+)\\1\\]");
        LinkedHashSet<Character> words = new LinkedHashSet<>();

        long amountOfFood = 0;
        long amountOfDrink = 0;
        long totalFood = 0;
        long totalDrinks = 0;
        long sum = 0;

        for (int i = 0; i < allInputs.size(); i++) {
            Matcher matcher = pattern.matcher(allInputs.get(i));
            while (matcher.find()){
                countValidCrates++;
                foundMatch = true;
                String symbol = matcher.group(2);
                char[] text = matcher.group(3).toCharArray();

                words.clear();
                sum = 0;
                amountOfFood = 0;
                amountOfDrink = 0;

                try{
                    int multiplyNum = Integer.parseInt(symbol);
                    for (char c : text) {
                        words.add(c);
                    }
                    for (Character word : words) {
                        amountOfFood += (int)word;
                    }
                    amountOfFood *= n;
                    totalFood += amountOfFood;
                } catch (Exception e){
                    char[] letters = symbol.toCharArray();
                    for (char letter : letters) {
                        sum+= (int)letter;
                    }
                    for (char c : text) {
                        amountOfDrink += (int)c;
                    }
                    amountOfDrink = amountOfDrink * sum;
                    totalDrinks += amountOfDrink;
                }
            }
        }


        if (foundMatch){
            System.out.printf("Number of supply crates: %d%n", countValidCrates);
            System.out.printf("Amount of food collected: %d%n", totalFood);
            System.out.printf("Amount of drinks collected: %d%n", totalDrinks);
        } else {
            System.out.printf("No supplies found!");
        }

    }
}
