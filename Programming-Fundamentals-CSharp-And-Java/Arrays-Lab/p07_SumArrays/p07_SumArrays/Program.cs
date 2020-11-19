using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p07_SumArrays
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] firstItems = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();

            int[] secondItems = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();

            int length1 = firstItems.Length;
            int length2 = secondItems.Length;

            int result = Math.Max(length1, length2);
            int sum = 0;

            for (int i = 0; i < result; i++)
            {
                sum = firstItems[i%length1] + secondItems[i%length2];
                Console.Write(sum);
                Console.Write(" ");
            }
        }
    }
}
