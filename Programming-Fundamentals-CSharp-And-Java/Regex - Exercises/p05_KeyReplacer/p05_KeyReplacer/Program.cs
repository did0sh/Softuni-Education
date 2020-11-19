using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace p05_KeyReplacer
{
    class Program
    {
        static void Main(string[] args)
        {
            string key = Console.ReadLine();
            string text = Console.ReadLine();

            string pattern = @"^([A-Za-z]+)(\<|\||\\).+(\<|\||\\)([A-Za-z]+)$";
            
            if(Regex.IsMatch(key, pattern))
            {
                MatchCollection matches = Regex.Matches(key, pattern);

                foreach (Match match in matches)
                {
                    string startKey = match.Groups[1].Value;
                    string endKey = match.Groups[4].Value;

                    string patternForText = $@"{startKey}(.*?){endKey}";
                    MatchCollection textMatches = Regex.Matches(text, patternForText);

                    StringBuilder results = new StringBuilder();

                    foreach (Match res in textMatches)
                    {
                        results.Append(res.Groups[1].Value);
                    }

                    if(results.ToString().Length == 0)
                    {
                        Console.WriteLine("Empty result");
                    }
                    else
                    {
                        Console.WriteLine(results.ToString());
                    }
                }
            }
        }
    }
}
