using System;
using System.Security.Cryptography.X509Certificates;

namespace Instrukcja_4_zad_5
{
    class Program
    {
        static void Main(string[] args)
        {
            Int32 n, fa, fb, fi=0, fib=0, x=1;

            Console.WriteLine("Jak długi ma być ciąg: ");
            n = Int32.Parse(Console.ReadLine());
            Int32 [] tab = new Int32[n+1];

            if(n==0)
            {
                fib = 0;
                Console.WriteLine(x + " wyraz ciągu Fibonacciego: " + fib);
            }
            else if (n==1)
            {
                fib = 1;
                Console.WriteLine(x + " wyraz ciągu Fibonacciego: " + fib);
            }
            else
            {
                fa = 0;
                Console.WriteLine(fa + " wyraz ciągu Fibonacciego: " + fa);
                tab[0] = fa;
                fb = 1;
                Console.WriteLine(x + " wyraz ciągu Fibonacciego: " + fb);
                tab[1] = fb;
                for (Int32 i = 2; i <= n; i++)
                {
                    fi = fa + fb;
                    fa = fb;
                    fb = fi;
                    x++;
                    tab[x] = fi;
                    Console.WriteLine(x + " wyraz ciągu Fibonacciego: " + fi);
                }
            }
            Console.WriteLine(" ");
            for (Int32 i = 0; i <= n; i++)
            {
                Console.Write(tab[i] + "  ");
            }

        }
    }
}
