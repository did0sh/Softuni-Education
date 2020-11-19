package exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;
        CarManager manager = new CarManager();

        while (!"cops are here".equalsIgnoreCase(input = reader.readLine())) {
            String[] info = input.split("\\s+");
            String command = info[0];

            switch (command.toLowerCase()) {
                case "register":
                    int id = Integer.parseInt(info[1]);
                    String type = info[2];
                    String brand = info[3];
                    String model = info[4];
                    int year = Integer.parseInt(info[5]);
                    int horsePower = Integer.parseInt(info[6]);
                    int acceleration = Integer.parseInt(info[7]);
                    int suspension = Integer.parseInt(info[8]);
                    int durability = Integer.parseInt(info[9]);

                    manager.register(id, type, brand, model, year, horsePower, acceleration, suspension, durability);
                    break;
                case "check":
                    System.out.print(manager.check(Integer.parseInt(info[1])));
                    break;
                case "open":
                    manager.open(Integer.parseInt(info[1]), info[2], Integer.parseInt(info[3]), info[4],
                            Integer.parseInt(info[5]));
                    break;
                case "participate":
                    manager.participate(Integer.parseInt(info[1]), Integer.parseInt(info[2]));
                    break;
                case "start":
                    System.out.print(manager.start(Integer.parseInt(info[1])));
                    break;
                case "park":
                    manager.park(Integer.parseInt(info[1]));
                    break;
                case "unpark":
                    manager.unpark(Integer.parseInt(info[1]));
                    break;
                case "tune":
                    manager.tune(Integer.parseInt(info[1]), info[2]);
                    break;
            }
        }
    }
}
