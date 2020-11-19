using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Numerics;

namespace Problem01
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int securityToken = int.Parse(Console.ReadLine());

            List<string> allNames = new List<string>();
            decimal total = 0;

            for (int i = 0; i < n; i++)
            {
                string input = Console.ReadLine();
                string[] tokens = input.Split(' ');

                string siteName = tokens[0];
                long siteVisits = long.Parse(tokens[1]);
                decimal pricePerVisit = decimal.Parse(tokens[2]);

                allNames.Add(siteName);

                decimal siteLoss = (siteVisits * pricePerVisit);
                total += siteLoss;

            }

            for (int k = 0; k < allNames.Count; k++)
            {
                Console.WriteLine(allNames[k]);
            }

            Console.WriteLine($"Total Loss: {total:F20}");


            BigInteger securityPow = BigInteger.Pow(securityToken, allNames.Count);
            Console.WriteLine($"Security Token: {securityPow}");


        }
    }
}
