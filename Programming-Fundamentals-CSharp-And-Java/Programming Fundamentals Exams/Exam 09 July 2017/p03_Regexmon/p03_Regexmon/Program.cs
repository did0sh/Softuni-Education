using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace p03_Regexmon
{
    class Program
    {
        static void Main(string[] args)
        {
            string patternBojomon = @"[A-Za-z]+-[A-Za-z]+";
            string patternDidimon = @"[^A-Za-z-]+";
            string input = Console.ReadLine();

            while (true)
            {
                if(Regex.IsMatch(input, patternDidimon))
                {
                    Match match = Regex.Match(input, patternDidimon);
                    input = input.Substring(match.Index + match.Length);
                    Console.WriteLine(match);
                }
                else
                {
                    break;
                }

                if(Regex.IsMatch(input, patternBojomon))
                {
                    Match match = Regex.Match(input, patternBojomon);
                    input = input.Substring(match.Index + match.Length);
                    Console.WriteLine(match);
                }
                else
                {
                    break;
                }
            }
        }
    }
}
