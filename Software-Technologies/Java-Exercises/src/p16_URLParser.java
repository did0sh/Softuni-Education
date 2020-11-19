import java.util.Scanner;

public class p16_URLParser {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String protocol = "";
        String inner = "";

        String url = scan.nextLine();
        String[] firstSplit = url.split("://");
        if (firstSplit.length > 1) {
            protocol = firstSplit[0];
            inner = firstSplit[1];
        } else {
            inner = url;
        }
        String server = "";
        String route = "";

        if (inner.contains("/")) {
            server = inner.substring(0, inner.indexOf('/'));
            route = inner.substring(inner.indexOf('/') + 1);
        } else {
            server = inner;
        }


        System.out.printf("[protocol] = \"%s\"%n", protocol);
        System.out.printf("[server] = \"%s\"%n", server);
        System.out.printf("[resource] = \"%s\"%n", route);
    }
}