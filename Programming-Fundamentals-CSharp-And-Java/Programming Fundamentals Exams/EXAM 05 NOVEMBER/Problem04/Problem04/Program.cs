using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem04
{
    class Program
    {
        static void Main(string[] args)
        {
            var items = new Dictionary<string, Dictionary<string, long>>();
            var cache = new Dictionary<string, Dictionary<string, long>>();

            string input = Console.ReadLine();

            while(input != "thetinggoesskrra")
            {
                string[] tokens = input.Split(new string[] { " -> ", " | " }, StringSplitOptions.RemoveEmptyEntries);

                if(tokens.Length == 1)
                {
                    string dataSet = tokens[0];
                    if (!items.ContainsKey(dataSet))
                    {
                        items.Add(dataSet, new Dictionary<string, long>());
                    }

                    if (cache.ContainsKey(dataSet))
                    {
                        items[dataSet] = cache[dataSet]; 
                    }
                }
                else
                {
                    string dataKey = tokens[0];
                    int dataSize = int.Parse(tokens[1]);
                    string dataSet = tokens[2];

                    if (items.ContainsKey(dataSet))
                    {
                        items[dataSet].Add(dataKey, dataSize);
                    }
                    else
                    {
                        if (!cache.ContainsKey(dataSet))
                        {
                            cache.Add(dataSet, new Dictionary<string, long>());
                            cache[dataSet].Add(dataKey, dataSize);
                        }
                        else
                        {
                            cache[dataSet].Add(dataKey, dataSize);
                        }
                    }
                }


                input = Console.ReadLine();
            }

            foreach (var item in items.OrderByDescending(x => x.Value.Values.Sum()).Take(1))
            {
                Console.WriteLine($"Data Set: {item.Key}, Total Size: {item.Value.Values.Sum()}");
                foreach (var element in item.Value)
                {
                    Console.WriteLine($"$.{element.Key}");
                }
            }
        }
    }
}
