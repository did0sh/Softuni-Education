import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.Arrays;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;
        import java.util.stream.Collector;
        import java.util.stream.Collectors;

public class problem03 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Long> items = new HashMap<>();
        String input = reader.readLine();

        Pattern pattern = Pattern.compile("^([!@?#$a-z]+)=(\\d+)--(\\d+)<<([a-z]+)$");


        StringBuilder sb = new StringBuilder();
        while (!"Stop!".equalsIgnoreCase(input)) {
            Matcher matcher = pattern.matcher(input);
           sb.setLength(0);

                while (matcher.find()){
                    List<String> words = Arrays.stream(matcher.group(1).split("[!@?#$]", -1))
                            .filter(x -> !x.isEmpty()).collect(Collectors.toList());
                    for (String word : words) {
                        sb.append(word);
                    }
                    int num = Integer.parseInt(matcher.group(2));
                    if (sb.length() == num){
                        String groupName = matcher.group(4);
                        long genes = Long.parseLong(matcher.group(3));
                        if (items.containsKey(groupName)){
                            items.put(groupName, items.get(groupName) + genes);
                        } else {
                            items.put(groupName, genes);
                        }
                    }
                }

            input = reader.readLine();
        }

        items.entrySet().stream().sorted((kv1, kv2) -> kv2.getValue().compareTo(kv1.getValue()))
                .forEach(kv -> System.out.printf("%s has genome size of %d%n", kv.getKey(), kv.getValue()));
    }
}
