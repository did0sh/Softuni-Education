using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p04_RoliTheCoder
{
    class Program
    {
        static void Main(string[] args)

        {
            string input = Console.ReadLine();
            Dictionary<int, Event> results = new Dictionary<int, Event>();

            while (input != "Time for Code")
            {
                string[] tokens = input.Split(' ');
                int id = int.Parse(tokens[0]);
                string eventName = tokens[1];

                if (!eventName.Contains('#'))
                {
                    input = Console.ReadLine();
                    continue;
                }


                string currEvent = eventName.Substring(1, eventName.Length - 1);
                Event currentEvent = new Event { Name = currEvent };

                if (!results.ContainsKey(id))
                {
                    results.Add(id, currentEvent);
                    for (int j = 2; j < tokens.Length; j++)
                    {
                        if (results[id].participants.Contains(tokens[j]) || !tokens[j].Contains('@'))
                        {
                            continue;
                        }
                        else
                        {
                            results[id].participants.Add(tokens[j]);
                        }

                    }


                }
                else if (results.ContainsKey(id) && results[id].Name != currEvent)
                {
                    input = Console.ReadLine();
                    continue;
                }
                else if (results.ContainsKey(id) && results[id].Name == currEvent)
                {
                    for (int j = 2; j < tokens.Length; j++)
                    {
                        if (results[id].participants.Contains(tokens[j]) || !tokens[j].Contains('@'))
                        {
                            continue;
                        }
                        else
                        {
                            results[id].participants.Add(tokens[j]);
                        }
                    }
                }



                input = Console.ReadLine();

            }


            results = results.OrderByDescending(x => x.Value.participants.Count()).ThenBy(x => x.Value.Name).ToDictionary(x => x.Key, x => x.Value);
            foreach (var item in results.Values)
            {
                Console.WriteLine($"{item.Name} - {item.participants.Count()}");
                foreach (var participant in item.participants.OrderBy(x => x))
                {

                    Console.WriteLine($"{participant}");
                }


            }
        }
    }
    class Event
    {
        public string Name { get; set; }
        public List<string> participants = new List<string>();

    }
}
