using System;
using System.Globalization;
using System.Security.Cryptography.X509Certificates;

namespace Instrukcja_4_zad_7_8__liczby_pierwsze_
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Zad 7");
            Int32 liczba, d = 0, e = 0, x = 0;
            Console.WriteLine("Podaj liczbe: ");
            liczba = Int32.Parse(Console.ReadLine());

            for (Int32 i=1;i<liczba;i++)
            {
                if((liczba%i) == 0) d += 1;
            }
            if (d>2) Console.WriteLine(liczba + " to nie jest liczba pierwsza.");
            else Console.WriteLine(liczba + " to jest liczba pierwsza.");

            Console.WriteLine("--------------------");

            Console.WriteLine("Zad 8");
            Console.WriteLine("Podaj zakres od: ");
            Int32 A = Int32.Parse(Console.ReadLine());
            Console.WriteLine("do: ");
            Int32 B = Int32.Parse(Console.ReadLine());
            Console.WriteLine("Liczby pierwsze w tym przedziale to: ");
            for (int y = A; y <= B; y++)
            {
                for (Int32 j = 1; j <= y; j++)
                {
                    if ((y % j) == 0) e += 1;
                }
                if (e == 2)
                {
                    x++;
                    Console.Write(y + ", ");
                }
                e = 0;
            }
            Console.WriteLine(" ");
            Console.WriteLine("Wszystkich liczb pierwszych w tym przedziale jest " + x);
            Console.ReadKey(true);
        }
    }
}
