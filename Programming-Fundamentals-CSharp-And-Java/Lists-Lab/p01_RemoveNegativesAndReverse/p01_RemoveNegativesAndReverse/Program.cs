using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p01_RemoveNegativesAndReverse
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> items = Console.ReadLine().Split(' ').Select(int.Parse).ToList();

            List<int> results = new List<int>();


            for (int i = 0; i < items.Count; i++)
            {
                if(items[i] > 0)
                
                {
                    results.Add(items[i]);
                    
                }
            }

            if (results.Count > 0)
            {
                results.Reverse();
                Console.WriteLine(string.Join(" ", results));
            }
            else
            {
                Console.WriteLine("empty");
            }


        }
    }
}
