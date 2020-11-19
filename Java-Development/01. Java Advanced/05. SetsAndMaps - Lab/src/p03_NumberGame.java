import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class p03_NumberGame {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashSet<Integer> firstGamer = getNumbers(reader);
        LinkedHashSet<Integer> secondGamer = getNumbers(reader);

        for (int i = 0; i < 50; i++) {
            if (firstGamer.isEmpty() || secondGamer.isEmpty()){
                break;
            }

            int firstNumber = firstGamer.iterator().next();
            firstGamer.remove(firstNumber);

            int firstNumber2ndGamer = secondGamer.iterator().next();
            secondGamer.remove(firstNumber2ndGamer);

            if (firstNumber > firstNumber2ndGamer){
                firstGamer.add(firstNumber);
                firstGamer.add(firstNumber2ndGamer);
            } else if (firstNumber2ndGamer > firstNumber){
                secondGamer.add(firstNumber);
                secondGamer.add(firstNumber2ndGamer);
            } else {
                continue;
            }
        }

        if (firstGamer.size() > secondGamer.size()){
            System.out.println("First player win!");
        }  else if (firstGamer.size() < secondGamer.size()){
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }
    private static LinkedHashSet<Integer> getNumbers(BufferedReader reader) throws IOException {
        LinkedHashSet<Integer> player = new LinkedHashSet<>();
        String[] numbers = reader.readLine().split("\\s+");
        for (String num:numbers) {
            player.add(Integer.parseInt(num));
        }
        return player;
    }
}
