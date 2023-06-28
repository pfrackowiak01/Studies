using System;
using System.Diagnostics;

namespace Instrukcja_4_zad_3_4__NWD_1_porównanie_czasów_
{
    class Program
    {
        static void Main(string[] args)
        {
            Int32 a = 0, b = 0, c = 0, caseSwitch = 0, NWD = 0, druga = 0, pierwsza = 0;

            Poczatek:

            Console.WriteLine("Chcesz korzystac z algorytmu czesciowo scholastycznego (1) czy calkowice scholastycznego (2)?");
            caseSwitch = Int32.Parse(Console.ReadLine());

            Stopwatch watch = new Stopwatch();

            switch (caseSwitch)
            {
                case 1:

                    Console.WriteLine("Podaj liczbe");
                    a = Int32.Parse(Console.ReadLine());
                    watch.Start();

                Losowanie1:

                    Random los1 = new Random();
                    b = los1.Next(a, 2147483647);
                    druga = b;
                    while (a != b)
                    {
                        if (a > b)
                        {
                            a = a - b;
                        }
                        else
                        {
                            b = b - a;
                        }
                    };

                    NWD = a;

                    if (NWD == 1)
                    {
                        Console.WriteLine("Wylosowana liczba, względnie pierwsza do podanej to " + druga);

                        watch.Stop();
                        Console.WriteLine("Czas potrzebny do wykonania tych dzialan " + watch.Elapsed);

                        break;
                    }
                    else
                    {
                        goto Losowanie1;
                    };


                case 2:

                    watch.Start();

                Losowanie2:

                    Random los2 = new Random();
                    Random los3 = new Random();
                    b = los2.Next(a, 2147483647);
                    c = los3.Next(a, 2147483647);
                    pierwsza = b;
                    druga = c;

                    while (c != b)
                    {
                        if (c > b)
                        {
                            c = c - b;
                        }
                        else
                        {
                            b = b - c;
                        }
                    };

                    NWD = c;

                    if (NWD == 1)
                    {
                        Console.WriteLine("Pierwsza wylosowana liczba to " + pierwsza);
                        Console.WriteLine("Druga wylosowana liczba to " + druga);

                        watch.Stop();
                        Console.WriteLine("Czas potrzebny do wykonania tych dzialan " + watch.Elapsed);

                        break;
                    }
                    else
                    {
                        goto Losowanie2;
                    };
            };
            watch.Reset();
            Console.WriteLine("Czy chcesz powtórzyć czynność? ( 1-tak / 0-nie )");
            Int32 x = Int32.Parse(Console.ReadLine());
            if (x == 1) goto Poczatek;
        }
    }
}
