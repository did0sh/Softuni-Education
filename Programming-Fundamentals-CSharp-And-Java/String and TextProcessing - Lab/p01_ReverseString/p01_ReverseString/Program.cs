using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p01_ReverseString
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            char[] result = input.Reverse().ToArray();
            string reversed = new string(result);

            Console.WriteLine(reversed);
        }
    }
}
