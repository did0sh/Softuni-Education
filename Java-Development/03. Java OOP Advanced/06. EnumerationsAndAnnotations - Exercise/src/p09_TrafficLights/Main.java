package p09_TrafficLights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] signals = reader.readLine().split("\\s+");
        List<TrafficLight> lights = new ArrayList<>();

        for (String signal : signals) {
            TrafficLight trafficLight = new TrafficLight(Signal.valueOf(signal));
            lights.add(trafficLight);
        }

        int updateNum = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < updateNum ; i++) {
            for (TrafficLight light : lights) {
                sb.append(light.update()).append(" ");
            }
            sb.append(System.lineSeparator());
        }

        System.out.print(sb.toString().trim());
    }
}
