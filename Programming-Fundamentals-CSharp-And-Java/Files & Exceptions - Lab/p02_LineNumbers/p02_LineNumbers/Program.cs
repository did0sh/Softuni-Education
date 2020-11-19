using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace p02_LineNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] lines = File.ReadAllLines("Input.txt");
            var numberedLines = lines.Select((line, indexer) => $"{indexer + 1}. {line}");
            File.WriteAllLines("output.txt", numberedLines);
        }
    }
}
