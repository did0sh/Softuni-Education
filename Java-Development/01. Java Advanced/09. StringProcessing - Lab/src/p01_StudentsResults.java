import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p01_StudentsResults {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] components = reader.readLine().split("-");
        String[] tokens = components[1].split(", ");
        String name = components[0];
        double firstResult = Double.parseDouble(tokens[0]);
        double secondResult = Double.parseDouble(tokens[1]);
        double thirdResult = Double.parseDouble(tokens[2]);

        double average = (firstResult + secondResult + thirdResult) / 3;

        System.out.printf("%-10s|%7s|%7s|%7s|%7s|%n", "Name", "JAdv", "JavaOOP", "AdvOOP", "Average");
        System.out.printf("%-10s|%7.2f|%7.2f|%7.2f|%7.4f|%n", name, firstResult, secondResult, thirdResult, average);
    }
}
