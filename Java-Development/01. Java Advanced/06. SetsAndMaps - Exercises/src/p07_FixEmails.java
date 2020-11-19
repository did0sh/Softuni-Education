import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class p07_FixEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> contacts = new LinkedHashMap<>();
        while (true){
            String name = reader.readLine();
            if ("stop".equals(name)){
                break;
            }
            String email = reader.readLine();
            if (!contacts.containsKey(name) && !email.toLowerCase().endsWith("us")
                    && !email.toLowerCase().endsWith("uk")
                    && !email.toLowerCase().endsWith("com")){
                contacts.put(name, email);
            }
        }

        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }
    }
}
