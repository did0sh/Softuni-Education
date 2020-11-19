import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class p14_DragonArmy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        long damage = 0;
        long health = 0;
        long armor = 0;
        LinkedHashMap<String, TreeMap<String, ArrayList<Long>>> items = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            ArrayList<Long> dragonStats = new ArrayList<>();
            String[] tokens = reader.readLine().split("\\s+");
            String type = tokens[0];
            String dragonName = tokens[1];

            String dmg = tokens[2];
            String hp = tokens[3];
            String arm = tokens[4];

            if (!dmg.equals("null")) {
                damage = Integer.parseInt(dmg);
            } else {
                damage = 45;
            }
            if (!hp.equals("null")) {
                health = Integer.parseInt(hp);
            } else {
                health = 250;
            }
            if (!arm.equals("null")) {
                armor = Integer.parseInt(arm);
            } else {
                armor = 10;
            }

            dragonStats.add(damage);
            dragonStats.add(health);
            dragonStats.add(armor);

            if (!items.containsKey(type)) {
                items.put(type, new TreeMap<>());
                items.get(type).put(dragonName, dragonStats);
            } else {
                items.get(type).put(dragonName, dragonStats);
            }
        }

        LinkedHashMap<String, ArrayList<Double>> mapWithAverage = new LinkedHashMap<>();

        for (String key : items.keySet()) {
            double sumAllDamage = 0;
            double sumAllHealth = 0;
            double sumAllArmor = 0;
            int countEntries = 0;
            ArrayList<Double> averages = new ArrayList<>();
            for (Map.Entry<String, ArrayList<Long>> entry : items.get(key).entrySet()) {
                countEntries++;
                sumAllDamage += entry.getValue().get(0);
                sumAllHealth += entry.getValue().get(1);
                sumAllArmor += entry.getValue().get(2);
            }
            double damageAverage = sumAllDamage / countEntries;
            double healthAverage = sumAllHealth / countEntries;
            double armorAverage = sumAllArmor / countEntries;
            averages.add(damageAverage);
            averages.add(healthAverage);
            averages.add(armorAverage);

            mapWithAverage.put(key, averages);
        }

        for (Map.Entry<String, ArrayList<Double>> entry : mapWithAverage.entrySet()) {
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", entry.getKey(), entry.getValue().get(0), entry.getValue().get(1), entry.getValue().get(2));
            for (Map.Entry<String, ArrayList<Long>> keysAndValues : items.get(entry.getKey()).entrySet()) {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", keysAndValues.getKey(), keysAndValues.getValue().get(0),
                        keysAndValues.getValue().get(1), keysAndValues.getValue().get(2));
            }
        }
    }
}
