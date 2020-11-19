using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p04_PokemonEvolution
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            Dictionary<string, List<TypeAndIndex>> items = new Dictionary<string, List<TypeAndIndex>>();

            while (input != "wubbalubbadubdub")
            {
                string[] tokens = input.Trim().Split(new string[] { " -> " }, StringSplitOptions.RemoveEmptyEntries);

                if (tokens.Length == 1)
                {
                    string pokemonName = tokens[0];

                    foreach (var item in items.Keys)
                    {
                        if (item.Contains(pokemonName))
                        {
                            Console.WriteLine($"# {item}");
                            foreach (var element in items[item])
                            {
                                Console.WriteLine($"{element.Type} <-> {element.Index}");
                                
                            }
                        }


                    }

                }
                else
                {
                    string pokemonName = tokens[0];
                    string evolutionType = tokens[1];
                    int evolutionIndex = int.Parse(tokens[2]);

                    TypeAndIndex typeAndIndex = new TypeAndIndex() { Type = evolutionType, Index = evolutionIndex };
                    
                    


                    if (!items.ContainsKey(pokemonName))
                    {
                        items.Add(pokemonName, new List<TypeAndIndex>());
                        items[pokemonName].Add(typeAndIndex);
                    }
                    else
                    {
                        items[pokemonName].Add(typeAndIndex);
                    }
                }


                input = Console.ReadLine();
            }
            

            foreach (var item in items)
            {
                Console.WriteLine($"# {item.Key}");
                foreach (var value in item.Value.OrderByDescending(x => x.Index))
                {
                    Console.WriteLine($"{value.Type} <-> {value.Index} ");
                    
                }
                
            }
        }
    }
    public class TypeAndIndex
    {
        public string Type { get; set; }
        public  int Index { get; set; }
    }
}
