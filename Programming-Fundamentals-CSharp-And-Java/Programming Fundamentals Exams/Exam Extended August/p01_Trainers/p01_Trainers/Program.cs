using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p01_Trainers
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            double sumTechnical = 0;
            double sumPractical = 0;
            double sumTheoretical = 0;

            for (int i = 0; i < n; i++)
            {
                long distanceInMiles = long.Parse(Console.ReadLine());
                double cargoInTons = double.Parse(Console.ReadLine());
                string team = Console.ReadLine();

                double cargoInKilograms = cargoInTons * 1000;
                long distanceInMeters = distanceInMiles * 1600;

                var participantEarnedMoney = (cargoInKilograms * 1.5) - (0.7 * distanceInMeters * 2.5);

                if(team == "Technical")
                {
                    sumTechnical += participantEarnedMoney;
                }
                else if (team == "Practical")
                {
                    sumPractical += participantEarnedMoney;
                }
                else if (team == "Theoretical")
                {
                    sumTheoretical += participantEarnedMoney;
                }
            }

            if(sumTechnical > sumPractical && sumTechnical > sumTheoretical)
            {
                Console.WriteLine($"The Technical Trainers win with ${sumTechnical:F3}.");
            }
            else if(sumPractical > sumTechnical && sumPractical > sumTheoretical)
            {
                Console.WriteLine($"The Practical Trainers win with ${sumPractical:F3}.");
            }
            else if (sumTheoretical > sumPractical && sumTheoretical > sumTechnical)
            {
                Console.WriteLine($"The Theoretical Trainers win with ${sumTheoretical:F3}.");
            }   
        }
    }
}
