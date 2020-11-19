import java.util.Scanner;

public class p11_GameOfNames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int maxValue = Integer.MIN_VALUE;
        String winner = null;

        for (int i = 0; i < n; i++) {
            String name = scan.nextLine();
            int points = Integer.parseInt(scan.nextLine());

            char[] letters = name.toCharArray();
            int scoreManipulate = points;

            for (char letter:
                    letters) {
                if ((int) letter % 2 == 0){
                    scoreManipulate += (int) letter;
                } else {
                    scoreManipulate -= (int) letter;
                }
            }

            if (scoreManipulate > maxValue){
                maxValue = scoreManipulate;
                winner = name;
            }
        }
        System.out.printf("The winner is %s - %d points", winner, maxValue);
    }
}
