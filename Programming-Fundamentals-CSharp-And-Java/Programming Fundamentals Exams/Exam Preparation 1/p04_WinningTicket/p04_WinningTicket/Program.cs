using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace p04_WinningTicket
{
    class Program
    {
        static void Main(string[] args)
        {
            string pattern = @"(?:.*?)(\${6,10}|#{6,10}|@{6,10}|\^{6,10})(?:.*?)(\1)";
            string[] input = Console.ReadLine().Split(new char[] { ',' }, StringSplitOptions.RemoveEmptyEntries);

            for (int i = 0; i < input.Length; i++)
            {
                input[i] = input[i].Trim();
            }

            for (int j = 0; j < input.Length; j++)
            {
                if (input[j].Length != 20)
                {
                    Console.WriteLine("invalid ticket");
                }
                else
                {
                    if (!Regex.IsMatch(input[j], pattern))
                    {
                        Console.WriteLine("ticket \"{0}\" - no match", input[j]);
                    }
                    else
                    {
                        MatchCollection matches = Regex.Matches(input[j], pattern);
                        foreach (Match match in matches)
                        {
                            if (match.Groups[1].Length == match.Groups[2].Length)
                            {
                                if (match.Groups[2].Length != 10)
                                {
                                    Console.WriteLine("ticket \"{0}\" - {1}{2}", input[j], match.Groups[1].Length, match.Groups[1].Value[0]);
                                }
                                else
                                {
                                    Console.WriteLine("ticket \"{0}\" - {1}{2} Jackpot!", input[j], match.Groups[1].Length, match.Groups[1].Value[0]);
                                }

                            }
                            else
                            {
                                var minLength = Math.Min(match.Groups[1].Length, match.Groups[2].Length);
                                Console.WriteLine("ticket \"{0}\" - {1}{2}", input[j], minLength, match.Groups[1].Value[0]);
                            }
                        }
                    }
                }
            }

        }
    }
}
