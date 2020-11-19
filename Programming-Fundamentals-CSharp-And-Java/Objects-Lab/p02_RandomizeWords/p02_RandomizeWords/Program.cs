using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p02_RandomizeWords
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();

            string[] words = input.Split(' ');
            Random rnd = new Random();

            for (int i = 0; i < words.Length; i++)
            {
                int firstWord = rnd.Next(0, words.Length);
                int secondWord = rnd.Next(0, words.Length);

                string changer = words[firstWord];
                words[firstWord] = words[secondWord];
                words[secondWord] = changer;
            }

            Console.WriteLine(string.Join("\n", words));
        }
    }
}
