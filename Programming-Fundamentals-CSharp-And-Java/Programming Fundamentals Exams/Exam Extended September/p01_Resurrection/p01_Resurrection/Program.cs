using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p01_Resurrection
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            for (int i = 0; i < n; i++)
            {
                long totalLengthBody = long.Parse(Console.ReadLine());
                decimal totalWidthBody = decimal.Parse(Console.ReadLine());
                long lengthOfWing = long.Parse(Console.ReadLine());

                decimal totalYears = (decimal)(Math.Pow(totalLengthBody, 2)) * (totalWidthBody + 2 * (lengthOfWing));
                Console.WriteLine(totalYears);
            }
        }
    }
}
