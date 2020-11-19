using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p10_ParisByDifference
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] items = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();

            int difference = int.Parse(Console.ReadLine());
            int counter = 0;

            for (int i = 0; i < items.Length; i++)
            {
                int currentNum = items[i];

                for (int j = i; j < items.Length - 1; j++)
                {
                    if(Math.Abs(currentNum -items[j+1]) == difference)
                    {
                        counter++;
                    }
                }
            }

            Console.WriteLine(counter);
        }
    }
}
