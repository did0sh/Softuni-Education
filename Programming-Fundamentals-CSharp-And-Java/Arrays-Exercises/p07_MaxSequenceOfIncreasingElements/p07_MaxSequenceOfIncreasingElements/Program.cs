using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p07_MaxSequenceOfIncreasingElements
{
    class Program
    {
        static void Main(string[] args)
        {
            long[] items = Console.ReadLine().Split(' ').Select(long.Parse).ToArray();
            long length = 1;
            long start = 0;
            long bestStart = 0;
            long bestLength = 1;
           

            for (int i = 1; i < items.Length; i++)
            {
                if (items[i] - items[i-1] >= 1)
                {
                    length++;
                    

                    if (length > bestLength)
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

            for (long j = bestStart; j < bestStart + bestLength; j++)
            {
                Console.Write(items[j]);
                Console.Write(" ");
            }
        }
    }
}
