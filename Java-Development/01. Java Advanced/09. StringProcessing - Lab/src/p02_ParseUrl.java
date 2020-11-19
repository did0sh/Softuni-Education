import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p02_ParseUrl {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        String[] tokens = input.split("://");
        if (tokens.length != 2){
            System.out.printf("Invalid URL");
            return;
        }
        String protocol = tokens[0];

        int index = tokens[1].indexOf("/");
        String server = tokens[1].substring(0,index);
        String resources = tokens[1].substring(index + 1);

        System.out.printf("Protocol = %s%n", protocol);
        System.out.printf("Server = %s%n", server);
        System.out.printf("Resources = %s%n", resources);

    }
}
