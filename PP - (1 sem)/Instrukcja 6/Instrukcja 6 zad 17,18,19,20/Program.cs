using System;

namespace Instrukcja_6_zad_17_18_19_20
{
    public delegate int Delegacja(Int32 a, Int32 b);
    public static class Tools
    {
        public static Int32[] Wypelnij(Int32 rozmiar)
        {
            Int32[] tablica = new Int32[rozmiar];
            Random Losowa = new Random();
            for (int i = 0; i < rozmiar; i++) tablica[i] = Losowa.Next(1, 100);
            return tablica;
        }
        public static Int32[] Drukuj(Int32[] tablica)
        {
            for (Int32 i = 0; i < tablica.Length; i++)
            {
                Console.Write("{0}, ", tablica[i]);
            }
            Console.WriteLine();
            return tablica;
        }
        public static Int32[] Sprawdz(Int32[] tablica)
        {
            for (Int32 i = 1; i < tablica.Length; i++)
            {
                if (tablica[i - 1] > tablica[i])
                {
                    Console.WriteLine("Tablica nie jest posortowana.  :(");
                    return tablica;
                }
            }
            Console.WriteLine("Tablica jest dobrze posortowana.  :)");
            return tablica;
        }
        public static Int32[] Sortuj(this Int32[] tab)
        {
            int p = 0, g=0;
            while (g < tab.Length)
            {
                if (g == 0) g++;
                if (tab[g] >= tab[g - 1]) g++;
                else
                {
                    p = g;
                    while (tab[p] < tab[p - 1])
                    {
                        int zamiana = tab[p];
                        tab[p] = tab[p - 1];
                        tab[p - 1] = zamiana;
                        if (p == 1) break;
                        else p--;
                    }
                }
            }
            return tab;
        }
        public static Int32[] Sortuj2(Int32[] tab, Int32 d)
        {
            Int32 n = 0, m = 0, e = 0, j = 0, k = 0;
                int p = 0, g = 0;
            while (g < tab.Length)
            {
                if (g == 0) g++;
                if (tab[g] >= tab[g - 1]) g++;
                else
                {
                    p = g;
                    while (tab[p] < tab[p - 1])
                    {
                        int zamiana = tab[p];
                        tab[p] = tab[p - 1];
                        tab[p - 1] = zamiana;
                        if (p == 1) break;
                        else p--;
                    }
                }
            }
            for (Int32 i = 0; i < tab.Length; i++)
            {
                if (tab[i] % 2 == 1) n++;
                else m++;
            }
            Int32[] tab1 = new Int32[n];
            Int32[] tab2 = new Int32[m];
            for (Int32 i = 0; i < tab.Length; i++)
            {
                if (tab[i] % 2 == 1)
                {
                    tab1[j] = tab[i];
                    j++;
                }
                else
                {
                    tab2[k] = tab[i];
                    k++;
                }
            }
            if( d == 1)
            {
                for (int i = 0; i < n; i++)
                {
                    tab[e] = tab1[i];
                    e++;
                }
                for (int i = 0; i < m; i++)
                {
                    tab[e] = tab2[i];
                    e++;
                }
            }
            else
            {
                for (int i = 0; i < m; i++)
                {
                    tab[e] = tab2[i];
                    e++;
                }
                for (int i = 0; i < n; i++)
                {
                    tab[e] = tab1[i];
                    e++;
                }
            }
            return tab;
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            Int32 rozmiar=0, c=0, d=0;
            Console.WriteLine("=================================================");
            Console.WriteLine("Podaj rozmiar tablicy: ");
            rozmiar = Int32.Parse(Console.ReadLine());
            Int32[] tab1 = new Int32[rozmiar];
            //Delegacja delegacja = new Delegacja(Tools.Sortuj2);
            Console.WriteLine("=================================================");
            wybierz:
            Console.WriteLine("Napisz: ");
            Console.WriteLine("0: Tworzenie i wypełnianie tablicy losowymi liczbami");
            Console.WriteLine("1: Drukowanie tablicy");
            Console.WriteLine("2: Sprawdzanie, czy tablica jest posortowana");
            Console.WriteLine("3: Sortowanie (Gnoma)");
            Console.WriteLine("4: Zakończ");
            Console.WriteLine("=================================================");
            c = int.Parse(Console.ReadLine());
            switch (c)
            {
                case 0:
                    {
                        tab1 = Tools.Wypelnij(rozmiar);
                        Console.WriteLine("Tablica została pomyślnie utworzona.");
                        Console.WriteLine("=================================================");
                    }
                    break;
                case 1:
                    {
                        Tools.Drukuj(tab1);
                        Console.WriteLine("=================================================");
                    }
                    break;
                case 2:
                    {
                        tab1 = Tools.Sprawdz(tab1);
                        Console.WriteLine("=================================================");
                    }
                    break;
                case 3:
                    {
                    Console.WriteLine("0: Normalnie.");
                    Console.WriteLine("1: Nieparzyste ważniejsze.");
                    Console.WriteLine("2: Parzyste ważniejsze.");
                    d = Int32.Parse(Console.ReadLine());
                        switch (d)
                        {
                            case 0: tab1 = tab1.Sortuj(); break;
                            case 1: tab1 = Tools.Sortuj2(tab1, d); break;
                            case 2: tab1 = Tools.Sortuj2(tab1, d); break;
                        }
                        Console.WriteLine("Tablica została posortowana przez Gnoma.");
                        Console.WriteLine("=================================================");
                    }
                    break;
                case 4:
                    {
                        goto koniec;
                    }
            }
            goto wybierz;
            koniec:
            Console.WriteLine("Miłego dnia :)");
            Console.WriteLine("=================================================");
            Console.ReadKey();
        }
    }
}
