using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p06_MaxSequenceEqualElements
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] items = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
            int length = 1;
            int start = 0;
            int bestStart = 0;
            int bestLength = 1;

            for (int i = 1; i < items.Length; i++)
            {
                if(items[i] == items[start])
                {
                    length++;
                    if(length > bestLength)
                    {
                        bestLength = length;
                        bestStart = start;
                    }
                    
                }
                else
                {
                    length = 1;
                    start = i;
                }

            }

            for (int j = bestStart; j < bestStart + bestLength; j++)
            {
                Console.Write(items[j]);
                Console.Write(" ");
            }
        }
    }
}
