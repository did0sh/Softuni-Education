using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p01_SplinterTrip
{
    class Program
    {
        static void Main(string[] args)
        {
            double tripDistance = double.Parse(Console.ReadLine());
            double fuelTankCapacity = double.Parse(Console.ReadLine());
            double milesInHeavyWinds = double.Parse(Console.ReadLine());

            double milesInNonHeavyWinds = tripDistance - milesInHeavyWinds;

            double nonHeavyWindsConsumption = milesInNonHeavyWinds * 25;
            double heavyWindsConsumption = milesInHeavyWinds * (25 * 1.5);

            double fuelConsumption = nonHeavyWindsConsumption + heavyWindsConsumption;
            double totalConsumption = fuelConsumption + 0.05 * fuelConsumption;

            if(fuelTankCapacity >= totalConsumption)
            {
                double fuelLeft = fuelTankCapacity - totalConsumption;
                Console.WriteLine($"Fuel needed: {totalConsumption:F2}L");
                Console.WriteLine($"Enough with {fuelLeft:F2}L to spare!");
            }
            else
            {
                double fuelLeft = Math.Abs(fuelTankCapacity - totalConsumption);
                Console.WriteLine($"Fuel needed: {totalConsumption:F2}L");
                Console.WriteLine($"We need {fuelLeft:F2}L more fuel.");
            }
        }
    }
}
