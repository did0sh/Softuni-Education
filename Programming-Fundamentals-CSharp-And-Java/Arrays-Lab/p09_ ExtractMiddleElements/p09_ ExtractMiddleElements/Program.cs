using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p09__ExtractMiddleElements
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] items = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();


            if (items.Length == 1)
            {
                Console.WriteLine("{ " + items[0] + " }");

            }
            else if (items.Length % 2 == 0)
            {
                Console.WriteLine("{ " + $"{items[items.Length / 2 - 1]}, {items[items.Length / 2]}" + " }");

            }
            else if (items.Length % 2 == 1)
            {
                Console.WriteLine("{ " + $"{items[items.Length / 2 - 1]}, {items[items.Length / 2]}, {items[items.Length/2 + 1]}" + " }");
            
            }
        }
    }
}
