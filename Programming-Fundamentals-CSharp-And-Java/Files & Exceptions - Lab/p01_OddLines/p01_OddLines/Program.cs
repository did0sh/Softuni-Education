using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace p01_OddLines
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] lines = File.ReadAllLines("Input.txt");
            var oddLines = lines.Where((line, index) => index % 2 == 1);
            File.WriteAllLines("odd-lines.txt", oddLines);

        }
    }
}
