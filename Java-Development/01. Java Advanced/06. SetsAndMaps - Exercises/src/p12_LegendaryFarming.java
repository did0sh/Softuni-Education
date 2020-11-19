
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class p12_LegendaryFarming {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String, Integer> items = new TreeMap<>();
        TreeMap<String, Integer> junk = new TreeMap<>();
        items.put("shards", 0);
        items.put("fragments", 0);
        items.put("motes", 0);
        boolean notObtained = true;

        while (notObtained){
            String[] tokens  = reader.readLine().split("\\s+");
            for (int i = 0; i < tokens.length; i+=2) {
                String material = tokens[i+1].toLowerCase();
                int quantity = Integer.parseInt(tokens[i]);
                if (("shards".equals(material) || "fragments".equals(material) || "motes".equals(material))){
                    if (!items.containsKey(material)){
                        items.put(material, quantity);
                        if (quantity >= 250){
                            printObtainedItem(items,material);
                            notObtained = false;
                            break;
                        }
                    } else {
                        items.put(material, items.get(material) + quantity);
                        if (items.get(material) >= 250){
                            printObtainedItem(items, material);
                            notObtained = false;
                            break;
                        }
                    }
                } else {
                    if (!junk.containsKey(material)){
                        junk.put(material, quantity);
                    } else {
                        junk.put(material, junk.get(material) + quantity);
                    }
                }
            }
        }

        items.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(x -> System.out.printf("%s: %d%n", x.getKey(), x.getValue()));


        for (Map.Entry<String, Integer> entry : junk.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }

    }
    private static void printObtainedItem(TreeMap<String, Integer> items, String material){
            if ("shards".equals(material)){
                System.out.printf("Shadowmourne obtained!%n", material);
                items.put(material, items.get(material) - 250);
            } else if ("fragments".equals(material)){
                System.out.printf("Valanyr obtained!%n", material);
                items.put(material, items.get(material) - 250);
            } else  if ("motes".equals(material)){
                System.out.printf("Dragonwrath obtained!%n", material);
                items.put(material, items.get(material) - 250);
        }
    }
}
