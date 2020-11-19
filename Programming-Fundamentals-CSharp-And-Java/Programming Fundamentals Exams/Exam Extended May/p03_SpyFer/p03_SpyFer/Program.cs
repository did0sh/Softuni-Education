using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p03_SpyFer
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> numbers = Console.ReadLine().Split(' ').Select(int.Parse).ToList();
            int count = 0; 
            if(numbers.Count == 2 && numbers[0] == numbers[1])
            {
                numbers.RemoveAt(0);
                Console.WriteLine(numbers[0]);
                return;
            }
            for (int i = 1; i < numbers.Count - 1; i++)
            {   
                int leftNeighbour = numbers[i - 1];
                int rightNeighbour = numbers[i + 1];

                int sum = leftNeighbour + rightNeighbour;

                if(sum == numbers[i])
                {
                    numbers.RemoveAt(i - 1);
                    numbers.RemoveAt(i);
                    i = 0;
                    count++;
                }
                else if(numbers[i] == numbers[i-1] && numbers[i] == numbers[i + 1])
                {
                    numbers.RemoveAt(i - 1);
                    numbers.RemoveAt(i);
                    i = 0;
                }
                else if (numbers[i] == numbers[i - 1])
                {
                    numbers.RemoveAt(i - 1);
                    i = 0;
                }
                else if (numbers[i] == numbers[i + 1])
                {
                    numbers.RemoveAt(i + 1);
                    i = 0;
                }     
            }

            Console.WriteLine(string.Join(" ", numbers));

        }
    }
}
