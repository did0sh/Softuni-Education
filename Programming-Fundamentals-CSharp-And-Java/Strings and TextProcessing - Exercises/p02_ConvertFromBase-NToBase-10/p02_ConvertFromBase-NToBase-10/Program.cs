using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Numerics;

namespace p02_ConvertFromBase_NToBase_10
{
    class Program
    {
        static void Main(string[] args)
        {
            BigInteger[] nums = Console.ReadLine().Trim().Split(' ').Select(BigInteger.Parse).ToArray();

            int convertToBaseN = (int)nums[0];
            string convertNumber = nums[1].ToString();

            BigInteger result = new BigInteger(0);
            
            int index = 0;

            for (int i = convertNumber.Length - 1; i >= 0; i--)
            {
                BigInteger currentNum = BigInteger.Parse(convertNumber[i].ToString());
                result += BigInteger.Multiply(currentNum, BigInteger.Pow(new BigInteger(convertToBaseN), index));

                index++;
            }

            Console.WriteLine(result);


        }
    }
}
