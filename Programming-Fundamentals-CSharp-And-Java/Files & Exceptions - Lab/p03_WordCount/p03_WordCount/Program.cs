using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace p03_WordCount
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] words = File.ReadAllText("words.txt").ToLower().Split(' ');
            string[] text = File.ReadAllText("text.txt").ToLower().Split(new char[] { '\n', '\r', ' ', '.', ',', '!', '?', '-' },
                StringSplitOptions.RemoveEmptyEntries);

            Dictionary<string, int> wordCount = new Dictionary<string, int>();

            foreach (var word in text)
            {
                if (words.Contains(word))
                {
                    if (!wordCount.ContainsKey(word))
                    {
                        wordCount.Add(word, 1);
                    }
                    else
                    {
                        wordCount[word]++;
                    }
                }
                
            }

            File.WriteAllText("output.txt", "");
            foreach (var item in wordCount.OrderByDescending(x => x.Value))
            {
                File.AppendAllText("output.txt", item.Key + " -> " + item.Value + Environment.NewLine);
            }


        }
    }
}
