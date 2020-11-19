using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p01_DayOfWeek
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            string[] tokens = input.Split('-');

            int day = int.Parse(tokens[0]);
            int month = int.Parse(tokens[1]);
            int year = int.Parse(tokens[2]);

            DateTime myDay = new DateTime(year, month, day);

            Console.WriteLine(myDay.DayOfWeek);
        }
    }
}
