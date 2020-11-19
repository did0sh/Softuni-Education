using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace p06_ValidUsernames
{
    class Program
    {
        static void Main(string[] args)
        {
            string line = Console.ReadLine();
            string[] words = line.Split(new char[] { ' ', ',', '/', '\\', '(', ')' }, StringSplitOptions.RemoveEmptyEntries);
            List<string> valid = new List<string>();

            string pattern = @"^[A-Za-z][A-Za-z0-9_]{2,24}$";

            foreach (var username in words)
            {
                if(Regex.IsMatch(username, pattern))
                {
                    valid.Add(username);
                }
            }

            int maxSum = 0;
            string first = String.Empty;
            string second = String.Empty;

            for (int i = 1; i < valid.Count; i++)
            {
                int sum = valid[i - 1].Length + valid[i].Length;
                if(sum > maxSum)
                {
                    maxSum = sum;
                    first = valid[i - 1];
                    second = valid[i];
                }
            }

            Console.WriteLine(first);
            Console.WriteLine(second);
        }
    }
}
