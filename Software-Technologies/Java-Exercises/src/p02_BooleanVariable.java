import java.util.Scanner;

public class p02_BooleanVariable{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String variable = scan.nextLine();

        Boolean bool = Boolean.valueOf(variable);

        if (bool){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
