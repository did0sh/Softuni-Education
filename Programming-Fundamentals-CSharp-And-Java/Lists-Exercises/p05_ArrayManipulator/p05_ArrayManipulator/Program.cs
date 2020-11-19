using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p05_ArrayManipulator
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> numbers = Console.ReadLine().Split(' ').Select(int.Parse).ToList();

            List<string> operations = Console.ReadLine().Split(' ').ToList();

            while(operations[0] != "print")
            {


                if (operations[0] == "add")
                {
                    int index = int.Parse(operations[1]);
                    int element = int.Parse(operations[2]);
                    numbers.Insert(index, element);             // Insert(at position, number)
                }




                else if (operations[0] == "addMany")
                {
                    int index = int.Parse(operations[1]); // addmany at position 0
                    for (int i = 2; i < operations.Count; i++)
                    {
                        int element = int.Parse(operations[i]); // numbers: ... untill the end
                        numbers.Insert(index, element);           
                        index++;
                    }
                }



                else if (operations[0] == "contains")
                {
                    int element = int.Parse(operations[1]);

                    if (numbers.Contains(element))
                    {
                        Console.WriteLine(numbers.IndexOf(element));
                    }
                    else
                    {
                        Console.WriteLine(-1);
                    }
                    // if contains (prints the index)
                    // if doesn`t contain (prints -1)

                }




                else if (operations[0] == "remove")
                {
                    int index = int.Parse(operations[1]);
                    numbers.RemoveAt(index); // remove number at index
                }




                else if (operations[0] == "shift")
                {
                    int positions = int.Parse(operations[1]);

                    while(positions > 0) // 1 2 3 4 5 => 1 => 2 3 4 5 1     .....    2 => 3 4 5 1 2
                    {
                        int firstNum = numbers[0];
                        numbers.RemoveAt(0);
                        numbers.Add(firstNum);
                        positions--;
                    }


                }





                else if (operations[0] == "sumPairs")
                {
                    for (int j = 0; j < numbers.Count - 1; j++)
                    {
                        numbers[j] = numbers[j] + numbers[j + 1];
                        numbers.RemoveAt(j + 1);
                        // 1 2 3 4 => 1+2 => 3 2 3 4 => 3 3 4 => 3 7 
                    }
                }

               operations = Console.ReadLine().Split(' ').ToList();

            }



            Console.WriteLine("[" + string.Join(", ", numbers) + "]");

        }
    }
}
