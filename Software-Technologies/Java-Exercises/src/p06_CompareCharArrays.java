import java.util.ArrayList;
import java.util.Scanner;

public class p06_CompareCharArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] firstInputCharacters = scan.nextLine().split(" ");
        String[] secondInputCharacters = scan.nextLine().split(" ");

        boolean areEqual = false;
        boolean firstIsBigger = false;
        boolean secondIsBigger = false;

        int length = Math.min(firstInputCharacters.length, secondInputCharacters.length);

        for (int i = 0; i < length ; i++) {
            if (firstInputCharacters[i].charAt(0) == (secondInputCharacters[i].charAt(0))){
                areEqual = true;
            } else if (firstInputCharacters[i].charAt(0) < secondInputCharacters[i].charAt(0)){
                firstIsBigger = true;
                areEqual = false;
                break;
            } else {
                secondIsBigger = true;
                areEqual = false;
                break;
            }
        }

        if (areEqual && firstInputCharacters.length == secondInputCharacters.length){
            System.out.println(String.join("", firstInputCharacters));
            System.out.println(String.join("", secondInputCharacters));

        } else if (areEqual && firstInputCharacters.length < secondInputCharacters.length) {
            System.out.println(String.join("", firstInputCharacters));
            System.out.println(String.join("", secondInputCharacters));

        } else if(areEqual && secondInputCharacters.length < firstInputCharacters.length) {
            System.out.println(String.join("", secondInputCharacters));
            System.out.println(String.join("", firstInputCharacters));

        } else {
            if (firstIsBigger){
                System.out.println(String.join("", firstInputCharacters));
                System.out.println(String.join("", secondInputCharacters));
            } else if (secondIsBigger){
                System.out.println(String.join("", secondInputCharacters));
                System.out.println(String.join("", firstInputCharacters));
            }
        }

    }
}
