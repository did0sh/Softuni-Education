using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p02_ChangeList
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> numbers = Console.ReadLine().Split(' ').Select(int.Parse).ToList();

            List <string> str = Console.ReadLine().Split(' ').ToList();

            while(str[0] != "Odd" && str[0] != "Even")
            {           

                if(str[0] == "Delete")
                {
                    int removeNum = int.Parse(str[1]);
                    numbers.RemoveAll(item => item == removeNum);
                }
                else if (str[0] == "Insert")
                {
                    int element = int.Parse(str[1]);
                    int position = int.Parse(str[2]);
                    numbers.Insert(position, element);
                }

                str = Console.ReadLine().Split(' ').ToList();
            }




            if(str[0] == "Odd")
            {
                for (int i = 0; i < numbers.Count; i++)
                {
                    if(numbers[i] % 2 != 0)
                    {
                        Console.Write(numbers[i]);
                        Console.Write(" ");
                    }
                }
            }
            else if(str[0] == "Even")
            {
                for (int j = 0; j < numbers.Count; j++)
                {
                    if (numbers[j] % 2 == 0)
                    {
                        Console.Write(numbers[j]);
                        Console.Write(" ");
                    }
                }
            }

            
        }
    }
}
