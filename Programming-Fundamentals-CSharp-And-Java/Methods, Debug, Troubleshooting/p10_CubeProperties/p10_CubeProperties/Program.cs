using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Numerics;

namespace p10_CubeProperties
{
    class Program
    {
        static void Main(string[] args)
        {
            double side = double.Parse(Console.ReadLine());
            string type = Console.ReadLine();

            CubeProperties(side, type);
        }

        static void CubeProperties (double side , string type)
        {
            double faceDiagonals = 0;
            double spaceDiagonals = 0;
            double volume = 0;
            double area = 0;
            if (type == "face")
            {
                faceDiagonals = Math.Sqrt(2 * side * side);
                Console.WriteLine("{0:F2}", faceDiagonals);
            }
            else if (type == "space")
            {
                spaceDiagonals = Math.Sqrt(3 * Math.Pow(side, 2));
                Console.WriteLine("{0:F2}", spaceDiagonals);

            }
            else if (type == "volume")
            {
                volume = Math.Pow(side, 3);
                Console.WriteLine("{0:F2}", volume);
            }
            else if (type == "area")
            {
                area = 6* Math.Pow(side, 2);
                Console.WriteLine("{0:F2}", area);
            }

            

            
        }
    }
}
