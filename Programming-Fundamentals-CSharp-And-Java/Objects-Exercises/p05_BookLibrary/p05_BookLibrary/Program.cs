using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Globalization;

namespace p05_BookLibrary
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            List<Books> listOfBooks = new List<Books>();

            for (int i = 0; i < n; i++)
            {
                listOfBooks.Add(ReadBooks(Console.ReadLine()));
            }

            Library library = new Library { Name = "Library", Book = listOfBooks };

            var authors = new Dictionary<string, decimal>();

            foreach (Books book in library.Book)
            {
                if (!authors.ContainsKey(book.Author))
                {
                    authors.Add(book.Author, book.Price);
                }
                else
                {
                    authors[book.Author] += book.Price;
                }
            }

            foreach (var element in authors.OrderByDescending(x => x.Value).ThenBy(y => y.Key))
            {
                Console.WriteLine("{0} -> {1:F2}", element.Key, element.Value);
            }
        }

        static Books ReadBooks(string input)
        {
            string[] arguments = input.Split(' ');
            string title = arguments[0];
            string author = arguments[1];
            string publisher = arguments[2];
            DateTime releasedate = DateTime.ParseExact(arguments[3], "dd.MM.yyyy", CultureInfo.InvariantCulture);
            string isbnNumber = arguments[4];
            decimal price = decimal.Parse(arguments[5]);

            return new Books { Title = title, Author = author, Publisher = publisher, ReleaseDate = releasedate, ISBN = isbnNumber, Price = price };
        }
    }

    class Library
    {
        public string Name { get; set; }
        public List<Books> Book { get; set; }
    }

    class Books
    {
        public string Title { get; set; }
        public string Author { get; set; }
        public string Publisher { get; set; }
        public DateTime ReleaseDate { get; set; }
        public string ISBN { get; set; }
        public decimal Price { get; set; }
    }
}
