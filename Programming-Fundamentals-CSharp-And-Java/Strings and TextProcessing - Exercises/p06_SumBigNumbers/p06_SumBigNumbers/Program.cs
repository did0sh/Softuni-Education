using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p06_SumBigNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            string firstNum = Console.ReadLine().TrimStart('0');
            string secondNum = Console.ReadLine().TrimStart('0');

            int maxLength = Math.Max(firstNum.Length, secondNum.Length);

            if(firstNum.Length != secondNum.Length)
            {
                firstNum = firstNum.PadLeft(maxLength, '0');
                secondNum = secondNum.PadLeft(maxLength, '0');
            }

            int inMind = 0;
            int remainder = 0;
            StringBuilder result = new StringBuilder();

            for (int i = firstNum.Length - 1; i >= 0; i--)
            {
                int sum = int.Parse(firstNum[i].ToString()) + int.Parse(secondNum[i].ToString()) + inMind;
                inMind = sum / 10;
                remainder = sum % 10;
                result.Insert(0, remainder);

                if(i == 0 && inMind != 0)
                {
                    result.Insert(0, inMind);
                }
            }

            Console.WriteLine(result);
        }
    }
}
