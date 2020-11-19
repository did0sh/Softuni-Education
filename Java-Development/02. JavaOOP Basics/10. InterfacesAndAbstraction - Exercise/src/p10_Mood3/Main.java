package p10_Mood3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> info = Arrays.stream(reader.readLine().split("\\s+\\|\\s+"))
                .filter(x -> !x.isEmpty()).collect(Collectors.toList());

        String username = info.get(0);
        String type = info.get(1);
        int level = Integer.parseInt(info.get(3));
        switch (type){
            case "Demon":
                double specialPoints = Double.parseDouble(info.get(2));
                GameObjects demon = new Demon(username, level, specialPoints);
                System.out.print(demon);
                break;
            case "Archangel":
                int specPoints = Integer.parseInt(info.get(2));
                GameObjects angel = new Archangel(username, level, specPoints);
                System.out.print(angel);
                break;
        }

    }
}
