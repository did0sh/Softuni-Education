using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p02_SoftuniKaraoke
{
    class Program
    {
        static void Main(string[] args)
        {
            List<string> namesOfParticipants = new List<string>();
            List<string> songNames = new List<string>();

            Dictionary<string, Dictionary<string, int>> contestantsAndAwards = new Dictionary<string, Dictionary<string, int>>();

            string firstInput = Console.ReadLine();
            string secondInput = Console.ReadLine();

            string[] contestantNames = firstInput.Trim().Split(new string[] { ", " }, StringSplitOptions.RemoveEmptyEntries);
            string[] songs = secondInput.Trim().Split(new string[] { ", " }, StringSplitOptions.RemoveEmptyEntries);

            for (int i = 0; i < contestantNames.Length; i++)
            {
                namesOfParticipants.Add(contestantNames[i]);
            }

            for (int j = 0; j < songs.Length; j++)
            {
                songNames.Add(songs[j]);
            }

            while (true)
            {
                string input = Console.ReadLine();
                if (input == "dawn")
                {
                    break;
                }

                string[] arguments = input.Trim().Split(new string[] { ", " }, StringSplitOptions.RemoveEmptyEntries);

                string name = arguments[0];
                string song = arguments[1];
                string award = arguments[2];

                if (namesOfParticipants.Contains(name) && songNames.Contains(song))
                {
                    if (!contestantsAndAwards.ContainsKey(name))
                    {
                        contestantsAndAwards.Add(name, new Dictionary<string, int>());
                        contestantsAndAwards[name].Add(award, 1);
                    }
                    else
                    {
                        if (!contestantsAndAwards[name].ContainsKey(award))
                        {
                            contestantsAndAwards[name].Add(award, 1);
                        }
                    }
                }
            }

            if(contestantsAndAwards.Count == 0)
            {
                Console.WriteLine("No awards");
            }

            foreach (var contestant in contestantsAndAwards.OrderByDescending(x => x.Value.Values.Sum()).ThenBy(y => y.Key))
            {
                Console.WriteLine($"{contestant.Key}: {contestant.Value.Values.Sum()} awards");
                foreach (var award in contestant.Value.OrderBy(x => x.Key))
                {
                    Console.WriteLine("--{0}", award.Key);
                }
            }
        }
    }
}
