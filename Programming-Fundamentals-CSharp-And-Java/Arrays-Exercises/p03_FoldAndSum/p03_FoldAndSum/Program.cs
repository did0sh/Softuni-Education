using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p03_FoldAndSum
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] items = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();

            int k = items.Length / 4;
            int[] outsideNums = new int[k*2];
            int[] middleNums = new int[k*2];

            for (int i = 0; i < k*2; i++)
            {
                middleNums[i] = items[k + i];
            }

            for (int j = 0; j < k; j++)
            {
                outsideNums[j] = items[k - 1 - j];
                outsideNums[j + k] = items[items.Length - 1 - j];
            }

            int[] sum = new int[k * 2];

            for (int u = 0; u < sum.Length; u++)
            {
                sum[u] = outsideNums[u] + middleNums[u];
            }


            Console.WriteLine(string.Join(" ", sum));
          
        }
    }
}
