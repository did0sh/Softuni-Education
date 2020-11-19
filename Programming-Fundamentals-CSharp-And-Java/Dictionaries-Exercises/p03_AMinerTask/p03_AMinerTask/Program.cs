using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p03_AMinerTask
{
    class Program
    {
        static void Main(string[] args)
        {
            

            Dictionary<string, long> results = new Dictionary<string, long>();

           

            while (true)
            {
                string input = Console.ReadLine();                

                if (input == "stop")
                {
                    
                    break;
                }

                long num = long.Parse(Console.ReadLine());

                if (results.ContainsKey(input))
                {
                    results[input] = results[input] + num;
                }
                else
                {      
                    results.Add(input, num);
                } 
                
            }


            foreach (var pair in results)
            {
                Console.WriteLine("{0} -> {1}", pair.Key, pair.Value);
            }

        }
    }
}
