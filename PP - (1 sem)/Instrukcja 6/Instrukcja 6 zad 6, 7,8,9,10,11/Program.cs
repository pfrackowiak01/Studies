using System;

namespace Instrukcja_6_zad_6__7
{
    public static class Tools
    {
        public static Int32 NWD(Int32 start, Int32 koniec)
        {
            Console.WriteLine("------------------------------------------");
            Int32 liczba1, liczba2, tmp;
            Random Losowa = new Random();
            liczba1 = Losowa.Next(start, koniec);
            liczba2 = Losowa.Next(start, koniec);
            Console.WriteLine("Pierwsza liczba to {0}", liczba1);
            Console.WriteLine("Druga liczba to {0}", liczba2);

            while (liczba2 != 0)
            {
                tmp = liczba2;
                liczba2 = liczba1 % liczba2;
                liczba1 = tmp;
            }
            Console.WriteLine("NWD dla tych liczb wynosi {0}", liczba1);
            if (liczba1 == 1) return 1;
            return 0;
        }
        public static Int32 NWD2(Int32 start, Int32 koniec)
        {
            Console.WriteLine("------------------------------------------");
            Int32 liczba1, liczba2, wynik;
            Random Losowa = new Random();
            liczba1 = Losowa.Next(start, koniec);
            liczba2 = Losowa.Next(start, koniec);
            Console.WriteLine("Pierwsza liczba to {0}", liczba1);
            Console.WriteLine("Druga liczba to {0}", liczba2);
            wynik = NWDrek(liczba1, liczba2);
            Console.WriteLine("NWD dla tych liczb wynosi {0}", wynik);
            if (wynik == 1) return 1;
            return 0;
        }
        public static Int32 NWDrek(Int32 liczba1, Int32 liczba2)
        {
            if (liczba1 != liczba2)
            {
                if (liczba2 == 0) return liczba1;
                Int32 tmp = liczba2;
                liczba2 = liczba1 % liczba2;
                liczba1 = tmp;
                if (liczba2 != 0) return NWDrek(liczba1, liczba2);
            }
            return liczba1;
        }
        public static Int32 pary(Int32 start, Int32 koniec)
        {
            Console.WriteLine("------------------------------------------");
            Int32 liczba1, liczba2;
            liczba1 = start;
            liczba2 = koniec;
            for (int i = start; i < koniec; i++)
            {
                for (int j = liczba1; j < koniec; j++)
                {
                    if (Tools.NWDrek(liczba1, liczba2) == 1) Console.Write("[{0},{1}]  ", liczba1, liczba2);
                    liczba2--;
                }
                liczba1++;
                liczba2 = koniec;
            }
            Console.WriteLine(" ");
            return 0;
        }
        public static ulong silnia(this ulong liczba)
        {
            if (liczba < 1)
                return 1;
            else
                return liczba * silnia(liczba - 1);
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            Int32 pocz, kon, wynik = 0, wynik2 = 0, wynik3 = 0;
            ulong a, b, wynik4=0;
            Console.WriteLine("Podaj początek zakresu: ");
            pocz = Int32.Parse(Console.ReadLine());
            Console.WriteLine("Podaj koniec zakresu: ");
            kon = Int32.Parse(Console.ReadLine());

            Console.WriteLine("WYLICZANIE WZGLĘDNIE PIERWSZYCH LICZB PRZEZ NWD - zad.6");
            while (wynik != 1) wynik = Tools.NWD(pocz, kon);
            Console.WriteLine("------------------------------------------");
            Console.WriteLine("WYLICZANIE WZGLĘDNIE PIERWSZYCH LICZB PRZEZ NWD (REKURENCJA) - zad.7");
            while (wynik2 != 1) wynik2 = Tools.NWD2(pocz, kon);
            Console.WriteLine("------------------------------------------");
            Console.WriteLine("WYŚWIETLA WSZYSTKIE PARY WZGLĘDNIE PIERWSZYCH LICZB PRZEZ NWD (REKURENCJA) - zad.8");
            wynik3 = Tools.pary(pocz, kon);
            Console.WriteLine("------------------------------------------");
            Console.WriteLine("WYŚWIETLA WARTOŚCI SILNI LICZB Z PODANEGO ZAKRESU - zad. 9, 10, 11");

            Console.WriteLine("Podaj początek zakresu dla policzenia silni: ");
            a = ulong.Parse(Console.ReadLine());
            Console.WriteLine("Podaj koniec zakresu: ");
            b = ulong.Parse(Console.ReadLine());
            for (ulong i = a; i <= b; i++)
            {
                wynik4 = i.silnia();
                Console.WriteLine("{0}! = {1}", i, wynik4);
            }
        }
    }
}
