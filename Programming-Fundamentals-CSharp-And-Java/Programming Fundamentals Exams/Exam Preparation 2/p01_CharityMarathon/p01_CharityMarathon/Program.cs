using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p01_CharityMarathon
{
    class Program
    {
        static void Main(string[] args)
        {
            int marathonDuration = int.Parse(Console.ReadLine());
            long numberOfRunners = long.Parse(Console.ReadLine());
            int numberOfLaps = int.Parse(Console.ReadLine());
            long lapLength = long.Parse(Console.ReadLine());
            int capacity = int.Parse(Console.ReadLine());
            double moneyDonatedPerKilometer = double.Parse(Console.ReadLine());

            long maximumCapacity = capacity * marathonDuration;

            if(maximumCapacity < numberOfRunners)
            {
                numberOfRunners = maximumCapacity;
            }

            long totalMeters = numberOfRunners * numberOfLaps * lapLength;
            long totalKilometers = totalMeters / 1000;
            double moneyRaised = totalKilometers * moneyDonatedPerKilometer;


            Console.WriteLine("Money raised: {0:F2}", moneyRaised);
        }
    }
}
