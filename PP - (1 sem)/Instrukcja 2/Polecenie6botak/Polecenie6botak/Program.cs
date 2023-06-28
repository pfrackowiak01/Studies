using System;
using System.ComponentModel.DataAnnotations;
using System.Diagnostics.CodeAnalysis;

namespace Polecenie6botak
{
    class Program
    {
        static void Main(string[] args)
        {
            Double c = 0, d = 0;
            Double[,] tab1 = new Double[4, 6];
            Random liczba = new Random();
            for (int a = 0; a < 10; a++)
            {
                for (int b = 0; b < 10; b++)
                {
                    c = liczba.Next(0, 999);
                    tab1[a, b] = c;
                    if (c > 99)
                    {
                        d = 3;
                    }

                    if (c > 9 && c < 100)
                    {
                        d = 2;
                    }

                    if (c < 10)
                    {
                        d = 1;
                    }

                    switch (d)
                    {
                        case 1:
                            {
                                Console.Write("     " + c);
                            }
                            break;
                        case 2:
                            {
                                Console.Write("    " + c);
                            }
                            break;
                        case 3:
                            {
                                Console.Write("   " + c);
                            }
                            break;
                    }
                };
                Console.WriteLine();
            };
        }
    }
}
