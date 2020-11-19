using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p02_ArrayManipulator
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] input = Console.ReadLine().Trim().Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries).Select(int.Parse).ToArray();
            List<int> numbers = new List<int>();

            for (int i = 0; i < input.Length; i++)
            {
                numbers.Add(input[i]);
            }

            string commandInput = Console.ReadLine();

            while(commandInput != "end")
            {
                string[] tokens = commandInput.Split(' ');
                string command = tokens[0];

                if(command == "exchange")
                {
                    int exchangeIndex = int.Parse(tokens[1]);
                   
                    if(exchangeIndex > numbers.Count - 1)
                    {
                        Console.WriteLine("Invalid index");
                    }
                    else
                    {
                        for (int j = 0; j <= exchangeIndex; j++)
                        {
                            int temp = numbers[0];
                            numbers.RemoveAt(0);
                            numbers.Add(temp);
                        }
                    }
                    
                }
                else if (command == "max")
                {
                    if(tokens[1] == "odd")
                    {
                        int biggesOdd = int.MinValue;
                        for (int k = 0; k < numbers.Count; k++)
                        {
                            if(numbers[k] % 2 == 1 && numbers[k] > biggesOdd)
                            {
                                biggesOdd = numbers[k];
                            }
                        }

                        if(biggesOdd == int.MinValue)
                        {
                            Console.WriteLine("No matches");
                        }
                        else
                        {
                            Console.WriteLine(numbers.LastIndexOf(biggesOdd));
                        }
                    }

                    else if (tokens[1] == "even")
                    {
                        int biggesEven = int.MinValue;
                        for (int k = 0; k < numbers.Count; k++)
                        {
                            if (numbers[k] % 2 == 0 && numbers[k] > biggesEven)
                            {
                                biggesEven = numbers[k];
                            }
                        }

                        if (biggesEven == int.MinValue)
                        {
                            Console.WriteLine("No matches");
                        }
                        else
                        {
                            Console.WriteLine(numbers.LastIndexOf(biggesEven));
                        }
                    }
                }

                else if (command == "min")
                {
                    if (tokens[1] == "odd")
                    {
                        int minOdd = int.MaxValue;
                        for (int k = 0; k < numbers.Count; k++)
                        {
                            if (numbers[k] % 2 == 1 && numbers[k] < minOdd)
                            {
                                minOdd = numbers[k];
                            }
                        }

                        if (minOdd == int.MaxValue)
                        {
                            Console.WriteLine("No matches");
                        }
                        else
                        {
                            Console.WriteLine(numbers.LastIndexOf(minOdd));
                        }
                    }

                    else if (tokens[1] == "even")
                    {
                        int minEven = int.MaxValue;
                        for (int k = 0; k < numbers.Count; k++)
                        {
                            if (numbers[k] % 2 == 0 && numbers[k] < minEven)
                            {
                                minEven = numbers[k];
                            }
                        }

                        if (minEven == int.MaxValue)
                        {
                            Console.WriteLine("No matches");
                        }
                        else
                        {
                            Console.WriteLine(numbers.LastIndexOf(minEven));
                        }
                    }
                }
       
                else if (command == "first")
                {
                    int count = int.Parse(tokens[1]);
                    if (count > numbers.Count || count < 0)
                    {
                        Console.WriteLine("Invalid count");
                        commandInput = Console.ReadLine();
                        continue;
                    }
        

                    List<int> evenNums = new List<int>();
                    if(tokens[2] == "even")
                    {
                        for (int i = 0; i < numbers.Count; i++)
                        {
                            if(numbers[i] % 2 == 0)
                            {
                                evenNums.Add(numbers[i]);
                                if(evenNums.Count == count)
                                {
                                    break;
                                }
                            }
                        }

                        if (evenNums.Count == 0)
                        {
                            Console.WriteLine("[]");
                        }
                        else
                        {
                            Console.WriteLine("[" + string.Join(", ", evenNums) + "]");
                        }
                        
                    }
                    else if (tokens[2] == "odd")
                    {
                        List<int> oddNums = new List<int>();
                        for (int i = 0; i < numbers.Count; i++)
                        {
                            if (numbers[i] % 2 == 1)
                            {
                                oddNums.Add(numbers[i]);
                                if (oddNums.Count == count)
                                {
                                    break;
                                }
                            }
                        }

                        if (oddNums.Count == 0)
                        {
                            Console.WriteLine("[]");
                        }
                        else
                        {
                            Console.WriteLine("[" + string.Join(", ", oddNums) + "]");
                        }
                    }
                }

                else if(command == "last")
                {
                    int count = int.Parse(tokens[1]);

                    if(count > numbers.Count || count < 0)
                    {
                        Console.WriteLine("Invalid count");
                        commandInput = Console.ReadLine();
                        continue;
                    }

                    List<int> evenNums = new List<int>();
                    if (tokens[2] == "even")
                    {
                        for (int i = numbers.Count - 1; i >= 0; i--)
                        {
                            if (numbers[i] % 2 == 0)
                            {
                                evenNums.Add(numbers[i]);
                                if (evenNums.Count == count)
                                {
                                    break;
                                }
                            }
                        }

                        if (evenNums.Count == 0)
                        {
                            Console.WriteLine("[]");
                        }
                        else
                        {
                            List<int> reversed = new List<int>();
                            evenNums.Reverse();
                            reversed.AddRange(evenNums);
                            Console.WriteLine("[" + string.Join(", ", reversed) + "]");
                        }
                        
                    }
                    else if (tokens[2] == "odd")
                    {
                        List<int> oddNums = new List<int>();
                        for (int i = numbers.Count - 1; i >= 0; i--)
                        {
                            if (numbers[i] % 2 == 1)
                            {
                                oddNums.Add(numbers[i]);
                                if (oddNums.Count == count)
                                {
                                    break;
                                }
                            }
                        }

                        if (oddNums.Count == 0)
                        {
                            Console.WriteLine("[]");
                        }
                        else
                        {
                            List<int> reversed = new List<int>();
                            oddNums.Reverse();
                            reversed.AddRange(oddNums);
                            Console.WriteLine("[" + string.Join(", ", reversed) + "]");
                        }
                       
                    }
                }

                commandInput = Console.ReadLine();

            }

            Console.WriteLine("[" + string.Join(", ", numbers) + "]");
        }
    }
}
