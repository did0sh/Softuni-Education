import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class p01_ParkingLot {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> carNumbers = new HashSet<>();
        String input = reader.readLine();

        while (!input.equals("END")){
            String[] components = input.split(", ");
            String movement = components[0];
            String carNum = components[1];
            switch (movement){
                case "IN":
                    carNumbers.add(carNum);
                    break;
                case "OUT":
                    carNumbers.remove(carNum);
                    break;
            }
            input = reader.readLine();
        }

        if (carNumbers.isEmpty()){
            System.out.println("Parking Lot is Empty");
            return;
        }
        for (String car:carNumbers) {
            System.out.println(car);
        }
    }
}
