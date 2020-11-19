using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p02_OddOccurrences
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] input = Console.ReadLine().ToLower().Split(' ');

            Dictionary<string, int> count = new Dictionary<string, int>();

            foreach (var item in input)
            {
                if (count.ContainsKey(item))
                {
                    count[item]++;
                }
                else
                {
                    count[item] = 1;
                }
            }

            List<string> results = new List<string>();
            

            foreach (var element in count)
            {
                if(element.Value % 2 != 0)
                {
                    results.Add(element.Key);
                }
            }

            Console.WriteLine(string.Join(", ", results));
        }
    }
}
