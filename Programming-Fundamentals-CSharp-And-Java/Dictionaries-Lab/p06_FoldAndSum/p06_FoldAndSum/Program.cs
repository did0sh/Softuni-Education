using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p06_FoldAndSum
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] numbers = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();

            int k = numbers.Length / 4;

            List<int> firstRowHalf = numbers.Take(k).Reverse().ToList();
            List<int> firstRowSecondHalf = numbers.Reverse().Take(k).ToList();

            List<int> firstRow = firstRowHalf.Concat(firstRowSecondHalf).ToList();

            List<int> secondRow = numbers.Skip(k).Take(k * 2).ToList();

            List<int> sumRows = firstRow.Select((x, index) => x + secondRow[index]).ToList();

           
            Console.WriteLine(string.Join(" ", sumRows));
        }
    }
}
