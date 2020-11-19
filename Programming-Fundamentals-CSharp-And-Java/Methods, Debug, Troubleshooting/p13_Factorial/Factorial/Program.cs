using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Numerics;

namespace Factorial
{
    class Program
    {
        static void Main(string[] args)
        {
            int num = int.Parse(Console.ReadLine());
            BigInteger factorial = 1;
            
      

            for (int i = 1; i <= num - 1; i++)
            {
                factorial = factorial * (i + 1);
         
            }
            Console.WriteLine(factorial);
        }
    }
}
