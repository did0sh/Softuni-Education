using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace p03_MatchHexadecimalNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            string pattern = @"\b(0x)?[0-9A-F]+\b";
            string input = Console.ReadLine();

            MatchCollection matches = Regex.Matches(input, pattern);

            string[] matchedNumbers = matches.Cast<Match>().Select(x => x.Value).ToArray();

            Console.WriteLine(string.Join(" ", matchedNumbers));
        }
    }
}
