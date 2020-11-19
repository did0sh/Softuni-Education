using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p07_CountNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> numbers = Console.ReadLine().Split(' ').Select(int.Parse).ToList();
            int count = 0;
            int currentNum = 0;

            numbers.Sort();

            for (int i = 0; i < numbers.Count; i++)
            {
                 currentNum = numbers[i];
                for (int j = i; j < numbers.Count; j++)
                {
                    if(currentNum == numbers[j])
                    {
                        count++;
                        if(j == numbers.Count - 1)
                        {
                            Console.WriteLine("{0} -> {1}", currentNum, count);
                            return;
                        }
                    }
                    else
                    {
                        Console.WriteLine("{0} -> {1}", currentNum, count);
                        count = 0;
                        i = j-1;
                        break;
                    }
                }               
            
            }

        }
    }
}
