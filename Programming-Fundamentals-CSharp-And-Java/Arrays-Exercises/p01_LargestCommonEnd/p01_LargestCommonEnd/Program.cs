using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p01_LargestCommonEnd
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] firstItems = Console.ReadLine().Split(' ');
            string[] secondItems = Console.ReadLine().Split(' ');

            int length = firstItems.Length;
            int length2 = secondItems.Length;

            int rightCount = 0;
            int leftCount = 0;

            while(rightCount < firstItems.Length && rightCount < secondItems.Length)
            {
                if(firstItems[length - rightCount - 1] == secondItems[length2 - rightCount - 1])
                {
                    rightCount++;
                }
                else
                {
                    break;
                }
            }

            
            while(leftCount < firstItems.Length && leftCount < secondItems.Length)
            {
                if(firstItems[leftCount] == secondItems[leftCount])
                {
                    leftCount++;
                }
                else
                {
                    break;
                }
            }

            int result = Math.Max(rightCount, leftCount);
            Console.WriteLine(result);
           
        
            
            

          
        }
    }
}
