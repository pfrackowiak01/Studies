using System;

namespace Instrukcja_6_zad_21_22
{
    public static class Tools
    {
        public static Double Calka(Double a, Double b)
        {
            Double h, x = 0, n = 100000;
            h = (b - a) / n;
            for (int i = 1; i <= n; i++)
            {
                x += Math.Pow(a + i * h, 2);
            }
            x *= h;
            return x;
        }
        public delegate double Funkcja(Double a);
        public static Double CalkaFunkcja(Double a, Double b, Funkcja del)
        {
            Double h, x = 0, n = 100000;
            h = (b - a) / n;
            for (int i = 1; i <= n; i++)
            {
                x += del(a + i * h);
            }
            x *= h;
            return x;
        }
    }
        class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("=================================================");
            Console.WriteLine("Całka funkcji kwadratowej zad.21");
            Console.WriteLine("=================================================");
            Console.WriteLine("Podaj początek przedziału:");
            Double a = Int32.Parse(Console.ReadLine());
            Console.WriteLine("Podaj koniec przedziału:");
            Double b = Int32.Parse(Console.ReadLine());
            Console.WriteLine("=================================================");
            Console.WriteLine("Całka wynosi {0}", Tools.Calka(a, b));
            Console.WriteLine();
            Console.WriteLine();
            Console.WriteLine("=================================================");
            Console.WriteLine("Całka wybranej funkcji zad.22");
            Console.WriteLine("=================================================");
            Console.WriteLine("Podaj początek przedziału:");
            a = Int32.Parse(Console.ReadLine());
            Console.WriteLine("Podaj koniec przedziału:");
            b = Int32.Parse(Console.ReadLine());
            Console.WriteLine("=================================================");
            Tools.Funkcja del = (x) => x * x; //funkcja której całkę liczymy
            Console.WriteLine("Całka wynosi {0}", Tools.CalkaFunkcja(a, b, del));
            Console.ReadKey(true);
        }
    }
}
