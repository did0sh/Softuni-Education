using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p03_SumMinMaxAverage
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            // int[] nums = new int[n];               also possible

            List<int> nums = new List<int>();

            for (int i = 0; i < n; i++)
            {
                // nums[i] = int.Parse(Console.ReadLine());           also possible
                int currentNum = int.Parse(Console.ReadLine());
                nums.Add(currentNum);
            }

            Console.WriteLine("Sum = {0}",nums.Sum());
            Console.WriteLine("Min = {0}", nums.Min());
            Console.WriteLine("Max = {0}", nums.Max());
            Console.WriteLine("Average = {0}", nums.Average());



        }
    }
}
