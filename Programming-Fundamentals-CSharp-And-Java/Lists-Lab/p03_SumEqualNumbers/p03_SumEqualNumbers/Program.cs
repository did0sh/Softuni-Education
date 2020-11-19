using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p03_SumEqualNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            List<double> items = Console.ReadLine().Split(' ').Select(double.Parse).ToList();           

            for (int i = 0; i < items.Count-1; i++)
            {
                while(i < items.Count - 1)
                {
                    if (items[i] == items[i + 1])
                    {
                        items[i] = items[i] + items[i + 1];
                        items.RemoveAt(i + 1);

                        if (i > 0)
                        {
                            i--;
                        }
                    }                   
                    else
                    {
                        i++;
                    }
                }             
                
            }


            for (int j = 0; j < items.Count; j++)
            {
                Console.Write(items[j]);
                Console.Write(" ");
            }

            
        }
    }
}
