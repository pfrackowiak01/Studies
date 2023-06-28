using System;

namespace Instrukcja_6_zad_3
{
    public static class tools
    {
        public static Double suma(Double x, Double y)
        {
            Double suma = x + y;
            return suma;
        }

    }
    class Program
    {
        static void Main(string[] args)
        {
            Double a, b, A, B, C, D;
            Console.WriteLine("Podaj a ");
            a = Double.Parse(Console.ReadLine());
            Console.WriteLine("Podaj b ");
            b = Double.Parse(Console.ReadLine());
            Console.WriteLine("----------------------------------");

            Console.WriteLine("A) Przykład 2a + 3b");
            A = tools.suma( 2*a , 3*b );
            Console.WriteLine("{0:N6}", A);

            Console.WriteLine("----------------------------------");

            Console.WriteLine("B) Przykład ab + 7");

            B = tools.suma( a*b , 7 );
            Console.WriteLine("{0:N6}", B);

            Console.WriteLine("----------------------------------");
            Console.WriteLine("C) Przykład pierwiastek z a + kwadrat z b");

            C = tools.suma( Math.Sqrt(a) , b*b );
            Console.WriteLine("{0:N6}", C);

            Console.WriteLine("----------------------------------");
            Console.WriteLine("D) a + b + 1");

            D = tools.suma(tools.suma( a , b ), 1);
            Console.WriteLine("{0:N6}", D);

        }
    }
}
