import java.util.Scanner;

/**
 * Created by user on 5.10.2017 г..
 */
public class p12_MasterNumbers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= num; i++)
        {
            if (hasEvenDigits(i) && isPalindrome(i) && divisibleBy7(i))
            {
                System.out.println(i);
            }
        }

    }



    static boolean hasEvenDigits (int num)
    {

        while(num > 0)
        {
            int digit = num % 10;

            if (digit % 2 == 0){
                return true;
            }
            num /= 10;
        }
        return false;
    }


    static boolean divisibleBy7 (int num)
    {
        int sum = 0;
        while(num > 0)
        {
            int digit = num % 10;
            sum += digit;
            num /= 10;
        }

        if (sum % 7 == 0){
            return true;
        }
        else return false;
    }


    static boolean isPalindrome(int num)
    {

        int startNum = num;
        int reverse = 0;
        while(num > 0)
        {
            int digit = num % 10;
            reverse = reverse * 10 + digit;
            num /= 10;
        }

        if (startNum == reverse){
            return true;
        } else {
            return false;
        }


    }
}

