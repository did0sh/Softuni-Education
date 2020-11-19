using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p04_TrainLands
{
    class Program
    {
        static void Main(string[] args)
        {

            var items = new Dictionary<string, List<Wagon>>();
            string input = Console.ReadLine();
            Dictionary<string, List<Wagon>> removed = new Dictionary<string, List<Wagon>>();

            while (input != "It's Training Men!")
            {
                string[] tokens = input.Split(new string[] { " -> ", " : " }, StringSplitOptions.RemoveEmptyEntries);
                if(tokens.Length == 3)
                {
                    string trainName = tokens[0];
                    string wagonName = tokens[1];
                    int wagonPower = int.Parse(tokens[2]);

                    Wagon wagon = new Wagon { WagonName = wagonName, WagonPower = wagonPower };

                    if (!items.ContainsKey(trainName))
                    {
                        items.Add(trainName, new List<Wagon>());
                        items[trainName].Add(wagon);
                    }
                    else
                    {
                        items[trainName].Add(wagon);
                    }
                }
                else if(tokens.Length == 2)
                {
                    string trainName = tokens[0];
                    string otherTrainName = tokens[1];

                    if (!items.ContainsKey(trainName))
                    {
                        items.Add(trainName, new List<Wagon>());
                        foreach (var item in items[otherTrainName])
                        {
                            items[trainName].Add(item);
                        }

                        
                        foreach (var item in items.Where(x => x.Key != otherTrainName))
                        {
                            removed.Add(item.Key, item.Value);
                        }

                        items = removed;
                    }
                    else
                    {
                        foreach (var item in items[otherTrainName])
                        {
                            items[trainName].Add(item);
                        }

                        foreach (var item in items.Where(x => x.Key != otherTrainName))
                        {
                            removed.Add(item.Key, item.Value);
                        }
                        items = removed;
                    }
                }
                else if(tokens.Length == 1)
                {
                    
                        string[] arguments = input.Split(new string[] { " = " }, StringSplitOptions.RemoveEmptyEntries);
                        string trainName = arguments[0];
                        string otherTrainName = arguments[1];

                        if (!items.ContainsKey(trainName))
                        {
                            items.Add(trainName, new List<Wagon>());
                            foreach (var item in items[otherTrainName])
                            {
                                items[trainName].Add(item);
                            }
                        }
                        else
                        {
                            
                            for (int i = 0; i < items[trainName].Count; i++)
                            {
                                items[trainName].RemoveAt(i);
                            }
                            foreach (var item in items[otherTrainName])
                            {
                                items[trainName].Add(item);
                            }
                        }
                 
                }
                input = Console.ReadLine();
            }
       
                foreach (var item in items.OrderByDescending(x => x.Value.Sum(y => y.WagonPower)).ThenBy(x => x.Value.Count()))
                {
                    Console.WriteLine("Train: " + item.Key);
                    foreach (var element in item.Value.OrderByDescending(x => x.WagonPower))
                    {
                        Console.WriteLine($"###{element.WagonName} - {element.WagonPower}");
                    }
                }
            
        }
    }

    public class Wagon
    {
        public string WagonName { get; set; }
        public int WagonPower { get; set; }
    }
}
