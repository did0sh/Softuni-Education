import java.util.Scanner;

public class p07_CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.next();
        String str2 = scan.next();

        int minLength;
        long sum = 0;
        
        if (str1.length() > str2.length()){
            minLength = str2.length();
            for (int i = 0; i < minLength; i++) {
                sum += (int)str1.charAt(i) * (int)str2.charAt(i);
            }
            for (int k = minLength; k < str1.length(); k++) {
                sum += (int)str1.charAt(k);
            }
        } else if (str2.length() > str1.length()){
            minLength = str1.length();
            for (int i = 0; i < minLength; i++) {
                sum += (int)str1.charAt(i) * (int)str2.charAt(i);
            }
            for (int k = minLength; k < str2.length(); k++) {
                sum += (int)str2.charAt(k);
            }
        } else {
            for (int i = 0; i < str1.length(); i++) {
                sum += (int)str1.charAt(i) * (int)str2.charAt(i);
            }
        }
        System.out.println(sum);;
    }
}
