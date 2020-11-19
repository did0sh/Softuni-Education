using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p04_SieveOfEratosthenes
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            bool[] primes = new bool[n + 1];

            primes[0] = primes[1] = false;

            for (int i = 2; i <= n; i++)
            {
                primes[i] = true;
            }

            for (int k = 2; k < primes.Length; k++)
            {
                if(primes[k] == true)
                {
                    for (int multiplier = 2; multiplier*k <= n; multiplier++)
                    {
                        primes[multiplier * k] = false;
                    }
                }
            }

            for (int i = 2; i <= n; i++)
            {
                if(primes[i] == true)
                {
                    Console.Write(i);
                    Console.Write(" ");
                }
            }

           
           
        }
    }
}
