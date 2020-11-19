using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p04_CodePhoenix
{
    class Program
    {
        static void Main(string[] args)
        {
            var items = new Dictionary<string, List<string>>();

            string input = Console.ReadLine();
            while(input != "Blaze it!")
            {
                string[] tokens = input.Split(new string[] { " -> " }, StringSplitOptions.RemoveEmptyEntries);
                string creature = tokens[0];
                string squadMate = tokens[1];

                if (!items.ContainsKey(creature))
                {
                    items.Add(creature, new List<string>());
                }

                if(creature != squadMate)
                {
                    if (!items[creature].Contains(squadMate))
                    {
                        items[creature].Add(squadMate);
                    }
                   
                }
                input = Console.ReadLine();
            }

            var result = new Dictionary<string, List<string>>();

            foreach (var item in items)
            {
                result.Add(item.Key, new List<string>());
                foreach (var mate in item.Value)
                {
                    if(items.ContainsKey(mate) && items[mate].Contains(item.Key))
                    {
                        continue;
                    }
                    else
                    {
                        result[item.Key].Add(mate);
                    }
                    
                }
            }

            foreach (var element in result.OrderByDescending(x => x.Value.Count))
            {
                Console.WriteLine($"{element.Key} : {element.Value.Count}");
            }
        }
    }
}
