import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p12_VehiclePark {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] arguments = reader.readLine().split(" ");
        List<String> vehicles = new ArrayList<>();
        vehicles.addAll(Arrays.asList(arguments));
        int count = 0;

        String input = reader.readLine();
        while(!input.equals("End of customers!")){
            StringBuilder sb = new StringBuilder();
            String firstWord = input.split(" ")[0];
            String seats = input.split(" ")[2];
            char character = firstWord.toLowerCase().charAt(0);

            String concatenated = sb.append("").append(character).append(seats).toString();
            if (vehicles.contains(concatenated)){
                count++;
                int index = vehicles.indexOf(concatenated);
                System.out.printf("Yes, sold for %d$%n", (int)character * Integer.parseInt(seats));
                vehicles.remove(index);
            } else {
                System.out.println("No");
            }
            input = reader.readLine();
        }

        System.out.printf("Vehicles left: %s%n", String.join(", ", vehicles));
        System.out.printf("Vehicles sold: %d", count);
    }
}
