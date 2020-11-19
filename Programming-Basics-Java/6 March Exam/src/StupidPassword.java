import java.util.Scanner;

public class StupidPassword {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int l = Integer.parseInt(scan.nextLine());

        for (int firstNum = 1; firstNum < n; firstNum ++){
            for (int secondNum = 1; secondNum < n; secondNum++){
                for (char firstLetter = 'a'; firstLetter < 'a' + l; firstLetter++){
                    for (char secondLetter = 'a'; secondLetter < 'a' + l; secondLetter++){
                        for (int lastNum = Math.max(firstNum, secondNum)+1; lastNum <= n; lastNum++){
                            if (lastNum > n){
                                return;
                            }
                            System.out.printf("%d%d%s%s%d ", firstNum, secondNum, firstLetter, secondLetter, lastNum );
                        }
                    }
                }
            }
        }
    }
}
