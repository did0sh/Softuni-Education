import java.util.Scanner;

public class VowelsSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String text = scan.nextLine();
        int sumVowels = 0;

        for (int i = 0; i < text.length() ; i++) {
            char letters = text.charAt(i);

            switch (letters){
                case 'a': sumVowels += 1; break;
                case 'e': sumVowels += 2; break;
                case 'i': sumVowels += 3; break;
                case 'o': sumVowels += 4; break;
                case 'u': sumVowels += 5; break;
            }
        }
        System.out.println(sumVowels);
    }
}
