using System;
using System.Globalization;

namespace Instrukcja_7_zad_8_9
{
    class Program
    {
        static void Main(string[] args)
        {
            int liczba = 21;
            CultureInfo coultureBrit = new CultureInfo("en-GB");
            string s;
            s = liczba.ToString("C", coultureBrit);
            {
                Console.WriteLine("{0} w walucie Brytyjskiej: {1}", liczba, s);
            }
            DateTime time = DateTime.Now;
            Console.WriteLine(time);
            Console.ReadKey(true);
        }
    }
}
