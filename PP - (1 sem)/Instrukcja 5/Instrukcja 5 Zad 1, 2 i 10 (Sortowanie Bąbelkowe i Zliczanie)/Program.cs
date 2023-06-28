using System;

namespace Instrukcja_5_Zad_1__2_i_10__Sortowanie_Bąbelkowe_i_Zliczanie_
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
            Random liczba = new Random();
            Console.WriteLine("Nasze wylosowane liczby: ");
            for (int i = 0; i < x; i++)
            {
                a = liczba.Next(0, x * 5);
                tab1[i] = a;
                tab2[i] = a;
                Console.Write(tab1[i] + "  ");
            }

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
            for (int i = 0; i < x; i++)
            {
                Console.Write(tab1[i] + "  ");
            }

            Console.WriteLine();
            Console.WriteLine();
            Console.WriteLine("Sortowanie przez zliczanie:");
            int max = 0, min = x * 5;
            for (int i = 0; i < x; i++)
            {
                if (tab2[i] > max) max = tab2[i];
                if (tab2[i] < min) min = tab2[i];
            }
            Console.WriteLine("Min = " + min);
            Console.WriteLine("Max = " + max);
            int dl = max - min + 1;
            int[] zlicz = new int[dl];
            for (int i = 0; i < dl; i++)
                zlicz[i] = 0;
            for (int i = 0; i < x; i++)
                zlicz[tab2[i] - min]++;
            int m = 0;
            for (int i = 0; i < dl; i++)
                for (int j = 0; j < zlicz[i]; j++)
                    tab2[m++] = i + min;
            for (int i = 0; i < x; i++)
            {
                Console.Write(tab2[i] + "  ");
            }
        }
    }
}
