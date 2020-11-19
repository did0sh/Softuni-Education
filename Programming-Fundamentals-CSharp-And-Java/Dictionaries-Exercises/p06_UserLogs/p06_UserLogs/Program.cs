using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p06_UserLogs
{
    class Program
    {
        static void Main(string[] args)
        {
            var userIPs = new SortedDictionary<string, Dictionary<string, int>>();
            string input = Console.ReadLine();

            while(input != "end")
            {
                var token = input.Split(' ');

                var ip = token[0].Split('=')[1];
                var username = token[2].Split('=')[1];

                if (!userIPs.ContainsKey(username))
                {
                    userIPs.Add(username, new Dictionary<string, int>());
                }

                if (!userIPs[username].ContainsKey(ip))
                {
                    userIPs[username].Add(ip, 0);
                }

                userIPs[username][ip]++;
                input = Console.ReadLine();
            }

            foreach (var item in userIPs)
            {
                Console.WriteLine(item.Key + ":");
                Console.WriteLine(string.Join(", ", item.Value.Select(x => $"{x.Key} => {x.Value}"))+".");
            }


        }

    }
}
