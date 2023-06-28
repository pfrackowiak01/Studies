using System;
using System.Diagnostics;

namespace Instrukcja_4_zad_10
{
    class Program
    {
        static void Main(string[] args)
        {
            
            Int32 e = 0, x = 0;
            Console.WriteLine("Podaj zakres od: ");
            Int32 A = Int32.Parse(Console.ReadLine());
            Console.WriteLine("do: ");
            Int32 B = Int32.Parse(Console.ReadLine());
            if (A == 1) A++;
            if (A == 0) A=2;

            Stopwatch watch;
            watch = Stopwatch.StartNew();
            /*
            Console.WriteLine("1. Pominięcie podzielników 1 i N");
            Console.WriteLine("Liczby pierwsze w tym przedziale to: ");
            for (int y = A; y <= B; y++)
            {
                for (Int32 j = 2; j < y; j++)
                {
                    if ((y % j) == 0) e += 1;
                }
                if (e == 0)
                {
                    x++;
                    Console.Write(y + ", ");
                }
                e = 0;
            }
            Console.WriteLine(" ");
            Console.WriteLine("Wszystkich liczb pierwszych w tym przedziale jest " + x);

            watch.Stop();
            Console.WriteLine("Czas: {0}", watch.Elapsed);
            Console.WriteLine(" ");
            Console.ReadKey(true);
            watch.Reset();
            watch.Start();
            */
            x = 0;
            e = 0;
            Int32 ii = 2;
            Console.WriteLine("2. Sprawdzanie (do pierwszej wpadki)");
            Console.WriteLine("Liczby pierwsze w tym przedziale to: ");
            for (int y = A; y <= B; y++)
            {
                while (ii < y && e==0)
                {
                    if ((y % ii) == 0) e++;
                    ii++;
                }
                if (e == 0)
                {
                    x++;
                    Console.Write(y + ", ");
                }
                e = 0;
                ii = 2;
            }
            Console.WriteLine(" ");
            Console.WriteLine("Wszystkich liczb pierwszych w tym przedziale jest " + x);

            watch.Stop();
            Console.WriteLine("Czas: {0}", watch.Elapsed);
            Console.WriteLine(" ");
            Console.ReadKey(true);

            watch.Reset();
            watch.Start();

            x = 0;
            e = 0;
            Double p;
            Console.WriteLine("3. Sprawdzanie podzielników do pierwiastka z N");
            Console.WriteLine("Liczby pierwsze w tym przedziale to: ");
            for (int y = A; y <= B; y++)
            {
                p = Math.Sqrt(y);
                for (Int32 j = 2; j <= p; j++)
                {
                    if ((y % j) == 0) e++;
                }
                if (e == 0)
                {
                    x++;
                    Console.Write(y + ", ");
                }
                e = 0;
            }
            Console.WriteLine(" ");
            Console.WriteLine("Wszystkich liczb pierwszych w tym przedziale jest " + x);
            watch.Stop();
            Console.WriteLine("Czas: {0}", watch.Elapsed);
            Console.WriteLine(" ");
            Console.ReadKey(true);
            
            watch.Reset();
            watch.Start();
            
            x = 0;
            Int64 i, c;
            Int64 v = 100000000;
            Int64[] tablica = new Int64[v];
            Console.WriteLine("4. Sito Eratostenesa");
            Console.WriteLine("Liczby pierwsze w tym przedziale to: ");
            p = Math.Sqrt(B);
            for (i = 1; i <= B; i++)
            {
                tablica[i] = i;
            }
            for (i = 2; i <= p; i++)
            {
                if (tablica[i] != 0)
                {
                    c = i + i;
                    while (c <= B)
                    {
                        tablica[c] = 0;
                        c += i;
                    }
                }
            }
            for (i = A; i <= B; i++)
            {
                if (tablica[i] != 0)
                {
                    Console.Write(i + ", ");
                    x++;
                }
            }
            Console.WriteLine(" ");
            Console.WriteLine("Wszystkich liczb pierwszych w tym przedziale jest " + x);
            watch.Stop();
            Console.WriteLine("Czas: {0}", watch.Elapsed);
            Console.WriteLine(" ");
            Console.ReadKey(true);
            
            /*
            Int32 a = 0, b = 1, j = 1, liczb = 0, d = 0;
            Stopwatch watch;
            watch = new Stopwatch();
            Console.WriteLine("Ile liczb: ");
            a = Int32.Parse(Console.ReadLine());
            Console.WriteLine("Od jakiej liczby: ");
            b = Int32.Parse(Console.ReadLine());
            Console.WriteLine(" ");
            Console.WriteLine("Wygenerowano liczby pierwsze: ");
            if (b == 1) b++;
            if (b == 0) b = 2;
            int atemp;
            atemp = b - 1;
            int[] tab1 = new int[a];

            while (liczb != a)
            {
                atemp++;
                d = 0;
                j = 1;
                for (int i = 0; i < atemp; i++)
                {
                    if (atemp % j == 0)
                    {
                        d = d + 1;
                    }
                    j++;
                }
                if (d == 2)
                {
                    tab1[liczb] = atemp;
                    liczb++;
                }
            }
            for (int i = 0; i < tab1.Length; i++)
            {
                Console.WriteLine("{0}", tab1[i]);
            }
            */
        }
    }
}
