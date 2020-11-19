import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p02_SoftuniParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeSet<String> regularGuests = new TreeSet<>();
        HashSet<String> vipGuests = new HashSet<>();
        List<String> nums = Arrays.asList("0","1", "2", "3", "4", "5", "6", "7", "8", "9");

        while (true){
            String input = reader.readLine();
            if (input.length() > 8){
                continue;
            }
            if (input.equals("PARTY")){
                break;
            } else {
                String sign = Character.toString(input.charAt(0));
                if (nums.contains(sign)){
                    vipGuests.add(input);
                } else {
                    regularGuests.add(input);
                }
            }
        }

        while (true){
            String input = reader.readLine();
            if (input.equals("END")){
                break;
            } else {
                if (vipGuests.contains(input)){
                    vipGuests.remove(input);
                } else if (regularGuests.contains(input)){
                    regularGuests.remove(input);
                }
            }
        }

        regularGuests.addAll(vipGuests);
        System.out.println(regularGuests.size());

        for (String guest:regularGuests) {
            System.out.println(guest);
        }
    }
}
