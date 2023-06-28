using System;

namespace Instrukcja_6_zad_2
{
    public static class tools
    {
        public static Double log(Double x, Double p)
        {
            Double log = Math.Log(x, p);
            return log;
        }
        public static Double log2(this Double x, Double p)
        {
            Double log2 = Math.Log(x, p);
            return log2;
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            Double a, b, log;
            Console.WriteLine("Podaj podstawe logarytmu: ");
            a = Double.Parse(Console.ReadLine());
            Console.WriteLine("Podaj podstawe drugiego logarytmu: ");
            b = Double.Parse(Console.ReadLine());
            Console.WriteLine("----------------------------------");
            Console.WriteLine("Wariant a");
            for (a = 16; a <= 256; a += 16)
            {
                log = Math.Log(a) / Math.Log(b);
                Console.WriteLine("{0:N6}", log);
            }
            Console.WriteLine("----------------------------------");
            Console.WriteLine("Wariant b");
            for (a = 16; a <= 256; a += 16)
            {
                log = tools.log(a,b);
                Console.WriteLine("{0:N6}", log);
            }
            Console.WriteLine("----------------------------------");
            Console.WriteLine("Wariant c");
            for (a = 16; a <= 256; a += 16)
            {
                log = a.log2(b);
                Console.WriteLine("{0:N6}", log);
            }
        }
    }
}
