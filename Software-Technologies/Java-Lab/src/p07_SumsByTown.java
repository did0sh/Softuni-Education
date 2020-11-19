

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.TreeMap;

public class p07_SumsByTown {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        TreeMap<String, Double> items = new TreeMap<>();

        int n = Integer.parseInt(scan.nextLine());
        DecimalFormat df = new DecimalFormat("#.#");

        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("\\|");
            String town = tokens[0].trim();
            double income = Double.parseDouble(tokens[1].trim());

            if(!items.containsKey(town)){
                items.put(town, income);
            } else {
                items.put(town, items.get(town) + income);
            }
        }

        for (String key : items.keySet()) {
            System.out.println(key + " -> " + items.get(key));
        }
    }
}
