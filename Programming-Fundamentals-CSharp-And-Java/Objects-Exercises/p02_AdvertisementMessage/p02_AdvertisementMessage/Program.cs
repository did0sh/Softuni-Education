﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p02_AdvertisementMessage
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] phrases = { "Excellent product.",
                "Such a great product.",
                "I always use that product.",
                "Best product of its category.",
                "Exceptional product.",
                "I can’t live without this product."};

            string[] events = { "Now I feel good.",
                "I have succeeded with this product.",
                "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.",
                "Try it yourself, I am very satisfied.",
                "I feel great!" };

            string[] authors = { "Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva" };
            string[] cities = { "Burgas", "Sofia", "Plovdiv", "Varna", "Ruse" };

            Random rand = new Random();

            int n = int.Parse(Console.ReadLine());

            for (int i = 0; i < n; i++)
            {
                string phrasesIndex = phrases[rand.Next(0, phrases.Length)];
                string eventsIndex = events[rand.Next(0, events.Length)];
                string authorsIndex = authors[rand.Next(0, authors.Length)];
                string citiesIndex = cities[rand.Next(0, cities.Length)];

                Console.WriteLine($"{phrasesIndex} {eventsIndex} {authorsIndex} – {citiesIndex}");
            }


        }
    }
}
