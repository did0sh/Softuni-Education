package p11_Threeuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            String[] line = reader.readLine().split("\\s+");
            if (i == 0) {
                String firstName = line[0];
                String secondName = line[1];
                String address = line[2];
                String town = line[3];
                String fullName = firstName + " " + secondName;

                Threeuple<String, String, String> threeuple = new Threeuple<>(fullName, address, town);
                sb.append(threeuple);
            } else if (i == 1) {
                String name = line[0];
                Integer litersOfBeer = Integer.parseInt(line[1]);
                Boolean isDrunk = false;

                if (line[2].equals("drunk")){
                    isDrunk = true;
                }

                Threeuple<String, Integer, Boolean> threeuple = new Threeuple<>(name, litersOfBeer, isDrunk);
                sb.append(threeuple);
            } else {
                String name = line[0];
                Double accBalance = Double.parseDouble(line[1]);
                String bankName = line[2];
                Threeuple<String, Double, String> threeuple = new Threeuple<>(name, accBalance, bankName);
                sb.append(threeuple);
            }
        }
        System.out.print(sb.toString());
    }
}
