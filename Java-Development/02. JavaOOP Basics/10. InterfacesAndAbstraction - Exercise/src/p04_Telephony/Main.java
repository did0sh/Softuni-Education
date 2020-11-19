package p04_Telephony;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String pattern = "[0-9]+";
        String patternWebsites = ".*\\d+.*";

        String[] numbers = scan.nextLine().split("\\s+");
        String[] webSites = scan.nextLine().split("\\s+");

        SmartPhone smartPhone = new SmartPhone();

        printNumbers(smartPhone, numbers, pattern);
        printWebsites(smartPhone, webSites, patternWebsites);
    }

    private static void printNumbers(SmartPhone smartPhone, String[] numbers, String pattern){
        StringBuilder sb = new StringBuilder();
        for (String number : numbers) {
            if (!number.matches(pattern)){
                sb.append("Invalid number!").append(System.lineSeparator());
            } else {
                sb.append(smartPhone.call()).append(number).append(System.lineSeparator());
            }
        }

        System.out.print(sb);
    }

    private static void printWebsites(SmartPhone smartPhone,String[] webSites, String pattern){
        StringBuilder sb = new StringBuilder();
        for (String webSite : webSites) {
            if (webSite.matches(pattern)){
                sb.append("Invalid URL!").append(System.lineSeparator());
            } else {
                sb.append(smartPhone.browse()).append(webSite).append("!").append(System.lineSeparator());
            }
        }
        System.out.print(sb);
    }
}
