using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p02_CommandInterpreter
{
    class Program
    {
        static void Main(string[] args)
        {
            List<string> arrayOfStrings = Console.ReadLine().Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries).ToList();
            List<string> sorted = new List<string>();

            string input = Console.ReadLine();

            while (input != "end")
            {
                string[] tokens = input.Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);
                string command = tokens[0];

                if (command == "reverse")
                {
                    int start = int.Parse(tokens[2]);
                    int count = int.Parse(tokens[4]);

                    if (start < 0 || start >= arrayOfStrings.Count || count < 0 || start + count > arrayOfStrings.Count)
                    {
                        Console.WriteLine("Invalid input parameters.");
                        input = Console.ReadLine();
                        continue;
                    }
                    else
                    {
                        arrayOfStrings.Reverse(start, count);
                    }


                }
                else if (command == "sort")
                {
                    int start = int.Parse(tokens[2]);
                    int count = int.Parse(tokens[4]);

                    if (start < 0 || start >= arrayOfStrings.Count || count < 0 || start + count > arrayOfStrings.Count)
                    {
                        Console.WriteLine("Invalid input parameters.");
                        input = Console.ReadLine();
                        continue;
                    }
                    else
                    {
                        sorted = arrayOfStrings.Skip(start).Take(count).OrderBy(x => x).ToList();
                        arrayOfStrings.RemoveRange(start, count);
                        arrayOfStrings.InsertRange(start, sorted);
                    }

                }
                else if (command == "rollLeft")
                {
                    int count = int.Parse(tokens[1]);

                    if (count < 0)
                    {
                        Console.WriteLine("Invalid input parameters.");
                        input = Console.ReadLine();
                        continue;
                    }

                    count = count % arrayOfStrings.Count;
                    for (int i = 0; i < count; i++)
                    {
                        string temp = arrayOfStrings[0];
                        arrayOfStrings.RemoveAt(0);
                        arrayOfStrings.Add(temp);
                    }
                }
                else if (command == "rollRight")
                {
                    int count = int.Parse(tokens[1]);
                    if (count < 0)
                    {
                        Console.WriteLine("Invalid input parameters.");
                        input = Console.ReadLine();
                        continue;
                    }

                    count = count % arrayOfStrings.Count;
                    for (int i = 0; i < count; i++)
                    {
                        string temp = arrayOfStrings[arrayOfStrings.Count - 1];
                        arrayOfStrings.RemoveAt(arrayOfStrings.Count - 1);
                        arrayOfStrings.Insert(0, temp);
                    }
                }

                input = Console.ReadLine();
            }

            Console.WriteLine("[" + string.Join(", ", arrayOfStrings) + "]");
        }
    }
}
