using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace Problem03
{
    class Program
    {
        static void Main(string[] args)
        {
            string encodedText = Console.ReadLine();
            List<string> input = new List<string>();
            input.Add(encodedText);

            string[] tokens = Console.ReadLine().Split(new char[] { '{', '}' }, StringSplitOptions.RemoveEmptyEntries);
 

            string pattern = @"(.*?)([A-Za-z]+)(.+)(\2)";

            MatchCollection matches = Regex.Matches(encodedText, pattern);

            
            List<string> results = new List<string>();
            int index = 0;
            StringBuilder builder = new StringBuilder();
            StringBuilder stringBuilder = new StringBuilder();
            foreach (Match match in matches)
            {
                stringBuilder.Append(match.Groups[1].Value);
                stringBuilder.Append(match.Groups[2].Value);
                stringBuilder.Append(match.Groups[3].Value);
                stringBuilder.Append(match.Groups[4].Value);

                if (index <= tokens.Length - 1)
                {
                    string valueToReplace = match.Groups[3].Value;
                    valueToReplace = tokens[index];
                    

                    builder.Append(match.Groups[1].Value);
                    builder.Append(match.Groups[2].Value);
                    builder.Append(valueToReplace);
                    builder.Append(match.Groups[4].Value);

                    
                }
                else
                {
                    
                    builder.Append(match.Groups[1].Value);
                    builder.Append(match.Groups[2].Value);
                    builder.Append(match.Groups[3].Value);
                    builder.Append(match.Groups[4].Value);

                    
                }
                
                    index++;
            }

            string allAfter = encodedText.Substring(stringBuilder.Length);

            builder.Append(allAfter);
             results.Add(builder.ToString());
 
            Console.WriteLine(string.Join("", results));
           
        }
    }
}
