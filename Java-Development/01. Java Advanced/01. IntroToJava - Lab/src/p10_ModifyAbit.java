import java.util.Scanner;

public class p10_ModifyAbit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int index = scan.nextInt();
        int value = scan.nextInt();
        
        int mask;
        int result = 0;
        mask = 1 << index;

        if (value == 1){
            result = num | mask;
        } else if (value == 0){
            result = num & ~mask;
        }

        System.out.println(result);
    }
}
