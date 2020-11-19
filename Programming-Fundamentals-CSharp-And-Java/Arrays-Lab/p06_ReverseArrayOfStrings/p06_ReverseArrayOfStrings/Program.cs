using System;
using System.Linq;
namespace p06_ReverseArrayOfStrings
{
    class Program
    {
        static void Main(string[] args)
        {
            string arr = Console.ReadLine();
            string[] items = arr.Split(' ');
            

            for (int i = items.Length - 1; i >= 0; i--)
            {
                Console.Write(items[i]);
                Console.Write(" ");
            }

            // second possibility:

            // var reversed = items.Reverse();
            // Console.Writeline(string.Join(", ", reversed)
        }
    }
}
