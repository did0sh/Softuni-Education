using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace p03_NetherRealms
{
    class Program
    {
        static void Main(string[] args)
        {
            string patternDemonHealth = @"[^0-9\+\-\*\/\.]";
            string patternDamage = @"(\+|-)?(\d+)(\.\d+)?";

            Dictionary<string, Dictionary<int, double>> items = new Dictionary<string, Dictionary<int, double>>();

            string[] input = Console.ReadLine().Split(new char[] { ',', ' ' }, StringSplitOptions.RemoveEmptyEntries);

            List<string> health = new List<string>();

            int demonTotalHealth = 0;
            int countMultiply = 0;
            int countDivide = 0;
            double totalDamage = 0;

            for (int i = 0; i < input.Length; i++)
            {
                demonTotalHealth = 0;
                health.Clear();               
                countDivide = 0;
                countMultiply = 0;
                totalDamage = 0;

                string name = input[i];

                if (Regex.IsMatch(name, patternDemonHealth))
                {
                    MatchCollection matches = Regex.Matches(name, patternDemonHealth);
                    foreach (Match match in matches)
                    {
                        health.Add(match.Value);
                    }

                    for (int k = 0; k < health.Count; k++)
                    {
                        char charValue = char.Parse(health[k]);
                        demonTotalHealth += (int)charValue;
                    }
                }

                for (int c = 0; c < name.Length; c++)
                {
                    if(name[c] == '*')
                    {
                        countMultiply++;
                    }
                    else if (name[c] == '/')
                    {
                        countDivide++;
                    }
                }

                if(Regex.IsMatch(name, patternDamage))
                {
                    MatchCollection damage = Regex.Matches(name, patternDamage);
                    foreach (Match number in damage)
                    {
                        double num = double.Parse(number.Value);
                        totalDamage += num;
                    }
                }

                for (int u = 0; u < countMultiply; u++)
                {
                    totalDamage *= 2.0;
                }

                for (int t = 0; t < countDivide; t++)
                {
                    totalDamage /= 2.0;
                }

                if (!items.ContainsKey(name))
                {
                    items.Add(name, new Dictionary<int, double>());
                    items[name].Add(demonTotalHealth, totalDamage);
                }

            }

            foreach (var demon in items.OrderBy(x => x.Key))
            {
                Console.Write($"{demon.Key} - ");
                foreach (var output in demon.Value)
                {
                    Console.WriteLine($"{output.Key} health, {output.Value:F2} damage");
                }
            } 
        }
    }
}
