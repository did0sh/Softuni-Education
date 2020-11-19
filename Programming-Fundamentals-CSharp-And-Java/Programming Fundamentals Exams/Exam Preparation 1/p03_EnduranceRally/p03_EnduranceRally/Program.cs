using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p03_EnduranceRally
{
    class Program
    {
        static void Main(string[] args)
        {
            string firstInput = Console.ReadLine();
            string secondInput = Console.ReadLine();
            string thirdInput = Console.ReadLine();

            string[] names = firstInput.Split(' ');
            double[] zones = secondInput.Split(' ').Select(double.Parse).ToArray();
            List<int> checkpoints = thirdInput.Split(' ').Select(int.Parse).ToList();

            for (int i = 0; i < names.Length; i++)
            {
                string currentName = names[i];
                string firstLetter = currentName.Substring(0, 1);
                double startingFuel = 0;
                

                foreach (char characters in firstLetter)
                {
                    startingFuel = (int)characters;
                }

                for (int j = 0; j < zones.Length; j++)
                {
                    if (checkpoints.Contains(j))
                    {
                        startingFuel += zones[j];
                    }
                    else
                    {
                        startingFuel -= zones[j];
                    }

                    
                    if(startingFuel <= 0)
                    {
                        Console.WriteLine("{0} - reached {1}", currentName, j);
                        break;
                    }
                }

                if(startingFuel > 0)
                {
                    Console.WriteLine("{0} - fuel left {1:F2}", currentName, startingFuel);
                }
                

            }

        }
    }
}
