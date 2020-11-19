using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p07_PopulationCounter
{
    class Program
    {
        static void Main(string[] args)
        {
            var items = new Dictionary<string, Dictionary<string, long>>();

            string input = Console.ReadLine();

            while(input != "report")
            {
                string[] token = input.Split('|');

                string city = token[0];
                string country = token[1];
                long population = long.Parse(token[2]);

                if (!items.ContainsKey(country))
                {
                    items.Add(country, new Dictionary<string, long>());
                }

                if (!items[country].ContainsKey(city))
                {
                    items[country].Add(city, population);
                }

                input = Console.ReadLine();
            }

            foreach (var country in items.OrderByDescending(x => x.Value.Values.Sum()))
            {
                Console.WriteLine($"{country.Key} (total population: {country.Value.Values.Sum()})");
                foreach (var city in country.Value.OrderByDescending(c => c.Value))
                {
                    Console.WriteLine($"=>{city.Key}: {city.Value}");
                }
            }
        }
    }
}
