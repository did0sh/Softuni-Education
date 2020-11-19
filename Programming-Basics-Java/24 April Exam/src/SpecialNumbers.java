import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int specialNum = Integer.parseInt(scan.nextLine());

        for (int firstNum = 1; firstNum <= 9 ; firstNum++) {
            for (int secondNum = 1; secondNum <= 9 ; secondNum++) {
                for (int thirdNum = 1; thirdNum <= 9 ; thirdNum++) {
                    for (int fourthNum = 1; fourthNum <= 9 ; fourthNum++) {
                        if (specialNum % firstNum == 0 &&
                                specialNum % secondNum == 0 &&
                                specialNum % thirdNum == 0 &&
                                specialNum % fourthNum == 0){

                            System.out.printf("%d%d%d%d ", firstNum, secondNum, thirdNum, fourthNum);
                        }
                    }
                }
            }
        }
    }
}
