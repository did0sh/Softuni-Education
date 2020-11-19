using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p04_AverageGrades
{
    class Program
    {
        static void Main(string[] args)
        {
            Student[] student = ReadArrayOfStudents();

            foreach (var person in student.Where(y => y.AverageGrade >= 5).OrderBy(x => x.Name).ThenByDescending(y => y.AverageGrade))
            {
                Console.WriteLine("{0} -> {1:F2}", person.Name, person.AverageGrade);
            }
        }
  

        static Student[] ReadArrayOfStudents()
        {
            int n = int.Parse(Console.ReadLine());
            Student[] array = new Student[n];

            for (int j = 0; j < n; j++)
            {
                array[j] = ReadStudent(Console.ReadLine());
            }

            return array;
        }

        static Student ReadStudent(string input)
        {
            string[] arguments = input.Split(' ');
            double[] notes = new double[arguments.Length - 1];

            for (int i = 1; i < arguments.Length; i++)
            {
                notes[i - 1] = double.Parse(arguments[i]);
            }

            return new Student { Name = arguments[0], Grades = notes, AverageGrade = notes.Average() };
        }
    }
    
    class Student
    {
        public string Name { get; set; }
        public double[] Grades { get; set; }
        public double AverageGrade { get; set; }
    }
}
