package p10_Tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            String[] info = reader.readLine().split("\\s+");
            if (i == 0){
                String firstItem = info[0] + " " + info[1];
                String secondItem = info[2];
                Tuple<String, String> tuple = new Tuple<>(firstItem, secondItem);
                sb.append(tuple);
            } else if (i == 1){
                String firstItem = info[0];
                Integer secondItem = Integer.parseInt(info[1]);
                Tuple<String, Integer> tuple = new Tuple<>(firstItem, secondItem);
                sb.append(tuple);
            } else {
                Integer firstItem = Integer.parseInt(info[0]);
                Double secondItem = Double.parseDouble(info[1]);
                Tuple<Integer, Double> tuple = new Tuple<>(firstItem, secondItem);
                sb.append(tuple);
            }
        }
        System.out.print(sb.toString());
    }
}
