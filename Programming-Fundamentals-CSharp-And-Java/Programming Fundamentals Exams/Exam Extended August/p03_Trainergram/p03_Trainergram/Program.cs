using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace p03_Trainergram
{
    class Program
    {

        static void Main(string[] args)
        {
            string pattern = @"^(<\[[^0-9A-Za-z]*\]\.)+(\.\[[0-9A-Za-z]*\]\.)*$";

            string input = Console.ReadLine();

            List<string> result = new List<string>();

            while (input != "Traincode!")
            {
                if (Regex.IsMatch(input, pattern))
                {
                    MatchCollection matches = Regex.Matches(input, pattern);

                    foreach (Match match in matches)
                    {
                        result.Add(match.Value);
                    }
                }
                input = Console.ReadLine();
            }

            for (int i = 0; i < result.Count; i++)
            {
                Console.WriteLine(result[i]);
            }
        }
    }
}
