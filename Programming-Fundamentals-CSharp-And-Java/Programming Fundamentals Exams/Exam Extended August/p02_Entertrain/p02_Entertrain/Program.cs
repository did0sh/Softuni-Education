using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p02_Entertrain
{
    class Program
    {
        static void Main(string[] args)
        {
            int locomotivePower = int.Parse(Console.ReadLine());
            List<int> wagons = new List<int>();

            int numToRemove = 0;

            while (true)
            {
                string input = Console.ReadLine();
                if (input == "All ofboard!")
                {
                    break;
                }
                else
                {
                    wagons.Add(int.Parse(input));
                }

                int closestNum = int.MaxValue;


                if (wagons.Sum() > locomotivePower)
                {
                    int average = wagons.Sum() / wagons.Count;
                    for (int i = 0; i < wagons.Count; i++)
                    {
                        int substractCurrNum = Math.Abs(wagons[i] - average);
                        if (substractCurrNum < closestNum)
                        {
                            closestNum = substractCurrNum;
                            numToRemove = wagons[i];
                        }
                    }
                    wagons.Remove(numToRemove);
                }

            }

            
            wagons.Insert(0, locomotivePower);
            wagons.Reverse();

            Console.WriteLine(string.Join(" ", wagons));

        }
    }
}
