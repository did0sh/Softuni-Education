import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p01_DharmaSupplies {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern patternCount = Pattern.compile("\\[.*?\\]");
        int countCrates = 0;
        int countLines = 0;
        int countValidCrates = 0;
        List<String> allInputs = new ArrayList<>();
        String input = reader.readLine();
        while (!"collect".equalsIgnoreCase(input)){
            allInputs.add(input);
            countLines++;
            Matcher matcher = patternCount.matcher(input);
            while (matcher.find()){
                countCrates++;
            }
            input = reader.readLine();
        }

        int n = countCrates / countLines;
        Pattern mainPattern = Pattern.compile("\\[(#([\\d]{"+n+"}|[A-Za-z]{"+n+"}))([A-Za-z\\d\\s]+)\\1\\]");
        long totalFood = 0;
        long totalDrinks = 0;
        boolean hasMatch = false;
        LinkedHashSet<Character> distincted = new LinkedHashSet<>();
        for (String allInput : allInputs) {
            Matcher matcher = mainPattern.matcher(allInput);
            while (matcher.find()){
                hasMatch = true;
                long sumWithDigit = 0;
                long sumWithLetter = 0;
                long sum = 0;
                distincted.clear();

                countValidCrates++;
                try {
                    int num = Integer.parseInt(matcher.group(2));
                    char[] lettters = matcher.group(3).toCharArray();
                    for (char lettter : lettters) {
                        distincted.add(lettter);
                    }
                    for (char lettter : distincted) {
                        sumWithDigit += lettter;
                    }
                    sumWithDigit *= n;
                    totalFood += sumWithDigit;
                } catch (Exception e){
                    char[] groupLetters = matcher.group(2).toCharArray();
                    for (char groupLetter : groupLetters) {
                        sumWithLetter += groupLetter;
                    }
                    char[] lettters = matcher.group(3).toCharArray();
                    for (char lettter : lettters) {
                        sum += lettter;
                    }
                    sum *= sumWithLetter;
                    totalDrinks += sum;
                }
            }
        }

        if (hasMatch){
            System.out.printf("Number of supply crates: %d%n", countValidCrates);
            System.out.printf("Amount of food collected: %d%n", totalFood);
            System.out.printf("Amount of drinks collected: %d%n", totalDrinks);
        } else {
            System.out.printf("No supplies found!");
        }

    }
}
