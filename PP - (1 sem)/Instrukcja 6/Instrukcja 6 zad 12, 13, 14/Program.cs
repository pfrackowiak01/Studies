using System;

namespace Instrukcja_6_zad_12__13__14
{
    public static class Tools
    {
        public static Int32 Fib1(Int32 n1)
        {
                if (n1 <= 2)
                    return 1;
                else
                    return Fib1(n1 - 1) + Fib1(n1 - 2);
        }
        public static Int32 Fib2(Int32 n1)
        {
            int a = 1, b = 1, c = 0;
            if (n1 == 1 || n1 == 2) return 1;
            for (int i = 2; i < n1; i++)
            {
                c = a + b;
                a = b;
                b = c;
            }
            return c;
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            int n;
            System.Diagnostics.Stopwatch watch;

            Console.WriteLine("Jak długi ma być ciąg: ");
            n = Int32.Parse(Console.ReadLine());
            Console.WriteLine("-------------- zad 12 i 13 --------------");
            Console.WriteLine("---=  FIBONACCI z rekurencją  =---");
            Console.WriteLine("-----------------------------------------");
            for (int i = 1; i <= n; i++)
            {
                watch = System.Diagnostics.Stopwatch.StartNew();
                Console.Write("{0} wyraz ciągu Fibonacciego: {1}", i, Tools.Fib1(i));
                watch.Stop();
                Console.WriteLine("   Czas: {0}", watch.Elapsed);
                watch.Restart();
            }
            Console.WriteLine();
            Console.WriteLine("---------------- zad 14 ----------------");
            Console.WriteLine("---=  FIBONACCI bez rekurencji  =---");
            Console.WriteLine("----------------------------------------");
            for (int i = 1; i <= n; i++)
            {
                watch = System.Diagnostics.Stopwatch.StartNew();
                Console.Write("{0} wyraz ciągu Fibonacciego: {1}", i, Tools.Fib2(i));
                watch.Stop();
                Console.WriteLine("   Czas: {0}", watch.Elapsed);
                watch.Restart();
            }
        }
    }
}
