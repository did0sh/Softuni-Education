using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p02_ExtractSentencesByKeyword
{
    class Program
    {
        static void Main(string[] args)
        {
            string keyWord = Console.ReadLine().ToLower();
            List<string> sentences = Console.ReadLine().Split(new char[] { '.', '!', '?' }).ToList();

            for (int i = 0; i < sentences.Count; i++)
            {
                string[] result = sentences[i].Split(new char[] {',', ':', ';', '(', ')', '[', ']', '{', '}', '-', '\\',
                '/', '\"', '\'', ' '}, StringSplitOptions.RemoveEmptyEntries);

                if (result.Contains(keyWord))
                {
                    Console.WriteLine(sentences[i].Trim());
                }
            }
        }
    }
}
