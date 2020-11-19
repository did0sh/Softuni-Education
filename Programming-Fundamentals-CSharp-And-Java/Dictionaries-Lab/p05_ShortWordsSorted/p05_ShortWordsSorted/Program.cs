using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p05_ShortWordsSorted
{
    class Program
    {
        static void Main(string[] args)
        {
            List<string> text = Console.ReadLine().
                ToLower().
                Split(new char[] { '.', ',', ':', ';', '(', ')', '[', ']', '"', '\'', '\\', '/', '!', '?', ' ' },
                StringSplitOptions.RemoveEmptyEntries).
                Where(x => x.Length < 5).
                OrderBy(x => x).
                Distinct().
                ToList();


            Console.WriteLine(string.Join(", ", text));




        }
    }
}
