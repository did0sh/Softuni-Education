using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p04_Palindromes
{
    class Program
    {
        static void Main(string[] args)
        {
            Dictionary<string, string> items = new Dictionary<string, string>();

            string[] words = Console.ReadLine().Trim().Split(new char[] { ' ', '.', ',', '?', '!' }, StringSplitOptions.RemoveEmptyEntries);

            for (int i = 0; i < words.Length; i++)
            {
                string currentWord = words[i];

                if (!items.ContainsKey(currentWord))
                {
                    char[] charArray = currentWord.Reverse().ToArray();
                    string reversed = new string(charArray);
                    items.Add(currentWord, reversed);
                }
            }

            items = items.Where(x => x.Key.CompareTo(x.Value) == 0).OrderBy(x => x.Key).ToDictionary(x => x.Key, x => x.Value);
            int count = 0;

            foreach (var word in items)
            {
                count++;
                if(count == items.Count)
                {
                    Console.WriteLine(word.Key);
                }
                else
                {
                    Console.Write(word.Key + ", ");
                }
                

            }
        }
    }
}
