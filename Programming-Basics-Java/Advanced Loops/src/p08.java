import java.util.Scanner;

public class p08 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());
        int factoriel = 1;

        while (num>0){
            factoriel = factoriel * num;
            num--;
        }
        System.out.println(factoriel);
    }
}
