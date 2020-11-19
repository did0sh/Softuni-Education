using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p09_LegendaryFarming
{
    class Program
    {
        static void Main(string[] args)
        {
            var material = new Dictionary<string, int>();
            var junk = new SortedDictionary<string, int>();

            material.Add("shards", 0);
            material.Add("fragments", 0);
            material.Add("motes", 0);

            bool getMoreMaterial = true;

            while (getMoreMaterial)
            {
                string[] input = Console.ReadLine().ToLower().Split(' ');

                for (int i = 0; i < input.Length; i+=2)
                {
                    int quantity = int.Parse(input[i]);
                    string text = input[i + 1];

                    if(text == "shards" || text == "fragments" || text == "motes") // if(material.ContainsKey(text))
                    {
                        material[text] += quantity;

                        if(material[text] >= 250)
                        {
                            material[text] = material[text] - 250;
                           
                            switch (text)
                            {
                                case "shards":
                                    Console.WriteLine("Shadowmourne obtained!"); break;
                                case "fragments":
                                    Console.WriteLine("Valanyr obtained!"); break;
                                case "motes":
                                    Console.WriteLine("Dragonwrath obtained!"); break;
                            }

                            getMoreMaterial = false;
                            break;
                            
                        }
                    }
                    else
                    {
                        if (!junk.ContainsKey(text))
                        {
                            junk.Add(text, quantity);
                        }
                        else
                        {
                            junk[text] += quantity;
                        }
                    }
                    
                }
            }

            foreach (var item in material.OrderByDescending(x => x.Value).ThenBy(x => x.Key))
            {
                Console.WriteLine($"{item.Key}: {item.Value}");
            }

            foreach (var element in junk)
            {
                Console.WriteLine($"{element.Key}: {element.Value}");
            }

        }
    }
}
