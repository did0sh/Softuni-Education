import java.util.Scanner;

/**
 * Created by user on 21.9.2017 г..
 */
public class p05_ForeignLanguages {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String country = scan.nextLine();

        switch (country){
            case "England":
            case "USA":
                System.out.println("English"); break;
            case "Spain":
            case "Argentina":
            case "Mexico":
                System.out.println("Spanish"); break;
            default:
                System.out.println("unknown"); break;
        }
    }
}
