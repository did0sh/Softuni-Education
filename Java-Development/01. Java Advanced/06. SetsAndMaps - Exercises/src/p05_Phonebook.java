import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class p05_Phonebook {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Map<String, String> contacts = new HashMap<>();

        while (!"search".equals(input)){
            String[] components = input.split("-");
            String name = components[0];
            String phoneNumber = components[1];

            contacts.put(name, phoneNumber);
            input = reader.readLine();
        }

        input = reader.readLine();
        while (!"stop".equals(input)){
            if (contacts.containsKey(input)){
                System.out.printf("%s -> %s%n", input, contacts.get(input));
            } else {
                System.out.printf("Contact %s does not exist.%n", input);
            }
            input = reader.readLine();
        }
    }
}
