using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p01_HornetWings
{
    class Program
    {
        static void Main(string[] args)
        {
            long wingFlaps = long.Parse(Console.ReadLine());
            double distanceForThousandWingFlaps = double.Parse(Console.ReadLine());
            long endurance = long.Parse(Console.ReadLine());

            double totalDistance = (wingFlaps / 1000.00) * distanceForThousandWingFlaps;
            long totalSeconds = (wingFlaps / 100) + ((wingFlaps / endurance) * 5);

            Console.WriteLine($"{totalDistance:F2} m.");
            Console.WriteLine($"{totalSeconds} s.");
        }
    }
}
