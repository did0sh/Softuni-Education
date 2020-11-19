using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p02_Icarus
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> items = Console.ReadLine().Split(' ').Select(int.Parse).ToList();
            int startingPosition = int.Parse(Console.ReadLine());

            int damage = 1;
            string input = Console.ReadLine();

            while (input != "Supernova")
            {
                string[] tokens = input.Split(' ');
                string command = tokens[0];
                int positionsMove = int.Parse(tokens[1]);

                if(command == "left")
                {
                    for (int i = 0; i < positionsMove; i++)
                    {
                        startingPosition--;

                        if (startingPosition < 0)
                        {
                            startingPosition = items.Count - 1;
                            damage++;
                        }

                        items[startingPosition] -= damage;
                    }
                }
               else if (command == "right")
                {
                    for (int i = 0; i < positionsMove; i++)
                    {
                        startingPosition++;

                        if (startingPosition > items.Count - 1)
                        {
                            startingPosition = 0;
                            damage++;
                        }

                        items[startingPosition] -= damage;
                    }
                }

                input = Console.ReadLine();
            }

            Console.WriteLine(string.Join(" ", items));
        }
    }
}
