using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p04_Largest3Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> numbers = Console.ReadLine()
                .Split(' ')
                .Select(int.Parse)
                .OrderByDescending(x => x) // 10 20 50 5 =>  50 20 10 5
                .Take(3) // take first 3 nums
                .ToList();

            Console.WriteLine(string.Join(" ", numbers));


        }
    }
}
