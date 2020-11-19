using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem02
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            string[] tokens = input.Split(' ');
            List<string> names = new List<string>();
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < tokens.Length; i++)
            {
                names.Add(tokens[i]);
            }

            string secondInput = Console.ReadLine();

            while (secondInput != "3:1")
            {
                result = new StringBuilder();
                string[] data = secondInput.Split(' ');

                string command = data[0];

                if (command == "merge")
                {
                    int start = int.Parse(data[1]);
                    int end = int.Parse(data[2]);

                    if (start >= 0 && start <= names.Count - 1 && end >= 0 && end <= names.Count - 1)
                    {
                        for (int i = start; i <= end; i++)
                        {
                            result.Append(names[i]);
                        }
                        names[start] = result.ToString();
                        names.RemoveRange(start + 1, end - start);
                    }
                    else if (start >= 0 && start <= names.Count - 1 && end > names.Count - 1)
                    {
                        for (int i = start; i < names.Count; i++)
                        {
                            result.Append(names[i]);
                        }
                        names[start] = result.ToString();
                        names.RemoveRange(start + 1, names.Count - (start + 1));
                    }
                    else if (end >= 0 && end <= names.Count - 1 && start < 0)
                    {
                        for (int i = 0; i <= end; i++)
                        {
                            result.Append(names[i]);
                        }
                        names[0] = result.ToString();
                        names.RemoveRange(1, end);
                    }
                    else if (end > names.Count - 1 && start < 0)
                    {
                        for (int i = 0; i < names.Count; i++)
                        {
                            result.Append(names[i]);
                        }
                        names[0] = result.ToString();
                        names.RemoveRange(1, names.Count - 1);
                    }
                    else
                    {
                        secondInput = Console.ReadLine();
                        continue;
                    }
                   
                }
                

                else if(command == "divide")
                {
                    List<string> partStrings = new List<string>();
                    int index = int.Parse(data[1]);
                    int parts = int.Parse(data[2]);

                    string currenString = names[index];
                    
                    if(parts != 0)
                    {
                        int rotations = currenString.Length / parts;

                        for (int i = 0; i < parts; i++)
                        {
                            for (int k = 0; k < rotations; k++)
                            {
                                result.Append(currenString[k]);

                            }
                            partStrings.Add(result.ToString());
                            result = new StringBuilder();

                            currenString = currenString.Substring(rotations);
                        }

                        names.RemoveAt(index);
                        if (currenString.Length != 0)
                        {
                            partStrings.Add(currenString);
                        }

                        names.InsertRange(index, partStrings);
                    }
                   

                }

                secondInput = Console.ReadLine();
            }
            Console.WriteLine(string.Join(" ", names));
        }
    }
}

