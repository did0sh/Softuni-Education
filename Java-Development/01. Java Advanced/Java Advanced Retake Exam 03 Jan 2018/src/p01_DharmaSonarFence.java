import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class p01_DharmaSonarFence {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder results = new StringBuilder();
        String input = reader.readLine();
        BigInteger value = new BigInteger("0");
        StringBuilder sb = new StringBuilder();
        while (!"reprogram".equalsIgnoreCase(input)){
            String toBinary = String.format("%32s",Long.toBinaryString(Long.parseLong(input))).replace(" ", "0");
            String third = null;
            sb.setLength(0);
            for (int i = 0; i < toBinary.length(); i+= 2) {
                try{
                    String first = String.valueOf(toBinary.charAt(i));
                    String second = String.valueOf(toBinary.charAt(i+1));
                    if (i+2 < toBinary.length()) {
                        third = String.valueOf(toBinary.charAt(i + 2));
                    }
                    if (first.equals("0") && second.equals("0")){
                        sb.append("11");
                    } else if (first.equals("1") && second.equals("1")){
                        sb.append("00");
                    } else if (second.equals(third) && !first.equals(second)){
                        sb.append(first);
                        i--;
                    } else {
                        sb.append(first).append(second);
                    }
                }catch (Exception ex){
                    sb.append(toBinary.charAt(i));
                }

            }

            value = BigInteger.valueOf(Long.parseLong(sb.toString(),2));
            results.append(value).append(System.lineSeparator());

            input = reader.readLine();
        }

        System.out.println(results.toString());
    }
}
