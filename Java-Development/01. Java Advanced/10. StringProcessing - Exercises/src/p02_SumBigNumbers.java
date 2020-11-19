import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class p02_SumBigNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstNum = reader.readLine();
        String secondNum = reader.readLine();

        firstNum = trimZeroes(firstNum);
        secondNum = trimZeroes(secondNum);

        if (firstNum.length() > secondNum.length()){
            secondNum = String.join("", Collections.nCopies(firstNum.length() - secondNum.length(), "0")) + secondNum;
        } else {
            firstNum = String.join("", Collections.nCopies(secondNum.length() - firstNum.length(), "0")) + firstNum;
        }

        byte numberInMind = 0;
        byte remainder = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = firstNum.length() - 1; i >= 0  ; i--) {
            byte sum = (byte) (Character.getNumericValue(firstNum.charAt(i)) + Character.getNumericValue(secondNum.charAt(i)) + numberInMind);

            numberInMind = (byte)(sum / 10);
            remainder = (byte)(sum % 10);
            sb.append(remainder);

            if (i == 0 && numberInMind != 0){
                sb.append(numberInMind);
            }
        }
        System.out.println(sb.reverse().toString());
    }
    private static String trimZeroes(String input){
        int start = 0;
        while (input.charAt(start) == '0'){
            start++;
        }
        return input.substring(start);
    }
}
