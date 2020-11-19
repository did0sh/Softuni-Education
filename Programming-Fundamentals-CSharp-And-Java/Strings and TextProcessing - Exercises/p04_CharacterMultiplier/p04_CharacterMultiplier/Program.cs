using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p04_CharacterMultiplier
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] input = Console.ReadLine().Split(' ');
            string firstWord = input[0];
            string secondWord = input[1];

            int valueCharFirst = 0;
            int valueCharSecond = 0;

            long sum = 0;

            if(firstWord.Length == secondWord.Length)
            {
                for (int i = 0; i < firstWord.Length; i++)
                {
                    valueCharFirst = firstWord[i];
                    valueCharSecond = secondWord[i];

                    sum += valueCharFirst * valueCharSecond;
                }
            }

            else
            {
                int minLength = Math.Min(firstWord.Length, secondWord.Length);

                for (int i = 0; i < minLength; i++)
                {
                    valueCharFirst = firstWord[i];
                    valueCharSecond = secondWord[i];

                    sum += valueCharFirst * valueCharSecond;
                }

                if (firstWord.Length > secondWord.Length)
                {
                    firstWord = firstWord.Substring(minLength);
                    foreach (var character in firstWord)
                    {
                        sum += (int)character;
                    }
                }
                else if (firstWord.Length < secondWord.Length)
                {
                    secondWord = secondWord.Substring(minLength);
                    foreach (var character in secondWord)
                    {
                        sum += (int)character;
                    }
                }
            }

            
            Console.WriteLine(sum);
 
        }
    }
}
