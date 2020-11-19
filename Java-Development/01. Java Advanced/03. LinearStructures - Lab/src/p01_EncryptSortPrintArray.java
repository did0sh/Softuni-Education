import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class p01_EncryptSortPrintArray {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] allSums = new int[n];

        allSums = calculateAndAddSum(allSums, reader, n);
        Arrays.sort(allSums);

        for (int currSum: allSums) {
            System.out.println(currSum);
        }
    }

    private static int[] calculateAndAddSum(int[] allSums, BufferedReader reader, int n) throws IOException {

        ArrayList<Character> vowels = new ArrayList<>();
        Collections.addAll(vowels, 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        for (int i = 0; i < n; i++) {
            int sum = 0;
            char[] charactersOfName = reader.readLine().toCharArray();
            for (char ch:charactersOfName) {
                if(vowels.contains(ch)){
                    sum += (int)ch * charactersOfName.length;
                } else {
                    sum += (int)ch / charactersOfName.length;
                }
            }
            allSums[i] = sum;
        }
        return allSums;
    }
}
