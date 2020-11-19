using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p01_Phonebook
{
    class Program
    {
        static void Main(string[] args)
        {
            List<string> names = Console.ReadLine().Split(' ').ToList();

            Dictionary<string, string> results = new Dictionary<string, string>();

            string[] temp = new string[1];
            

            

            

            while (names[0] != "END")
            {

                string action = names[0];
                   

                if (action == "A")
                {
                    temp[0] = names[2];                   
                   names = names.Skip(1).Take(1).ToList();

                    foreach (var name in names)
                    {
                        if (results.ContainsKey(name))
                        {
                            results[name] = temp[0];
                        }
                        else
                        {
                            results.Add(name, temp[0]);
                        }
                    }
                }
                
                 




                if (action == "S")
                {
                    names.RemoveAt(0);

                    foreach (var name in names)
                    {
                        if (results.ContainsKey(name))
                        {

                            Console.WriteLine("{0} -> {1}", name, results[name]);
                        }
                        else
                        {
                            Console.WriteLine("Contact {0} does not exist.", name);
                        }
                    }
                }


                names = Console.ReadLine().Split(' ').ToList();

            }
        }
    }
}
