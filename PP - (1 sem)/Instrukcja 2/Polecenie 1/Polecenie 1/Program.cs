using System;
using System.ComponentModel.DataAnnotations;
using System.Diagnostics.CodeAnalysis;

namespace Polecenie_1
{
    class Program
    {
        static void Main(string[] args)
        {
            Int32 a = 0, b = 0, c, suma = 0, max = 0, min = 1000, maxA = 0, maxB = 0, minA = 0, minB = 0, d = 0;
            Int32[,] tab1 = new Int32[4,6];
            Int32[,] tab2 = new Int32[6,4];
            Random liczba = new Random();
            for (a = 0; a < 4; a++)
            {
                for (b = 0; b < 6; b++)
                {
                    tab1[a, b] = liczba.Next(100, 999);
                    c = tab1[a, b];
                    tab2[b, a] = tab1[a, b];
                    if (c > max)
                    {
                        max = c;
                        maxA = a + 1;
                        maxB = b + 1;
                    }
                    if (c < min)
                    {
                        min = c;
                        minA = a + 1;
                        minB = b + 1;
                    }
                    suma = suma + c;
                    Console.Write("{0}  ", c);
                };
                Console.WriteLine();
            };
            Console.WriteLine();
            Console.WriteLine();
            Console.WriteLine("Suma = {0}", suma);
            Console.WriteLine("Max = {0} Znajduje się w {1} wierszu i {2} kolumnie", max, maxA, maxB);
            Console.WriteLine("Min = {0} Znajduje się w {1} wierszu i {2} kolumnie", min, minA, minB);
            for (a = 0; a < 6; a++)
            {
                for (b = 0; b < 4; b++)
                {
                    Console.Write(tab2[a, b] + "   ");
                };
                Console.WriteLine();
            };
        }
    }
}
