using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p06_SumReversedNums
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> numbers = Console.ReadLine().Split(' ').Select(int.Parse).ToList();
            int sum = 0;

            for (int i = 0; i < numbers.Count; i++)
            {
                int reversed = 0;
                while(numbers[i] > 0)
                {
                    int lastDigit = numbers[i] % 10;
                    reversed = reversed*10 + lastDigit;
                    numbers[i] = numbers[i] / 10;
                }
                sum += reversed;
            }

            Console.WriteLine(sum);
        }
    }
}
