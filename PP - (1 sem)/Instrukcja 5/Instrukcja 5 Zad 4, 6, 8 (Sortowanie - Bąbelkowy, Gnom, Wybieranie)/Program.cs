using System;

namespace Instrukcja_5_Zad_4__6__8__Sortowanie___Bąbelkowy__Gnom__Wybieranie_
{
    class Program
    {
        static void Main(string[] args)
        {
            Int32 a = 0;
            Console.WriteLine("Podaj rozmiar tablicy: ");
            Int32 x = Int32.Parse(Console.ReadLine());
            Int32[] tab1 = new Int32[x];
            Int32[] tab2 = new Int32[x];
            Int32[] tab3 = new Int32[x];
            Int32[] tab4 = new Int32[x];
            Random liczba = new Random();
            Console.WriteLine("Nasze wylosowane liczby: ");
            for (int i = 0; i < x; i++)
            {
                a = liczba.Next(0, x * 5);
                tab1[i] = a;
                tab2[i] = a;
                tab3[i] = a;
                tab4[i] = a;
                Console.Write(tab1[i] + "  ");
            }


            //Sortowanie Bąbelkowe
            System.Diagnostics.Stopwatch watch;
            watch = System.Diagnostics.Stopwatch.StartNew();
            Console.WriteLine();
            Console.WriteLine();
            Console.WriteLine("Sortowanie Bąbelkowe:");
            int n = x;
            do
            {
                for (int i = 0; i < n - 1; i++)
                {
                    if (tab1[i] > tab1[i + 1])
                    {
                        int zamiana = tab1[i];
                        tab1[i] = tab1[i + 1];
                        tab1[i + 1] = zamiana;
                    }
                }
                n--;
            }
            while (n > 1);
            watch.Stop();
            Console.WriteLine("Sortowanie udane i zajęło one: {0}", watch.Elapsed);
            watch.Restart();
            for (int i = 0; i < x; i++)
            {
                Console.Write(tab1[i] + "  ");
            }


            //Sortowanie Gnoma
            watch.Start();
            Console.WriteLine();
            Console.WriteLine();
            Console.WriteLine("Sortowanie gnoma:");
            int p = 0;
            while (p < x)
            {
                if (p == 0) p++;
                if (tab2[p] >= tab2[p - 1]) p++;
                else
                {
                    int zamiana = tab2[p];
                    tab2[p] = tab2[p - 1];
                    tab2[p - 1] = zamiana;
                    p--;
                }
            }
            watch.Stop();
            Console.WriteLine("Sortowanie udane i zajęło one: {0}", watch.Elapsed);
            watch.Restart();
            for (int i = 0; i < x; i++)
            {
                Console.Write(tab2[i] + "  ");
            }


            //Sortowanie przez Wybieranie
            watch.Start();
            Console.WriteLine();
            Console.WriteLine();
            Console.WriteLine("Sortowanie przez wybieranie:");
            for (int i = 0; i < x; i++)
            {
                for (int j = i + 1; j < x; j++)
                {
                    if (tab3[i] >= tab3[j])
                    {
                        int zamiana = tab3[i];
                        tab3[i] = tab3[j];
                        tab3[j] = zamiana;
                    }
                }
            }
            watch.Stop();
            Console.WriteLine("Sortowanie udane i zajęło one: {0}", watch.Elapsed);
            watch.Restart();
            for (int i = 0; i < x; i++)
            {
                Console.Write(tab3[i] + "  ");
            }
        }
    }
}
