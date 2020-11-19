using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace p03_RageQuit
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine().ToUpper();
            string pattern = @"([^0-9]+)(\d+)";

            MatchCollection matches = Regex.Matches(input, pattern);
            StringBuilder result = new StringBuilder();

            foreach (Match match in matches)
            {
                int count = int.Parse(match.Groups[2].Value);
                string word = match.Groups[1].Value;

                for (int i = 0; i < count; i++)
                {
                    result.Append(word);
                }
            }

            int uniqueSymbolsCount = result.ToString().Distinct().Count();

            Console.WriteLine($"Unique symbols used: {uniqueSymbolsCount}");
            Console.WriteLine(result);
        }
    }
}
