using System;

namespace _3.Last_K_Numbers_Sums_Sequence
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());
            var k = int.Parse(Console.ReadLine());
            var arr = new long[n];
            arr[0] = 1;
            for (int i = 1; i < n; i++)
            {
                long sum = 0;
                for (int j = k; j > 0; j--)
                {
                    if (i - j >= 0)
                    {
                        sum += arr[i - j];
                    }
                    arr[i] = sum;
                }
            }
            Console.WriteLine(string.Join(" ", arr));
        }
    }
}
