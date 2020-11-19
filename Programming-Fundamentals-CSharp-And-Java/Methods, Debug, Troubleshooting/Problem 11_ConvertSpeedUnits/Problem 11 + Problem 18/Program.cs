using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem11_ConvertSpeedUnits
{
    class Program
    {
        static void Main(string[] args)
        {
            float distanceInMeters = float.Parse(Console.ReadLine());
            float hours = float.Parse(Console.ReadLine());
            float minutes = float.Parse(Console.ReadLine());
            float seconds = float.Parse(Console.ReadLine());

            float hourTime = hours + minutes / 60 + seconds / 3600;
            float secondsTime = seconds + minutes * 60 + hours * 3600;

            float metersPerSecond = distanceInMeters / secondsTime;
            float kilometersPerHour = distanceInMeters / 1000 / hourTime;
            float milesPerHour = distanceInMeters / 1609 / hourTime;

            Console.WriteLine(metersPerSecond);
            Console.WriteLine(kilometersPerHour);
            Console.WriteLine(milesPerHour);
        }
    }
}
