using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace p03_CameraView
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] input = Console.ReadLine().Split().Select(int.Parse).ToArray();
            int skip = input[0];
            int take = input[1];
            string pattern = @"\|<(\w{" + skip + "})(\\w{0," + take + "})";

            string text = Console.ReadLine();

            MatchCollection matches = Regex.Matches(text, pattern);
            List<string> result = new List<string>();

            foreach (Match match in matches)
            {
                result.Add(match.Groups[2].Value);
            }

            Console.WriteLine(string.Join(", ", result));

        }
    }
}
