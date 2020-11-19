using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p03_IntersecitonOfCircles
{
    class Program
    {
        static void Main(string[] args)
        {

            Point firstCircle = ReadPoint(Console.ReadLine());
            Point secondCircle = ReadPoint(Console.ReadLine());

            double deltaX = Math.Abs(firstCircle.X - secondCircle.X);
            double deltaY = Math.Abs(firstCircle.Y - secondCircle.Y);

            double distance = Math.Sqrt(deltaX * deltaX + deltaY * deltaY);

            if(distance<= firstCircle.Radius + secondCircle.Radius)
            {
                Console.WriteLine("Yes");
            }
            else
            {
                Console.WriteLine("No");
            }
        }
        
        static Point ReadPoint(string input)
        {
            double[] arguments = input.Split(' ').Select(double.Parse).ToArray();
            return new Point() { X = arguments[0], Y = arguments[1], Radius = arguments[2] };
        }

    }
   
    class Point
    {
        public double X { get; set; }
        public double Y { get; set; }
        public double Radius { get; set; }
    }
}
