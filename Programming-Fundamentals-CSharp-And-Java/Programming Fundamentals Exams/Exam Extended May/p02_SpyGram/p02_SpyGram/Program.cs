using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace p02_SpyGram
{
    class Program
    {
        static void Main(string[] args)
        {
            string numbers = Console.ReadLine();
            List<int> shift = new List<int>();

            Dictionary<string, List<string>> orderedResult = new Dictionary<string, List<string>>();

            for (int i = 0; i < numbers.Length; i++)
            {
                shift.Add(int.Parse(numbers[i].ToString()));
            }

            string input = Console.ReadLine();
            string pattern = @"^(TO: ([A-Za-z]+); )(MESSAGE: .+);$";

            List<string> concat = new List<string>();
            

            while (input != "END")
            {
                concat = new List<string>();
                string checkUpper = null;
                if(!Regex.IsMatch(input, pattern))
                {
                    input = Console.ReadLine();
                    continue;
                }
                else
                {
                    MatchCollection matches = Regex.Matches(input, pattern);
                    foreach (Match match in matches)
                    {
                        checkUpper = match.Groups[2].Value;
                        if(checkUpper != checkUpper.ToUpper())
                        {  
                            break;
                        }
                        else
                        {
                            if (!orderedResult.ContainsKey(checkUpper))
                            {
                                orderedResult.Add(checkUpper, new List<string>());
                            }
                            
                            concat.Add(match.Value);
                        }
                    }
                }

                if(checkUpper != checkUpper.ToUpper())
                {
                    input = Console.ReadLine();
                    continue;
                }

                string matched = concat[0];
                StringBuilder result = new StringBuilder();

                
                for (int k = 0; k < matched.Length; k++)
                {
                    if(k > shift.Count - 1)
                    {
                        
                        matched = matched.Substring(k);
                        k = 0;
                    }

                    int currShift = shift[k];
                    char shiftedString = (char)((int)matched[k] + currShift);
                    

                    result.Append(shiftedString);
                }

                orderedResult[checkUpper].Add(result.ToString());
                input = Console.ReadLine();
            }

            foreach (var item in orderedResult.OrderBy(x => x.Key))
            {
                foreach (var element in item.Value)
                {
                    Console.WriteLine(element);
                }
            }
        }
    }
}
