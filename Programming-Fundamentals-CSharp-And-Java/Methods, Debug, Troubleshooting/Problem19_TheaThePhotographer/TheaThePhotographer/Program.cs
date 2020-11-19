using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TheaThePhotographer
{
    class Program
    {
        static void Main(string[] args)
        {
            long picturesTaken = long.Parse(Console.ReadLine());
            long filterTime = long.Parse(Console.ReadLine());
            long filterFactorPercentage = long.Parse(Console.ReadLine());
            long uploadTime = long.Parse(Console.ReadLine());

            long approvedPictures = (long) Math.Ceiling((picturesTaken * filterFactorPercentage) / 100.0);
            long totalTimeInSeconds = (picturesTaken * filterTime + approvedPictures * uploadTime);

            TimeSpan time = TimeSpan.FromSeconds(totalTimeInSeconds);
            string totaltime = time.ToString(@"d\:hh\:mm\:ss");

            Console.WriteLine(totaltime);

        }
    }
}
