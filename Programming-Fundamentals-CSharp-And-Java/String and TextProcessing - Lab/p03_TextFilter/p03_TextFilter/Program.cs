using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p03_TextFilter
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] banWords = Console.ReadLine().Split(new char[] { ' ', ',' }, StringSplitOptions.RemoveEmptyEntries);
            string text = Console.ReadLine();

            foreach (var banword in banWords)
            {
                if (text.Contains(banword))
                {
                    string replacement = new string('*', banword.Length);
                    text = text.Replace(banword, replacement);
                }
            }

            Console.WriteLine(text);
        }
    }
}
