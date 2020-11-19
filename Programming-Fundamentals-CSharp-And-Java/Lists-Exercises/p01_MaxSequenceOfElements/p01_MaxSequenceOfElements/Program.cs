using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p01_MaxSequenceOfEqualElements
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> numbers = Console.ReadLine().Split(' ').Select(int.Parse).ToList();

            int length = 1;
            int start = 0;
            int bestStart = 0;
            int bestLength = 1;

            int maxSequenceNum = 0;

            bool found = false;




            for (int j = 1; j < numbers.Count; j++)
            {

                int currentNum = numbers[j - 1];
                if (currentNum == numbers[j])
                {
                    length++;
                    found = true;

                    if (length > bestLength)
                    {
                        maxSequenceNum = currentNum;
                        bestStart = start;
                        bestLength = length;
                    }

                }
                else
                {

                    length = 1;
                    start = j;

                }
            }


            if (!found)
            {
                Console.WriteLine(numbers[0]);
            }
            else
            {
                for (int k = bestStart; k < bestStart + bestLength; k++)
                {
                    Console.Write(numbers[k]);
                    Console.Write(" ");
                }
            }

        }
    }
}
