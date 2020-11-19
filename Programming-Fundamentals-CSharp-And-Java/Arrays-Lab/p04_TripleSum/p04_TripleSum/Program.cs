using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p04_TripleSum
{
    class Program
    {
        static void Main(string[] args)
        {
             int[] numbers = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
            bool check = false;

            for (int i = 0; i < numbers.Length; i++)
            {
                for (int j = i+1; j < numbers.Length; j++)
                {
                    for (int k = 0; k < numbers.Length; k++)
                    {
                        if(numbers[i] + numbers[j] == numbers[k])
                        {
                            Console.WriteLine($"{numbers[i]} + {numbers[j]} == {numbers[k]}");
                            check = true;
                            break;
                        }
                    }
                }
            }

            if(check == false)
            {
                Console.WriteLine("No");
            }
            
        }
    }
}
