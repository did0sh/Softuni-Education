using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p04_Files
{
    class Program
    {
        static void Main(string[] args)
        {
            var items = new Dictionary<string, Dictionary<string, long>>();

            int n = int.Parse(Console.ReadLine());

            for (int i = 0; i < n; i++)
            {
                string input = Console.ReadLine();
                string[] tokens = input.Trim().Split(new char[] { '\\' }, StringSplitOptions.RemoveEmptyEntries);
                string folder = tokens[0];

                string[] filenameExtensionAndSize = tokens[tokens.Length - 1].Trim().Split(new char[] { ';' }, StringSplitOptions.RemoveEmptyEntries);
                string filename = filenameExtensionAndSize[0];
                long size = long.Parse(filenameExtensionAndSize[1]);

                if (!items.ContainsKey(folder))
                {
                    items.Add(folder, new Dictionary<string, long>());
                    items[folder].Add(filename, size);

                }
                else
                {
                    if (items[folder].ContainsKey(filename))
                    {
                        items[folder][filename] = size;
                    }
                    else if (!items[folder].ContainsKey(filename))
                    {
                        items[folder].Add(filename, size);
                    }  
                }
            }

            string[] endInput = Console.ReadLine().Split(' ');
            string searchExtension = endInput[0];
            string searchFolder = endInput[2];

            int count = 0;

            foreach (var item in items.Where(x => x.Key == searchFolder))
            {
                foreach (var filename in item.Value.Where(x => x.Key.EndsWith(searchExtension)).OrderByDescending(y => y.Value).ThenBy(y => y.Key))
                {
                    
                    Console.WriteLine($"{filename.Key} - {filename.Value} KB");
                    count++;
                }
  
            }

           
            if(count == 0)
            {
                Console.WriteLine("No");
            }

        }
    }
}
