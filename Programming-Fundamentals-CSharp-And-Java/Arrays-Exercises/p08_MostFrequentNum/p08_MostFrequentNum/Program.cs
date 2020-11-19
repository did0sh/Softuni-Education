using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p08_MostFrequentNumber
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] items = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
            int repetitions = 0;
            int mostFrequenNumber = 0;

            for (int i = 0; i < items.Length; i++)
            {
                int currentNum = items[i];
                int counter = 0;
                for (int j = i; j < items.Length; j++)
                {
                    if (currentNum == items[j])
                    {
                        counter++;
                    }
                }

                if (counter > repetitions)
                {
                    mostFrequenNumber = currentNum;
                    repetitions = counter;
                }
            }

            Console.WriteLine(mostFrequenNumber);



        }
    }
}
