using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p04_HornetArmada
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            var items = new Dictionary<string, Activity>();
            

            for (int i = 0; i < n; i++)
            {
                string[] input = Console.ReadLine().Split(new string[] { " = ", " -> ", ":" }, StringSplitOptions.RemoveEmptyEntries);
                long lastActivity = long.Parse(input[0]);
                string legionName = input[1];
                string soldierType = input[2];
                long soldierCount = long.Parse(input[3]);

                Dictionary<string, long> soldiers =
                    new Dictionary<string, long>();

                if (!soldiers.ContainsKey(soldierType))
                {
                    soldiers.Add(soldierType, soldierCount);
                }
                else
                {
                    soldiers[soldierType] += soldierCount;
                }
                

                Activity biggestActivity = new Activity { lastActivity = lastActivity, soldierType = soldiers};
                
                if (!items.ContainsKey(legionName))
                {
                    items.Add(legionName, biggestActivity);      
                }
                else
                {
                    if (!items[legionName].soldierType.ContainsKey(soldierType))
                    {
                        items[legionName].soldierType.Add(soldierType, soldierCount);  

                        if (lastActivity > items[legionName].lastActivity)
                        {
                            items[legionName].lastActivity = lastActivity;
                        }
                    }
                  
                    else
                    {
                        if (lastActivity > items[legionName].lastActivity)
                        {
                            items[legionName].lastActivity = lastActivity;
                        }

                        items[legionName].soldierType[soldierType] += soldierCount;
                    }
                }
            }

            string[] lastInput = Console.ReadLine().Split(new char[] { '\\' });
            if(lastInput.Length == 1)
            {
                string soldierSearch = lastInput[0];
                foreach (var item in items.Where(x => x.Value.soldierType.ContainsKey(soldierSearch)).OrderByDescending(x => x.Value.lastActivity))
                {
                    Console.WriteLine($"{item.Value.lastActivity} : {item.Key}");
                }
            }
            else
            {
                long activity = long.Parse(lastInput[0]);
                string soldierTypeSearch = lastInput[1];
                foreach (var item in items.Where(x => x.Value.lastActivity < activity).Where(y => y.Value.soldierType.ContainsKey(soldierTypeSearch)).OrderByDescending(x => x.Value.soldierType.Values.Sum()))
                {
                    Console.WriteLine($"{item.Key} -> {item.Value.soldierType.Values.Sum()}");
                }
            }
            
        }
    }
    public class Activity
    {
        public long lastActivity { get; set; }
        public Dictionary<string, long> soldierType = new Dictionary<string, long>();
    }

}
