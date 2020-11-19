using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p03_SearchForNumber
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> numbers = Console.ReadLine().Split(' ').Select(int.Parse).ToList();

            List<int> numbersForOperations = Console.ReadLine().Split(' ').Select(int.Parse).ToList();

            List<int> results = new List<int>();


            for (int i = 0; i < numbersForOperations[0]; i++)
            {
                results.Add(numbers[i]);
            }

            for (int j = 0; j < numbersForOperations[1]; j++)
            {
                results.RemoveAt(0);
            }

            if(results.Contains(numbersForOperations[2]))
            {
                Console.WriteLine("YES!");
            }
            else
            {
                Console.WriteLine("NO!");
            }

        }
    }
}
