using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p09_IndexOfLetters
{
    class Program
    {
        static void Main(string[] args)
        {
            char[] items = Console.ReadLine().ToArray();

            for (int i = 0; i < items.Length; i++)
            {
                char currentChar = items[i];

                for (int j = 97; j <= 122; j++) // ascii table from 'a' to 'z'
                {
                    if(currentChar == j)
                    {
                        int index = j - 97;
                        Console.WriteLine($"{currentChar} -> {index}");
                    }
                }
            }
        }
    }
}
