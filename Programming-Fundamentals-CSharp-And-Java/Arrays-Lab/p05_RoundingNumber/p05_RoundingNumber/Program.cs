using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p05_RoundingNumber
{
    class Program
    {
        static void Main(string[] args)
        {
            double[] numbers = Console.ReadLine().Split(' ').Select(double.Parse).ToArray();

            for (int i = 0; i < numbers.Length; i++)
            {
                double rounded = Math.Round(numbers[i], 0, MidpointRounding.AwayFromZero);
                Console.WriteLine("{0} => {1}", numbers[i], rounded);
            }

        }
    }
}
