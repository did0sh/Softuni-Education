using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p03_HornetAssault
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> beehives = Console.ReadLine().Split(' ').Select(int.Parse).ToList();
            List<int> hornets = Console.ReadLine().Split(' ').Select(int.Parse).ToList();
            List<int> beesNotDead = new List<int>();

            int sumPower = 0;
            int beesAlive = 0;

            for (int k = 0; k < beehives.Count; k++)
            {
                if (hornets.Count == 0)
                {
                    break;
                }

                for (int i = 0; i < hornets.Count; i++)
                {
                    sumPower += hornets[i];
                }
                if (beehives[k] >= sumPower)
                {

                    hornets.RemoveAt(0);
                }
                beehives[k] -= sumPower;
                sumPower = 0;
            }

            foreach (var item in beehives)
            {
                if(item > 0)
                {
                    Console.Write(item + " ");
                }
                
            }

            if(beehives.Exists(a => a <= 0))
            {
                Console.WriteLine(string.Join(" ", hornets));
            }

        }
    }
}
