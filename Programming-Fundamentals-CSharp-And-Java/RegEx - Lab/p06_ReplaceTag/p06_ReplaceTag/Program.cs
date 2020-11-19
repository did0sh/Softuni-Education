using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace p06_ReplaceTag
{
    class Program
    {
        static void Main(string[] args)
        {
            string pattern = @"<a.*?href.*?=(.*)>(.*)<\/a>";
            string replacement = @"[URL href=$1]$2[/URL]";
            
            string input = Console.ReadLine();
            while(input != "end")
            {
                string replaced = Regex.Replace(input, pattern, replacement);
                Console.WriteLine(replaced);

                input = Console.ReadLine();
            
            }

            
        }
    }
}
