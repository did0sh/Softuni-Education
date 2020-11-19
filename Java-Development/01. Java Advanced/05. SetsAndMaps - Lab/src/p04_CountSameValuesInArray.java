import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class p04_CountSameValuesInArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashMap<String, Integer> hashMap = new HashMap<>();
       String[] components = scan.nextLine().split("\\s+");

        for (String num:components) {
            if (!hashMap.containsKey(num)){
                hashMap.put(num, 1);
            } else {
                hashMap.put(num, hashMap.get(num) + 1);
            }
        }

        for (String key:hashMap.keySet()) {
            System.out.printf("%s - %d times%n", key, hashMap.get(key));
        }
    }
}
