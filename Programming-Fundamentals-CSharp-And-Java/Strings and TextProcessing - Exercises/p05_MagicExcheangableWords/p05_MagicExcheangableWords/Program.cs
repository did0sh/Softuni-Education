using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p05_MagicExcheangableWords
{
    class Program

    {
        static void Main(string[] args)
        {
            string[] input = Console.ReadLine().Split(' ');
            Dictionary<char, char> items = new Dictionary<char, char>();

            string firstWord = input[0];
            string secondWord = input[1];

            bool isExchangable = true;

            if (firstWord.Length == secondWord.Length)
            {
                for (int i = 0; i < firstWord.Length; i++)
                {
                    char firstChar = firstWord[i];
                    char secondChar = secondWord[i];

                    if (!items.ContainsKey(firstChar))
                    {
                        items.Add(firstChar, secondChar);
                    }
                    else
                    {
                        if (items[firstChar] != secondChar)
                        {
                            isExchangable = false;
                            break;
                        }
                    }
                }
            }


            else
            {

                int minLength = Math.Min(firstWord.Length, secondWord.Length);


                if (secondWord.Length > firstWord.Length)
                {
                    for (int i = 0; i < minLength; i++)
                    {
                        char firstChar = secondWord[i];
                        char secondChar = firstWord[i];

                        if (!items.ContainsKey(firstChar))
                        {
                            items.Add(firstChar, secondChar);
                        }
                        else
                        {
                            if (items[firstChar] != secondChar)
                            {
                                isExchangable = false;
                                break;
                            }
                        }
                    }

                    secondWord = secondWord.Substring(minLength);
                    foreach (var character in secondWord)
                    {
                        if (!items.ContainsKey(character))
                        {
                            isExchangable = false;
                            break;
                        }
                    }
                }



                else if (secondWord.Length < firstWord.Length)
                {
                    for (int i = 0; i < minLength; i++)
                    {
                        char firstChar = firstWord[i];
                        char secondChar = secondWord[i];

                        if (!items.ContainsKey(firstChar))
                        {
                            items.Add(firstChar, secondChar);
                        }
                        else
                        {
                            if (items[firstChar] != secondChar)
                            {
                                isExchangable = false;
                                break;
                            }
                        }
                    }

                    firstWord = firstWord.Substring(minLength);
                    foreach (var character in firstWord)
                    {
                        if (!items.ContainsKey(character))
                        {
                            isExchangable = false;
                            break;
                        }
                    }
                }
            }

            Console.WriteLine(isExchangable.ToString().Substring(0, 1).ToLower() + isExchangable.ToString().Substring(1));
        }
    }
}
