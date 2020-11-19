using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace p02_HornetComm
{
    class Program
    {
        static void Main(string[] args)
        {
            string privateMessagePattern = @"(^[0-9]+)( <-> )([0-9A-Za-z]+$)";
            string patternBroadcast = @"(^[^0-9]+)( <-> )([0-9A-Za-z]+$)";

            List<string> resultsPrivateMessage = new List<string>();
            List<string> reversed = new List<string>();

            List<string> resultsBroadcast = new List<string>();
            List<string> upperAndLowerCase = new List<string>();

            string input = Console.ReadLine();

            while(input != "Hornet is Green")
            {

                if(!Regex.IsMatch(input, privateMessagePattern) && !Regex.IsMatch(input, patternBroadcast))
                {
                    input = Console.ReadLine();
                    continue;
                }
                else if(Regex.IsMatch(input,privateMessagePattern))
                {
                    MatchCollection matches = Regex.Matches(input, privateMessagePattern);
                    foreach (Match match in matches)
                    {
                        resultsPrivateMessage.Add(match.Groups[1].Value);
                        resultsPrivateMessage.Add(match.Groups[3].Value);
                    }
                }
                else if (Regex.IsMatch(input, patternBroadcast))
                {
                    MatchCollection matches = Regex.Matches(input, patternBroadcast);
                    foreach (Match match in matches)
                    {
                        resultsBroadcast.Add(match.Groups[3].Value);
                        resultsBroadcast.Add(match.Groups[1].Value);
                    }
                }
    
                input = Console.ReadLine();
            }

            Console.WriteLine("Broadcasts:");
            for (int t = 0; t < resultsBroadcast.Count; t++)
            {
                if(t % 2 == 0)
                {
                    string item = resultsBroadcast[t];
                    int length = resultsBroadcast[t].Length;
                    upperAndLowerCase.Clear();

                    for (int u = 0; u < length; u++)
                    {
                        if(!Char.IsDigit(item[u]) && item[u].ToString() == item[u].ToString().ToUpper())
                        {
                            upperAndLowerCase.Add(item[u].ToString().ToLower());
                        }
                        else if(!Char.IsDigit(item[u]) && item[u].ToString() == item[u].ToString().ToLower())
                        {
                            upperAndLowerCase.Add(item[u].ToString().ToUpper());
                        }
                        else if (Char.IsDigit(item[u]))
                        {
                            upperAndLowerCase.Add(item[u].ToString());
                        }
                    }
                }
                else
                {
                    Console.WriteLine($"{string.Join("",upperAndLowerCase)} -> {resultsBroadcast[t]}");
                }
            }

            if(resultsBroadcast.Count == 0)
            {
                Console.WriteLine("None");
            }



            Console.WriteLine("Messages:");

            for (int i = 0; i < resultsPrivateMessage.Count; i++)
            {
                if(i % 2 == 0)
                {
                    string item = resultsPrivateMessage[i];
                    int length = resultsPrivateMessage[i].Length;
                    reversed.Clear();

                    for (int k = length - 1; k >= 0 ; k--)
                    {
                        reversed.Add(item[k].ToString());
                    }
                }
                else
                {
                    Console.WriteLine(string.Join("", reversed) + " -> " + resultsPrivateMessage[i]);
                }
            }

            if(resultsPrivateMessage.Count == 0)
            {
                Console.WriteLine("None");
            }
                
        }
    }
}
