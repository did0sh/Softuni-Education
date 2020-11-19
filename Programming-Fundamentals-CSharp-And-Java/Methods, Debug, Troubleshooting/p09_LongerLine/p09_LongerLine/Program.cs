using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p09_LongerLine
{
    class Program
    {
        static void Main(string[] args)
        {
            double x1 = double.Parse(Console.ReadLine());
            double y1 = double.Parse(Console.ReadLine());
            double x2 = double.Parse(Console.ReadLine());
            double y2 = double.Parse(Console.ReadLine());
            double x3 = double.Parse(Console.ReadLine());
            double y3 = double.Parse(Console.ReadLine());
            double x4 = double.Parse(Console.ReadLine());
            double y4 = double.Parse(Console.ReadLine());

            double firstCoordinates = CalculateDistance(x1, y1, x2, y2);
      
            double secondCoordinates = CalculateDistance(x3, y3, x4, y4);
           

            if(firstCoordinates >= secondCoordinates)
            {
                ClosestPoint(x1, y1, x2, y2);
            }
            else
            {
                ClosestPoint(x3, y3, x4, y4);
            }



  

        }



        static double CalculateDistance(double x1, double y1, double x2, double y2)
        {
            double distance = Math.Sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
            return distance;
        }

        static void ClosestPoint (double x1, double y1, double x2, double y2)
        {
            double first = Math.Sqrt(Math.Pow(x1, 2) + Math.Pow(y1, 2));
            double second = Math.Sqrt(Math.Pow(x2, 2) + Math.Pow(y2, 2));

            if (first <= second)
            {
                Console.WriteLine($"({x1}, {y1})({x2}, {y2})");
            }
            else
            {
                Console.WriteLine($"({x2}, {y2})({x1}, {y1})");
            }
        }
    }
}
