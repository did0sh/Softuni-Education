using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Globalization;

namespace p01_SoftuniCoffeOrders
{
    class Program
    {
        static void Main(string[] args)
        {
            int orders = int.Parse(Console.ReadLine());
            decimal totalPrice = 0;
            for (int i = 0; i < orders; i++)
            {
                decimal pricePerCapsule = decimal.Parse(Console.ReadLine());

                string[] orderDate = Console.ReadLine().Split('/');
                int year = int.Parse(orderDate[2]);
                int month = int.Parse(orderDate[1]);

                int daysInMonth = DateTime.DaysInMonth(year, month);
                long capsulesCount = long.Parse(Console.ReadLine());

                decimal orderPrice = (daysInMonth * capsulesCount) * pricePerCapsule;
                totalPrice += orderPrice;

                Console.WriteLine($"The price for the coffee is: ${orderPrice:F2}");
            }

            Console.WriteLine($"Total: ${totalPrice:F2}");
        }
    }
}
