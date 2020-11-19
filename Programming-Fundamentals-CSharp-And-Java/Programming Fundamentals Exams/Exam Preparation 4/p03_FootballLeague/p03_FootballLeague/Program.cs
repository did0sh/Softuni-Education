using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p03_FootballLeague
{
    class Program
    {
        static void Main(string[] args)
        {

            Dictionary<string, List<int>> items = new Dictionary<string, List<int>>();
            string key = Console.ReadLine();

            string input = Console.ReadLine();

            while(input != "final")
            {
                string[] tokens = input.Split(' ');

                string decryptedHomeTeam = tokens[0];
                int firstIndex = decryptedHomeTeam.IndexOf(key);
                int lastIndex = decryptedHomeTeam.LastIndexOf(key);

                string homeTeam = decryptedHomeTeam.Substring(firstIndex + key.Length, lastIndex - firstIndex - key.Length);
                char[] homeTeamArray = homeTeam.ToUpper().ToCharArray();
                homeTeamArray = homeTeamArray.Reverse().ToArray();
                homeTeam = new string(homeTeamArray);

                string decryptedAwayTeam = tokens[1];
                firstIndex = decryptedAwayTeam.IndexOf(key);
                lastIndex = decryptedAwayTeam.LastIndexOf(key);

                string awayTeam = decryptedAwayTeam.Substring(firstIndex + key.Length, lastIndex - firstIndex - key.Length);
                char[] awayTeamArray = awayTeam.ToUpper().ToCharArray();
                awayTeamArray = awayTeamArray.Reverse().ToArray();
                awayTeam = new string(awayTeamArray);

                string[] goals = tokens[2].Split(':');
                int goalsHomeTeam = int.Parse(goals[0]);
                int goalsAwayTeam = int.Parse(goals[1]);

                int homeTeamPoints = 0;
                int awayTeamPoints = 0;

                if(goalsHomeTeam > goalsAwayTeam)
                {
                    homeTeamPoints = 3;
                }
                else if(goalsAwayTeam > goalsHomeTeam)
                {
                    awayTeamPoints = 3;
                }
                else
                {
                    homeTeamPoints = 1;
                    awayTeamPoints = 1;
                }

                if(!items.ContainsKey(homeTeam))
                {
                    items.Add(homeTeam, new List<int>());
                    items[homeTeam].Add(homeTeamPoints);
                    items[homeTeam].Add(goalsHomeTeam);
                }
                else
                {
                    items[homeTeam][0] += homeTeamPoints;
                    items[homeTeam][1] += goalsHomeTeam;
                }

                if (!items.ContainsKey(awayTeam))
                {
                    items.Add(awayTeam, new List<int>());
                    items[awayTeam].Add(awayTeamPoints);
                    items[awayTeam].Add(goalsAwayTeam);
                }
                else
                {
                    items[awayTeam][0] += awayTeamPoints;
                    items[awayTeam][1] += goalsAwayTeam;
                }


                input = Console.ReadLine();

            }

            Console.WriteLine("League standings:");
            int counter = 1;

            foreach (var item in items.OrderByDescending(x => x.Value[0]).ThenBy(x => x.Key))
            {
                Console.WriteLine("{0}. {1} {2}", counter, item.Key, item.Value[0]);
                counter++;
            }

            Console.WriteLine("Top 3 scored goals:");
            foreach (var item in items.OrderByDescending(x => x.Value[1]).ThenBy(x => x.Key).Take(3))
            {
                Console.WriteLine("- {0} -> {1}", item.Key, item.Value[1]);
            }
            
        }
    }
}
