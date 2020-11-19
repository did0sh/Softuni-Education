using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p10_SrabskoUnleashed
{
    class Program
    {
        static void Main(string[] args)
        {
            var items = new Dictionary<string, Dictionary<string, long>>();

            string input = Console.ReadLine();


            while(input != "End")
            {

                if(!input.Contains(" @"))
                {
                    input = Console.ReadLine();
                    continue;
                }

                string[] token = input.Split(new string[] { " @" }, StringSplitOptions.RemoveEmptyEntries);

                string singerName = token[0];
                List<string> concertInfo = token[1].Split(' ').ToList();

                long ticketsCount;
                long ticketsPrice;

                bool ticketsCountAreNumbers = long.TryParse(concertInfo[concertInfo.Count - 1], out ticketsCount);
                bool ticketsPriceAreNumbers = long.TryParse(concertInfo[concertInfo.Count - 2], out ticketsPrice);

                if(!ticketsCountAreNumbers || !ticketsPriceAreNumbers)
                {
                    input = Console.ReadLine();
                    continue;
                }


                long totalMoney = ticketsCount * ticketsPrice;

                concertInfo.RemoveRange(concertInfo.Count - 2, 2);

                string venue = string.Join(" ", concertInfo);



                if (!items.ContainsKey(venue))
                {
                    items.Add(venue, new Dictionary<string, long>());
                    items[venue].Add(singerName, totalMoney);
                }
                else
                {
                    if (!items[venue].ContainsKey(singerName))
                    {
                        items[venue].Add(singerName, totalMoney);
                    }
                    else
                    {
                        items[venue][singerName] += totalMoney;
                    }
                }
                                      
                input = Console.ReadLine();
            }

            foreach (var item in items)
            {
                Console.WriteLine(item.Key);
                foreach (var element in item.Value.OrderByDescending(x => x.Value))
                {
                    Console.Write("#  ");
                    Console.WriteLine(string.Join(" -> ", element.Key, element.Value));
                }
            }

        }
    }
}
