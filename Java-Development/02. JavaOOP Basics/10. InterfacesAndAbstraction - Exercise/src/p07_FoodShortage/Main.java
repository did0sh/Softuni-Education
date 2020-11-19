package p07_FoodShortage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(reader.readLine());
        Map<String, Buyer> allBuyers = new LinkedHashMap<>();

        for (int i = 0; i < lines; i++) {
            String[] info = reader.readLine().split("\\s+");
            String name = info[0];
            int age = Integer.parseInt(info[1]);
            switch (info.length){
                case 4:
                    String id = info[2];
                    String birthDate = info[3];

                    Buyer citizen = new Citizen(name,age,id,birthDate);
                    allBuyers.put(name, citizen);
                    break;
                case 3:
                    String group = info[2];
                    Buyer rebel = new Rebel(name,age,group);
                    allBuyers.put(name, rebel);
                    break;
            }
        }

        String input;
        StringBuilder sb = new StringBuilder();
        while (!"end".equalsIgnoreCase(input = reader.readLine())){
            if (allBuyers.containsKey(input)){
                allBuyers.get(input).buyFood();
            }
        }

       int allBoughtFood = allBuyers.entrySet().stream().mapToInt(kv -> kv.getValue().getFood()).sum();
        System.out.println(allBoughtFood);
    }
}
