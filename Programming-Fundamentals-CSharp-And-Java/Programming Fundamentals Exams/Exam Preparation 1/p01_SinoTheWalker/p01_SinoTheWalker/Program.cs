using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p01_SinoTheWalker
{
    class Program
    {
        static void Main(string[] args)
        {
            string leaveTime = Console.ReadLine();
            long numberOfSteps = long.Parse(Console.ReadLine());
            long secondsForEachStep = long.Parse(Console.ReadLine());

            string[] tokens = leaveTime.Split(':');

            long hours = int.Parse(tokens[0]);
            long minutes = int.Parse(tokens[1]);
            long seconds = int.Parse(tokens[2]);

            long totalTimeInSeconds = secondsForEachStep * numberOfSteps;

            if (totalTimeInSeconds >= 60)
            {
                minutes += totalTimeInSeconds / 60;
                seconds += totalTimeInSeconds % 60;
            }
            else
            {
                seconds += totalTimeInSeconds;
            }

            if(seconds >= 60)
            {
                minutes += seconds / 60;
                seconds = seconds % 60;
            }

            if(minutes >= 60)
            {
                hours += minutes / 60;
                minutes = minutes % 60;
            }

            if(hours > 23)
            {
                hours = hours % 24;
            }

            Console.WriteLine("Time Arrival: {0:D2}:{1:D2}:{2:D2}", hours, minutes,seconds);
        }
    }
}
