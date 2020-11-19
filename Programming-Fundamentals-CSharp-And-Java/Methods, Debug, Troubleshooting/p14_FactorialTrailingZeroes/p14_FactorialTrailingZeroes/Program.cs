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
            int zeros = 0;
            int zeros2 = 0;
            int zeros3 = 0;
            int zeros4 = 0;




            for (int i = 1; i <= num - 1; i++)
            {
                int onePlus = i + 1;

                factorial = factorial * onePlus;

                if (onePlus < 4)
                {
                    zeros = 0;
                }
                else
                {
                    zeros = onePlus / (int)Math.Pow(5, 1);
                    zeros2 = onePlus / (int)Math.Pow(5, 2);
                    zeros3 = onePlus / (int)Math.Pow(5, 3);
                    zeros4 = onePlus / (int)Math.Pow(5, 4);
                }


            }
            Console.WriteLine(zeros + zeros2 + zeros3 + zeros4);
        }
    }
}
