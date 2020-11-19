using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p02_PokemonDontGo
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> numbers = Console.ReadLine().Split(' ').Select(int.Parse).ToList();

            long sum = 0;

            while(numbers.Count != 0)
            {
                int index = int.Parse(Console.ReadLine());

                if(index >= 0 && index <= numbers.Count - 1)
                {
                    int removedNumberValue = numbers[index];

                    sum += removedNumberValue;
                    numbers.RemoveAt(index);

                    for (int i = 0; i < numbers.Count; i++)
                    {
                        if(numbers[i] <= removedNumberValue)
                        {
                            numbers[i] += removedNumberValue;
                        }
                        else
                        {
                            numbers[i] -= removedNumberValue;
                        }
                    }
                }
                else if(index < 0)
                {
                    int removedNumberValue = numbers[0];
                    sum += removedNumberValue;
                    numbers[0] = numbers[numbers.Count - 1];

                    for (int i = 0; i < numbers.Count; i++)
                    {
                        if (numbers[i] <= removedNumberValue)
                        {
                            numbers[i] += removedNumberValue;
                        }
                        else
                        {
                            numbers[i] -= removedNumberValue;
                        }
                    }
                }
                else if(index > numbers.Count - 1)
                {
                    int removedNumberValue = numbers[numbers.Count - 1];
                    sum += removedNumberValue;
                    numbers[numbers.Count - 1] = numbers[0];

                    for (int i = 0; i < numbers.Count; i++)
                    {
                        if (numbers[i] <= removedNumberValue)
                        {
                            numbers[i] += removedNumberValue;
                        }
                        else
                        {
                            numbers[i] -= removedNumberValue;
                        }
                    }
                }
            }

            Console.WriteLine(sum);
        }
    }
}
