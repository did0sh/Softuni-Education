using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p11_EqualSums
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] items = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();

            int sumLeft = 0;
            int sumRight = 0;

            for (int i = 0; i < items.Length; i++)
            {
                if(items.Length == 1)
                {
                    Console.WriteLine(0);
                    return;
                }

                sumLeft = 0;

                for (int left = i; left > 0; left--)
                {
                    int positionsBefore = left - 1;

                    if(left > 0)
                    {
                        sumLeft += items[positionsBefore];
                    }
                }

                sumRight = 0;

                for (int right = i; right < items.Length - 1; right++)
                {
                    int positionsAfter = right + 1;

                    if(right < items.Length - 1)
                    {
                        sumRight += items[positionsAfter];
                    }
                }

                if(sumLeft == sumRight)
                {
                    Console.WriteLine(i);
                    return;
                }
            }

            Console.WriteLine("no");
        }
    }
}
