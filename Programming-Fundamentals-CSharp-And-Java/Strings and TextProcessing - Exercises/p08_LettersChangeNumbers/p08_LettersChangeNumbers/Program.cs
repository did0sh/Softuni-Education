using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p08_LettersChangeNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] text = Console.ReadLine().Split(new char[] { ' ', '\t' }, StringSplitOptions.RemoveEmptyEntries);
            decimal sum = 0.0M;

            for (int i = 0; i < text.Length; i++)
            {
                string newString = text[i];

                char firstLetter = newString[0];
                decimal numberBetween = decimal.Parse(newString.Substring(1, newString.Length - 2));
                char lastLetter = newString[newString.Length - 1];

               

                if ((int)firstLetter > 64 && (int)firstLetter < 91)
                {
                    decimal indexInAlphabet = (int)firstLetter - 64;
                    sum += numberBetween / indexInAlphabet;
                }
                else if ((int)firstLetter > 96 && (int)firstLetter < 123)
                {
                    decimal indexInAlphabet = (int)firstLetter - 96;
                    sum += numberBetween * indexInAlphabet;
                }


                if ((int)lastLetter > 64 && (int)lastLetter < 91)
                {
                    decimal indexInAlphabet = (int)lastLetter - 64;
                    sum -= indexInAlphabet;
                }
                else if ((int)lastLetter > 96 && (int)lastLetter < 123)
                {
                    decimal indexInAlphabet = (int)lastLetter - 96;
                    sum += indexInAlphabet;
                }

            }

            Console.WriteLine("{0:F2}", sum);

            
        }
    }
}
