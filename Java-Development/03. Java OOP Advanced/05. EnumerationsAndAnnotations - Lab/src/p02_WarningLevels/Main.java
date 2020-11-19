package p02_WarningLevels;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Logger logger = new Logger();

        String importance = reader.readLine();
        String input;

        while (!"end".equalsIgnoreCase(input = reader.readLine())){
            String[] cmdArgs = input.split(": ");
            String imp = cmdArgs[0];
            String message = cmdArgs[1];

            logger.addMessage(imp, message);
        }

        logger.filterMessages(importance);

        for (Message message : logger.getMessages()) {
            System.out.println(message);
        }
    }
}
