using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p08_LogsAggregator
{
    class Program
    {
        static void Main(string[] args)
        {
            var items = new SortedDictionary<string, SortedDictionary<string, int>>();

            int n = int.Parse(Console.ReadLine());

            for (int i = 0; i < n; i++)
            {

                string input = Console.ReadLine();

                string[] token = input.Split(' ');

                string ip = token[0];
                string userName = token[1];
                int duration = int.Parse(token[2]);

                if (!items.ContainsKey(userName))
                {
                    items.Add(userName, new SortedDictionary<string, int>());         
                }

                if (!items[userName].ContainsKey(ip))
                {
                    items[userName].Add(ip, duration);
                }
                else
                {
                    items[userName][ip] += duration;
                }
         
            }

            foreach (var user in items)
            {
                Console.Write($"{user.Key}: {user.Value.Values.Sum()} ");
                Console.Write("[");
                Console.Write(string.Join(", ", user.Value.Keys));
                Console.WriteLine("]");   
            }
        }
    }
}
