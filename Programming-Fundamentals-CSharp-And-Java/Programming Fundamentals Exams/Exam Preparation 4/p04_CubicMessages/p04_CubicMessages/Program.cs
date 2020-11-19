using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace p04_CubicMessages
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            int length = int.Parse(Console.ReadLine());

            
            List<int> firstnums = new List<int>();
            List<int> secondnums = new List<int>();

            string text = null;

            while (true)
            {
                string pattern = @"(^\d+)([A-Za-z]{" + $"{length}" + "})(([^A-Za-z]+)*)$";
                if (input == "Over!")
                {
                    break;
                }

                if (!Regex.IsMatch(input, pattern))
                {
                    input = Console.ReadLine();
                    if (input == "Over!")
                    {
                        break;
                    }

                    length = int.Parse(Console.ReadLine());
                    continue;
                }
                else
                {
                    MatchCollection matches = Regex.Matches(input, pattern);

                    foreach (Match match in matches)
                    {
                        text = match.Groups[2].Value;

                        string firstIndexes = match.Groups[1].Value;
                        string secondIndexes = match.Groups[3].Value;


                        for (int i = 0; i < firstIndexes.Length; i++)
                        {
                            firstnums.Add(int.Parse(firstIndexes[i].ToString()));
                        }

                        for (int k = 0; k < secondIndexes.Length; k++)
                        {
                            if (Char.IsDigit(secondIndexes[k]))
                            {
                                secondnums.Add(int.Parse(secondIndexes[k].ToString()));
                            }
                        }
                    }


                    Console.Write($"{text} == ");
                    for (int k = 0; k < firstnums.Count; k++)
                    {
                        if (firstnums[k] >= text.Length)
                        {
                            Console.Write(" ");
                        }
                        else
                        {
                            Console.Write(text[firstnums[k]]);
                        }
                    }

                    for (int t = 0; t < secondnums.Count; t++)
                    {
                        if (secondnums[t] >= text.Length)
                        {
                            Console.Write(" ");
                        }
                        else
                        {
                            Console.Write(text[secondnums[t]]);
                        }
                    }
                    Console.WriteLine();

                }

                firstnums = new List<int>();
                secondnums = new List<int>();

                input = Console.ReadLine();

                if (input == "Over!")
                {
                    break;
                }

                length = int.Parse(Console.ReadLine());
            }
        }
    }
}
