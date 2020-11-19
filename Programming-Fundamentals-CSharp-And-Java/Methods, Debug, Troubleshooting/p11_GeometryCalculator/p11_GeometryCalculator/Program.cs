using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p11_GeometryCalculator
{
    class Program
    {
        static void Main(string[] args)
 
        {

            string type = Console.ReadLine();
            if (type == "triangle" || type == "rectangle")
            {
                double side = double.Parse(Console.ReadLine());
                double height = double.Parse(Console.ReadLine());
                TriangleAndRectangle(type, side, height);
            }
            else if (type == "circle" || type == "square")
            {
                double r = double.Parse(Console.ReadLine());
                SquareAndCircle(type, r);
            }


           
        }

        static void TriangleAndRectangle (string type , double side , double height)
        {
            double areaTriangle = 0;
            double areaRectangle = 0;
            if (type == "triangle")
            {
                areaTriangle = (side * height)/2;
                Console.WriteLine("{0:F2}", areaTriangle);
            }
            else if (type == "rectangle")
            {
                areaRectangle = side * height;
                Console.WriteLine("{0:F2}", areaRectangle);
            }

        }

        static void SquareAndCircle(string type, double r)
        {
            double areaSquare = 0;
            double areaCircle = 0;
            if (type == "square")
            {
                areaSquare = r * r;
                Console.WriteLine("{0:F2}", areaSquare);
            }
            else if (type == "circle")
            {
                areaCircle = Math.PI*r*r;
                Console.WriteLine("{0:F2}", areaCircle);
            }

        }

    }
}
