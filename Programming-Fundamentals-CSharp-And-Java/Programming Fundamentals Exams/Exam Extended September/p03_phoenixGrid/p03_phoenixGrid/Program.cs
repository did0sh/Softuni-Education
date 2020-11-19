using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace p03_phoenixGrid
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            string invalidPatter = @"\s|_";
            bool isValid = true;


            while (input != "ReadMe")
            {
                string[] tokens = input.Split(new char[]{ '.' }, StringSplitOptions.RemoveEmptyEntries);

                for (int u = 0; u < tokens.Length; u++)
                {
                    if(Regex.IsMatch(tokens[u].Trim(), invalidPatter))
                    {
                        isValid = false;
                    }
                }      
                
                if(isValid == false)
                {
                    Console.WriteLine("NO");
                    input = Console.ReadLine();
                    continue;
                }
               StringBuilder text = new StringBuilder();
                List<string> helper = new List<string>();
                StringBuilder textReverse = new StringBuilder();

                List<string> resultsText = new List<string>();
                List<string> resultsReversed = new List<string>();

                for (int i = 0; i < tokens.Length; i++)
                {
                    text.Append(tokens[i]);
                    helper.Add(tokens[i]);
                }

                for (int k = helper.Count - 1; k >= 0; k--)
                {
                    string currentText = helper[k];
                    for (int t = currentText.Length - 1; t >= 0; t--)
                    {
                        textReverse.Append(currentText[t].ToString());
                    }
                }

                resultsText.Add(text.ToString());
                resultsReversed.Add(textReverse.ToString());

                if (!resultsText.Contains(" ") && !resultsText.Contains("_") && resultsText[0] == resultsReversed[0])
                {
                    Console.WriteLine("YES");
                }
                else
                {
                    Console.WriteLine("NO");
                }

                text = new StringBuilder();
                helper = new List<string>();
                textReverse = new StringBuilder();
                resultsText = new List<string>();
                resultsReversed = new List<string>();


                input = Console.ReadLine();
            }
        }
    }
}
