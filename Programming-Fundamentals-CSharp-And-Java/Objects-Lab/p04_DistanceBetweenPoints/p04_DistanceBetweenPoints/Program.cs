using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p04_DistanceBetweenPoints
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] firstLine = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
            int[] secondLine = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();

            int x1 = firstLine[0];
            int y1 = firstLine[1];

            int x2 = secondLine[0];
            int y2 = secondLine[1];

            double deltaX = Math.Abs(x1 - x2);
            double deltaY = Math.Abs(y1 - y2);

            double distance = Math.Sqrt(deltaX * deltaX + deltaY * deltaY);

            Console.WriteLine("{0:F3}", distance);
        }
    }
}
