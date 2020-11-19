using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p04_FixEmails
{
    class Program
    {
        static void Main(string[] args)
        {
            Dictionary<string, string> namesAndEmails = new Dictionary<string, string>();

           

            while (true)
            {
                string name = Console.ReadLine();

                if(name == "stop")
                {
                    break;
                }

                string email = Console.ReadLine();

                string[] emailProperties = email.Split('.').ToArray();
                string domein = emailProperties[1];

                if(domein != "us" && domein != "uk")
                {
                    namesAndEmails.Add(name, email);
                }

            }

            

            foreach (var item in namesAndEmails)
            {
                Console.WriteLine("{0} -> {1}", item.Key, item.Value);
            }

        }
    }
}
