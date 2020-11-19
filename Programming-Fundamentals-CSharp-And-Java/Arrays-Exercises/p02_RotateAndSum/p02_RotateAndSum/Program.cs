using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p02_RotateAndSum
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] items = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();

            
            int rotations = int.Parse(Console.ReadLine());

            int[] sum = new int[items.Length];
            


            for (int i = 0; i < rotations; i++)
            {
                int[] rotated = new int[items.Length];
                rotated[0] = items[items.Length - 1];
                for (int j = items.Length - 1; j >= 1; j--)
                {

                    rotated[j] = items[j - 1];
                }

                

                for (int k = 0; k < rotated.Length; k++)
                {
                    sum[k] += rotated[k];
                }

                items = rotated;
            }

            Console.WriteLine(string.Join(" ", sum));
            
            
        }
    }
}
