using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p05_CompareCharArrays
{
    class Program
    {
        static void Main(string[] args)
        {
            char[] firstItems = Console.ReadLine().Split(' ').Select(char.Parse).ToArray();
            char[] secondItems = Console.ReadLine().Split(' ').Select(char.Parse).ToArray();

            char[] firstSumArr = new char[firstItems.Length];
            char[] secondSumArr = new char[firstItems.Length];

            if (firstItems.Length > secondItems.Length) // if ab > a ,   print a, print ab
            {
                Console.WriteLine(string.Join("", secondItems));
                Console.WriteLine(string.Join("", firstItems));
            } 
            else if (firstItems.Length < secondItems.Length) // if a < ab, print a, print ab
            {
                Console.WriteLine(string.Join("", firstItems));
                Console.WriteLine(string.Join("", secondItems));
            }




            if (firstItems.Length == secondItems.Length) // if abc == ada
            {
                for (int i = 0; i < firstItems.Length; i++) 
                {
                    if (firstItems[i] > secondItems[i]) // if b > a , print a, print b, end program
                    {
                        Console.WriteLine(string.Join("", secondItems));
                        Console.WriteLine(string.Join("", firstItems));
                        return;
                    }
                    else if (firstItems[i] < secondItems[i]) // if b < d,  print abc, print ada, end program
                    {
                        Console.WriteLine(string.Join("", firstItems));
                        Console.WriteLine(string.Join("", secondItems));
                        return;
                    }
                    
                    
                    if(firstItems[i] == secondItems[i])   //the chars are equal, save them
                    {
                        firstSumArr[i] += firstItems[i];
                        secondSumArr[i] += secondItems[i];
                    }

                  
                }

                Console.WriteLine(string.Join("", firstSumArr)); // print equal chars
                Console.WriteLine(string.Join("", secondSumArr));
            }
           
        }
    }
}
