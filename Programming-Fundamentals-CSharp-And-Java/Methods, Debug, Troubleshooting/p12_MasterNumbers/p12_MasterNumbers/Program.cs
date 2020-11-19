using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p12_MasterNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            int num = int.Parse(Console.ReadLine());

            for (int i = 1; i <= num; i++)
            {
                if (HasEvenDigits(i) && isPalindrome(i) && DivisibleBy7(i))
                {
                    Console.WriteLine(i);
                }
            }
            
        }



        static bool HasEvenDigits (int num)
        {
          
            while(num > 0)
            {
                int digit = num % 10;

                if (digit % 2 == 0) return true;
                num /= 10;
            }
            return false;
        }


        static bool DivisibleBy7 (int num)
        {
            int sum = 0;
            while(num > 0)
            {
                int digit = num % 10;
                sum += digit;
                num /= 10;
            }

            if (sum % 7 == 0) return true;
            else return false;
        }


        static bool isPalindrome(int num)
        {

            int reverse = 0;
            while(num > 0)
            {
                int digit = num % 10;
                reverse = reverse * 10 + digit;
                num /= 10;
            }

            if (num == reverse) return true;
            else return false;


        }
    }
}
