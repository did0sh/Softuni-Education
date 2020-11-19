import java.util.Scanner;

public class p04_VowelOrDigit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        boolean isDigit = false;
        boolean isVowel = false;

        String input = scan.nextLine();

        if(input.equals("a") || input.equals("e") || input.equals("i") || input.equals("o") || input.equals("u")){
            isVowel = true;
        }

        try {
            int digit = Integer.parseInt(input);
            isDigit = true;
        } catch (NumberFormatException ex){
            isDigit = false;
        }

        if (isVowel){
            System.out.println("vowel");
        } else if(isDigit){
            System.out.println("digit");
        } else {
            System.out.println("other");
        }
    }
}
