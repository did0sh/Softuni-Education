using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p08_CondenseArrayToNumber
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] items = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();

            int[] condensed = new int[items.Length - 1];


            if (items.Length == 1)
            {
                Console.WriteLine(items[0]);
                return;
            }


            for (int i = 0; i < items.Length; i++)
            {
                for (int j = 0; j < condensed.Length - i; j++)
                {
                    condensed[j] = items[j] + items[j + 1];
                }
                items = condensed;
            }



            Console.WriteLine(condensed[0]);


        }
    }
}
