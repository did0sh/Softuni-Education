using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Globalization;
namespace p08_MentorGroup
{
    class Program
    {
        static void Main(string[] args)
        {
            Dictionary<string, Student> students = new Dictionary<string, Student>();
            string input = Console.ReadLine();

           
            while(input != "end of dates")
            {
                string[] tokens = input.Split(' ', ',');
                string name = tokens[0];
                List<DateTime> dates = new List<DateTime>();

                for (int i = 1; i < tokens.Length; i++)
                {
                    DateTime attendanceDates = DateTime.ParseExact(tokens[i], "dd/MM/yyyy", CultureInfo.InvariantCulture);
                    dates.Add(attendanceDates);
                }

                Student studentProperties = new Student { Name = name, attendanceDates = dates };

                if (!students.ContainsKey(name))
                {
                    students.Add(name, studentProperties);
                }
                else
                {
                    students[name].attendanceDates.AddRange(dates);
                }

                input = Console.ReadLine();
            }



            string secondInput = Console.ReadLine();

            while(secondInput != "end of comments")
            {
                string[] studentInfo = secondInput.Split('-');
                string studentName = studentInfo[0];
                string studentComments = studentInfo[1];

                List<string> comments = new List<string>();
                comments.Add(studentComments);

                if (students.ContainsKey(studentName))
                {
                    if(students[studentName].comments != null)
                    {
                        students[studentName].comments.AddRange(comments);
                    }
                    else
                    {
                        students[studentName].comments = comments;
                    }
                }
                secondInput = Console.ReadLine();
            }

            foreach (var item in students.OrderBy(x => x.Key))
            {
                Console.WriteLine(item.Key);
                Console.WriteLine("Comments:");

                if(item.Value.comments != null)
                {
                    foreach (var comment in item.Value.comments)
                    {
                        Console.WriteLine("- {0}", comment);
                    }

                }

                Console.WriteLine("Dates attended:");

                foreach (var date in item.Value.attendanceDates.OrderBy(d => d))
                {
                    Console.WriteLine("-- {0}", date.ToString("dd/MM/yyyy", CultureInfo.GetCultureInfo("en-US")));
                }

            }

        }
    }
    
    class Student
    {
        public string Name { get; set; }
        public List<string> comments { get; set; }
        public List<DateTime> attendanceDates { get; set; }
    }
}
