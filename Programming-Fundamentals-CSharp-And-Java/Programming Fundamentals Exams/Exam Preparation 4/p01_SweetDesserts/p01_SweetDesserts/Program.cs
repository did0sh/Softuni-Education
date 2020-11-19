using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p01_SweetDesserts
{
    class Program
    {
        static void Main(string[] args)
        {
            decimal budget = decimal.Parse(Console.ReadLine());
            int numberOfGuests = int.Parse(Console.ReadLine());
            decimal priceBananas = decimal.Parse(Console.ReadLine());
            decimal priceEggs = decimal.Parse(Console.ReadLine());
            decimal priceBerries = decimal.Parse(Console.ReadLine());

            int bananasNeeded = 2;
            int eggsNeeded = 4;
            decimal berriesNeeded = 0.2M;
            int portions = 0;

            if(numberOfGuests % 6 == 0)
            {
                 portions = numberOfGuests / 6;
            }
            else
            {
                portions = numberOfGuests / 6 + 1;
            }


            decimal moneyForAllProducts = portions * (bananasNeeded * priceBananas + eggsNeeded * priceEggs + berriesNeeded * priceBerries);

            
            if(budget < moneyForAllProducts)
            {
                decimal moneyNeeded = moneyForAllProducts - budget;
                Console.WriteLine($"Ivancho will have to withdraw money - he will need {moneyNeeded:F2}lv more.");
            }
            else if (budget >= moneyForAllProducts)
            {
                Console.WriteLine($"Ivancho has enough money - it would cost {moneyForAllProducts:F2}lv.");
            }

        }
    }
}
