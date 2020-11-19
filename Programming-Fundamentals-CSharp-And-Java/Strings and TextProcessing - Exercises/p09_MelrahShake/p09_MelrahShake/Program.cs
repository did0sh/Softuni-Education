using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Text.RegularExpressions;

namespace p09_MelrahShake
{
    class Program
    {
        static void Main(string[] args)
        {
            string text = Console.ReadLine();
            string pattern = Console.ReadLine();

            while (true)
            {

                int firstIndex = text.IndexOf(pattern);
                int lastIndex = text.LastIndexOf(pattern);

                if(firstIndex > -1 && lastIndex > -1 && pattern.Length > 0)
                {
                    firstIndex = text.IndexOf(pattern);
                    text = text.Remove(firstIndex, pattern.Length);

                    lastIndex = text.LastIndexOf(pattern);
                    text = text.Remove(lastIndex, pattern.Length);

                    pattern = pattern.Remove(pattern.Length / 2, 1);

                    Console.WriteLine("Shaked it.");
                }
                else
                {
                    Console.WriteLine("No shake.");
                    Console.WriteLine(text);
                    break;
                }

            }

            
        }
    }
}
