using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p04_NSA
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            Dictionary<string, Dictionary<string, int>> items = new Dictionary<string, Dictionary<string, int>>();

            while(input != "quit")
            {
                string[] tokens = input.Trim().Split(new string[] { " -> " }, StringSplitOptions.RemoveEmptyEntries);
                string country = tokens[0];
                string spyName = tokens[1];
                int daysInService = int.Parse(tokens[2]);

                if (!items.ContainsKey(country))
                {
                    items.Add(country, new Dictionary<string, int>());
                    items[country].Add(spyName, daysInService);
                }
                else
                {
                    if (!items[country].ContainsKey(spyName))
                    {
                        items[country].Add(spyName, daysInService);
                    }
                    else
                    {
                        items[country][spyName] = daysInService;
                    }
                }
                input = Console.ReadLine();
            }

            foreach (var item in items.OrderByDescending(x => x.Value.Keys.Count()))
            {
                Console.WriteLine("Country: {0}", item.Key);
                foreach (var element in item.Value.OrderByDescending(x => x.Value))
                {
                    Console.WriteLine($"**{element.Key} : {element.Value}");
                }
            
            }
        }
    }
}
