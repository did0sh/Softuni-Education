using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;
namespace p04_MergeFiles
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] readFirst = File.ReadAllText("FileOne.txt").Split();
            string[] readSecond = File.ReadAllText("FileTwo.txt").Split();

            for (int i = 0; i < readFirst.Length; i++)
            {
                File.AppendAllText("merged.txt", readFirst[i] + Environment.NewLine + readSecond[i]);
            }
        }
    }
}
