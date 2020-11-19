import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p13_SrbskoUnleashed {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        LinkedHashMap<String, LinkedHashMap<String, BigInteger>> items = new LinkedHashMap<>();

        BigInteger ticketsPrice = BigInteger.ZERO;
        BigInteger ticketsCount = BigInteger.ZERO;
        BigInteger total = BigInteger.ZERO;

        Pattern pattern = Pattern.compile("^(([A-Za-z]+ ){1,3})@(([A-Za-z]+ ){1,3})(\\d+) (\\d+)$");

        while (!"End".equals(input)) {
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()){
                String singerName = matcher.group(1).trim();
                String venue = matcher.group(3).trim();
                ticketsPrice = new BigInteger(matcher.group(5));
                ticketsCount = new BigInteger(matcher.group(6));

                total = ticketsCount.multiply(ticketsPrice);

                if (!items.containsKey(venue)) {
                    items.put(venue, new LinkedHashMap<>());
                    items.get(venue).put(singerName, total);
                } else {
                    if (!items.get(venue).containsKey(singerName)) {
                        items.get(venue).put(singerName, total);
                    } else {
                        items.get(venue).put(singerName, items.get(venue).get(singerName).add(total));
                    }
                }
            }
            input = reader.readLine();
        }

        for (String key : items.keySet()) {
            System.out.println(key);
            items.get(key).entrySet().stream().sorted(Map.Entry.<String, BigInteger>comparingByValue().reversed())
                    .forEach(x -> System.out.printf("#  %s -> %d%n", x.getKey(), x.getValue()));
        }
    }
}
