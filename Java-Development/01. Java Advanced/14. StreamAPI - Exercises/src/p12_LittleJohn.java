import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p12_LittleJohn {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("(>-{5}>)|(>>-{5}>)|(>>>-{5}>>)");
        int countSmall = 0;
        int countMedium = 0;
        int countBig = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            String input = reader.readLine();
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()){
                if (matcher.group(1) != null){
                    countSmall++;
                } else if (matcher.group(2) != null){
                    countMedium++;
                } else if (matcher.group(3) != null){
                    countBig++;
                }
            }
        }

        StringBuilder reversed = new StringBuilder();
        sb.append(countSmall).append(countMedium).append(countBig);
        String toBinary = Integer.toBinaryString(Integer.parseInt(sb.toString()));
        sb.setLength(0);

        reversed.append(toBinary).reverse();

        sb.append(toBinary).append(reversed);
        int finalNum = Integer.parseInt(sb.toString(),2);

        System.out.println(finalNum);

    }
}
