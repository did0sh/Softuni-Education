using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p04_SplitByWordCasing
{
    class Program
    {
        static void Main(string[] args)
        {
            List<string> words = Console.ReadLine().Split(new char[] { ' ', ',', ';', ':', '.', '!', '(', ')', '"', '\'', '\\', '/', '[', ']' },
                StringSplitOptions.RemoveEmptyEntries).ToList();

            List<string> lowerCase = new List<string>();
            List<string> upperCase = new List<string>();
            List<string> mixedCase = new List<string>();



            foreach (var word in words)
            {
                bool isLower = true;
                bool isUpper = true;
               

                for (int i = 0; i < word.Length; i++)
                {
                    if (char.IsLower(word[i]))
                    {
                        isUpper = false;
                    }
                    else if (char.IsUpper(word[i]))
                    {
                        isLower = false;
                    }
                    else
                    {
                        isLower = false;
                        isUpper = false;
                    }
                    
                }

                if (isLower)
                {
                    lowerCase.Add(word);
                }
                else if (isUpper)
                {
                    upperCase.Add(word);
                }
                else
                {
                    mixedCase.Add(word); 
                }

            }

            Console.WriteLine("Lower-case: {0}", string.Join(", ", lowerCase));
            Console.WriteLine("Mixed-case: {0}", string.Join(", ", mixedCase));
            Console.WriteLine("Upper-case: {0}", string.Join(", ", upperCase));


        }
    }
}
