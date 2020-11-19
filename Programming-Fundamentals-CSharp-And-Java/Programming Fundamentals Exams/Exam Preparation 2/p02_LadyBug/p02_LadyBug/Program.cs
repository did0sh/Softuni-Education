using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p02_LadyBug
{
    class Program
    {
        static void Main(string[] args)
        {
            int fieldSize = int.Parse(Console.ReadLine());
            List<int> indexes = Console.ReadLine().Split(' ').Select(int.Parse).ToList();

            int[] startingField = new int[fieldSize];

            for (int i = 0; i < fieldSize; i++)
            {
                if (indexes.Contains(i))
                {
                    startingField[i] = 1;
                }
            }

            string input = Console.ReadLine();

            while (input != "end")
            {
                string[] tokens = input.Split(' ');

                int fromPosition = int.Parse(tokens[0]);
                int toPosition = int.Parse(tokens[2]);

                string direction = tokens[1];

                if (fromPosition < fieldSize && fromPosition >= 0
                    && toPosition < fieldSize
                    && startingField[fromPosition] != 0)
                {

                    if (direction == "right")
                    {
                        if (fromPosition + toPosition >= fieldSize || fromPosition + toPosition < 0)
                        {
                            startingField[fromPosition] = 0;
                            input = Console.ReadLine();
                            continue;
                        }
                        else
                        {
                            long flyDistance = fromPosition + toPosition;
                            startingField[fromPosition] = 0;

                            while (fromPosition >= 0 && fromPosition < fieldSize && flyDistance < fieldSize && flyDistance >= 0)
                            {
                                if (startingField[flyDistance] == 0)
                                {
                                    startingField[flyDistance] = 1;
                                    break;
                                }
                                else
                                {
                                    flyDistance += toPosition;
                                }
                            }
                        }
                    }


                    else if (direction == "left")
                    {
                        if (fromPosition - toPosition < 0 || fromPosition - toPosition >= fieldSize)
                        {
                            startingField[fromPosition] = 0;
                            input = Console.ReadLine();
                            continue;
                        }
                        else
                        {
                            startingField[fromPosition] = 0;
                            long flyDistance = fromPosition - toPosition;

                            while (fromPosition >= 0 && fromPosition < fieldSize && flyDistance >= 0 && flyDistance < fieldSize)
                            {
                                if (startingField[flyDistance] == 0)
                                {
                                    startingField[flyDistance] = 1;
                                    break;
                                }
                                else
                                {
                                    flyDistance -= toPosition;
                                }
                            }
                        }

                    }
                }

                input = Console.ReadLine();
            }
            Console.WriteLine(string.Join(" ", startingField));
        }
    }
}
