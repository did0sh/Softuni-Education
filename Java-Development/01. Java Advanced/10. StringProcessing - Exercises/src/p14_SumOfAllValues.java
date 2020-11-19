import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.text.DecimalFormat;
        import java.util.ArrayList;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class p14_SumOfAllValues {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        String startKey = getStartKey(input).toString();
        String endKey = getEndKey(input).toString();


        if (startKey.equals("") || endKey.equals("") || startKey.contains("*") || endKey.contains("*")) {
            System.out.println("<p>A key is missing</p>");
            return;
        }

        String line = reader.readLine();
        Pattern pattern = Pattern.compile(startKey + "([0-9.]+?)" + endKey);
        Matcher matcher2 = pattern.matcher(line);
        ArrayList<Double> nums = new ArrayList<>();

        int count = 0;
        while (matcher2.find()) {
            count++;
            double num = Double.parseDouble(matcher2.group(1));
            nums.add(num);
        }


        DecimalFormat df = new DecimalFormat("#.##");
        double sum = 0;
        for (Double num : nums) {
            sum += num;
        }

        if (sum == 0) {
            System.out.printf("<p>The total value is: <em>nothing</em></p>");
        } else {
            System.out.printf("<p>The total value is: <em>%s</em></p>", df.format(sum));
        }
    }

    private static StringBuilder getEndKey(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = input.length() - 1; i >= 0 ; i--) {
            if (!Character.isDigit(input.charAt(i))){
                sb.append(input.charAt(i));
            } else {
                break;
            }
        }
        return sb.reverse();
    }

    private static StringBuilder getStartKey(String input) {
        StringBuilder startKey = new StringBuilder();
        for (int i = 0; i < input.length() ; i++) {
            if (!Character.isDigit(input.charAt(i))){
                startKey.append(input.charAt(i));
            } else {
                break;
            }
        }
        return startKey;
    }
}
