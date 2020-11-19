using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace p04_Weather
{
    class Program
    {
        static void Main(string[] args)
        {
            string pattern = @"([A-Z][A-Z])([0-9]+\.[0-9]+)([A-Za-z]+)\|";

            Dictionary<string, WeatherAndTemperatur> items = new Dictionary<string, WeatherAndTemperatur>();

            string input = Console.ReadLine();

            while(input != "end")
            {
                if (Regex.IsMatch(input, pattern))
                {
                    MatchCollection matches = Regex.Matches(input, pattern);
                    foreach (Match match in matches)
                    {
                        double temperatur = double.Parse(match.Groups[2].Value);
                        string weather = match.Groups[3].Value;
                        string city = match.Groups[1].Value;

                        WeatherAndTemperatur weatherAndTemperatur = new WeatherAndTemperatur { Weather = weather, Temperatur = temperatur };

                        if (!items.ContainsKey(city))
                        {
                            items.Add(city, weatherAndTemperatur);
                        }
                        else
                        {
                            items[city] = weatherAndTemperatur;
                        }
                    }
                }
                else
                {
                    input = Console.ReadLine();
                    continue;
                }
                input = Console.ReadLine();
            }

            foreach (var item in items.OrderBy(x => x.Value.Temperatur))
            {
                Console.WriteLine($"{item.Key} => {item.Value.Temperatur:F2} => {item.Value.Weather}");
            }
        }
    }
    public class WeatherAndTemperatur
    {
        public string Weather { get; set; }
        public double Temperatur { get; set; }
    }
}
