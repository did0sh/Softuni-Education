using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p06_SquareNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            List<double> numbers = Console.ReadLine().Split(' ').Select(double.Parse).ToList();
            List<int> squareNums = new List<int>();

            for (int i = 0; i < numbers.Count; i++)
            {
                if(Math.Sqrt(numbers[i]) == (int)Math.Sqrt(numbers[i]))
                {
                    squareNums.Add((int)numbers[i]);
                }
            }

            squareNums.Sort();

            for (int i = squareNums.Count - 1; i >= 0; i--)
            {
                Console.Write(squareNums[i]);
                Console.Write(" ");
            }

           
        }
    }
}
