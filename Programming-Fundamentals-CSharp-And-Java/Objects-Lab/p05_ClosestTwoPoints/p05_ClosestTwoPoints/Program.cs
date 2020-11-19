using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _05.Closest_Two_Points
{
    class Program
    {
        static void Main(string[] args)
        {
            int pointsCount = int.Parse(Console.ReadLine());
            Point[] pointsArray = new Point[pointsCount];

            for (int i = 0; i < pointsCount; i++)
            {
                pointsArray[i] = ReadPoint(Console.ReadLine());
            }

            Point[] closestPoints = FindClosestTwoPoints(pointsArray);
            foreach (Point point in closestPoints)
            {
                Console.WriteLine("({0}, {1})", point.X, point.Y);
            }
        }

        static Point ReadPoint (string input)
        {
            int[] coordinates = input.Split(' ').Select(int.Parse).ToArray();
            return new Point() { X = coordinates[0], Y = coordinates[1] };
        }

        static double CalcDistance (Point p1, Point p2)
        {
            int deltaX = p1.X - p2.X;
            int deltaY = p1.Y - p2.Y;

            double distance = Math.Sqrt(deltaX * deltaX + deltaY * deltaY);
            return distance;
        }

        static Point[] FindClosestTwoPoints(Point[] array)
        {
            Point[] closestPoints = new Point[2];
            double minimalDistance = double.MaxValue;

            for (int i = 0; i < array.Length; i++)
            {
                for (int j = i+1; j < array.Length; j++)
                {
                    CalcDistance(array[i], array[j]);

                    if(CalcDistance(array[i], array[j]) < minimalDistance)
                    {
                        minimalDistance = CalcDistance(array[i], array[j]);
                        closestPoints[0] = array[i];
                        closestPoints[1] = array[j];
                    }
                }
            }

            Console.WriteLine("{0:F3}", minimalDistance);
            return closestPoints;
        }
    }

    class Point
    {
        public int X { get; set; }
        public int Y { get; set; }
    }
}