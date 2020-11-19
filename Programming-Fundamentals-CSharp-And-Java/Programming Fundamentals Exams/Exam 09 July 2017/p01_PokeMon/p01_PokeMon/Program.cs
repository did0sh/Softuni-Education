using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p01_PokeMon
{
    class Program
    {
        static void Main(string[] args)
        {
            int pokePower = int.Parse(Console.ReadLine());
            int distance = int.Parse(Console.ReadLine());
            int exhaustionFactor = int.Parse(Console.ReadLine());

            int count = 0;

            int originalValuePokePower = pokePower;

            while(pokePower >= distance)
            {
                count++;
                pokePower = pokePower - distance;
                double fiftyPercent = originalValuePokePower * 0.5;

                if(pokePower == fiftyPercent && exhaustionFactor != 0)
                {
                    pokePower = pokePower / exhaustionFactor;
                }
                else
                {
                    continue;
                }
            }

            Console.WriteLine(pokePower);
            Console.WriteLine(count);
        }
    }
}
