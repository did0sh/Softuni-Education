package exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CommandManager manager = new CommandManager();
        StringBuilder warBuilder = new StringBuilder();
        StringBuilder statusBuilder = new StringBuilder();

        String input;
        while (!"quit".equalsIgnoreCase(input = reader.readLine())){
            String[] info = input.split("\\s+");
            String command = info[0];

            switch (command.toLowerCase()){
                case "bender":
                    manager.createBender(info[1], info[2], Integer.parseInt(info[3]), Double.parseDouble(info[4]));
                    break;
                case "monument":
                    manager.createMonument(info[1], info[2], Integer.parseInt(info[3]));
                    break;
                case "status":
                    statusBuilder.append(manager.status(info[1]));
                    break;
                case "war":
                    warBuilder.append(manager.war(info[1]));
                    manager.removeBendersAndMonuments();
                    break;
            }
        }
        System.out.print(statusBuilder);
        System.out.print(warBuilder);
    }
}
