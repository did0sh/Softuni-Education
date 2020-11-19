using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p02_AppendLists
{
    class Program
    {
        static void Main(string[] args)
        {
            List<string> items = Console.ReadLine().Split('|').ToList();


            for (int i = items.Count - 1; i >= 0; i--)
            {
                List<string> list = items[i].Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries).ToList();

                for (int u = 0; u < list.Count; u++)
                {
                    Console.Write(list[u] + " ");
                }

            }
            

        }
    }
}
