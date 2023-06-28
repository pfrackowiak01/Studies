using System;

namespace Instrukcja_4_zad_1
{
    class Program
    {
        static void Main(string[] args)
        {
            Int32 NWD=0, r=0, x=0, y=0;
            Console.WriteLine("Podaj a:");
            Int32 a = Int32.Parse(Console.ReadLine());
            Console.WriteLine("Podaj b:");
            Int32 b = Int32.Parse(Console.ReadLine());
            while(a!=b)
            {
                if (a > b) a -= b;
                else b -= a;
                NWD = a;
                x++;
            }
            while (b != 0)
            {
                r = a % b;
                a = b;
                b = r;
                NWD = a;
                y++;
            }
            Console.WriteLine("Przy pomocy różnic - NWD wynosi {0} i pętla wykonała się {1}", NWD, x);
            Console.WriteLine("Przy pomocy reszt z dzielenia - NWD wynosi {0} i pętla wykonała się {1}", NWD, y);
        }
    }
}
