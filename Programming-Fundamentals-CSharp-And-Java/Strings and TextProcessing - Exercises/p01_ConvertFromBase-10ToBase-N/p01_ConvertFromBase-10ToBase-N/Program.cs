using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Numerics;

namespace p01_ConvertFromBase_10ToBase_N
{
    class Program
    {
        static void Main(string[] args)
        {
            BigInteger[] numbers = Console.ReadLine().Trim().Split(' ').Select(BigInteger.Parse).ToArray();

            BigInteger baseN = numbers[0];
            BigInteger baseTenNumber = numbers[1];

            StringBuilder results = new StringBuilder();
            List<string> reversed = new List<string>();

            while(baseTenNumber > 0)
            {
                BigInteger result = baseTenNumber % baseN;
                results.Append(result);
                baseTenNumber = baseTenNumber / baseN;
            }

            for (int i = results.Length - 1; i >= 0; i--)
            {
                reversed.Add(results[i].ToString());
            }

            Console.WriteLine(string.Join("", reversed));
        }
    }
}
