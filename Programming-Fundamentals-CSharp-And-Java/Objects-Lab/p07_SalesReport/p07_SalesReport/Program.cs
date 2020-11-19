using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p07_SalesReport
{
    class Program
    {
        static void Main(string[] args)
        {
            var items = new SortedDictionary<string, decimal>();

            int n = int.Parse(Console.ReadLine());

            for (int i = 0; i < n; i++)
            {
                string input = Console.ReadLine();
                string[] tokens = input.Split(' ');

                string townName = tokens[0];
                decimal price = decimal.Parse(tokens[2]);
                decimal quantity = decimal.Parse(tokens[3]);
                decimal total = price * quantity;

                if (!items.ContainsKey(townName))
                {
                    items.Add(townName, total);
                }
                else
                {
                    items[townName] += total;
                }

            }

            foreach (var town in items)
            {
                Console.WriteLine("{0} -> {1:F2}", town.Key, town.Value);
            }
        }
    }
}
