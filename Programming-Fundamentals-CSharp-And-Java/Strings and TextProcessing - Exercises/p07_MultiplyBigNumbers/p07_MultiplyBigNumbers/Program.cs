using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p07_MultiplyBigNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            string firstNum = Console.ReadLine().TrimStart('0');
            string secondNum = Console.ReadLine();

            if(secondNum == "0")
            {
                Console.WriteLine("0");
                return;
            }

            int inMind = 0;
            int remainder = 0;
            StringBuilder result = new StringBuilder();

            for (int i = firstNum.Length - 1; i >= 0; i--)
            {
                int sum = int.Parse(firstNum[i].ToString()) * int.Parse(secondNum) + inMind;
                inMind = sum / 10;
                remainder = sum % 10;
                result.Insert(0, remainder);

                if (i == 0 && inMind != 0)
                {
                    result.Insert(0, inMind);
                }
            }

            Console.WriteLine(result);
        }
    }
}
