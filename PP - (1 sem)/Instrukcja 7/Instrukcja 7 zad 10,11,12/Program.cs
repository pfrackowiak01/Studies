using System;

namespace Instrukcja_7_zad_10_11_12
{
    class Program
    {
        static void Main(string[] args)
        {
            /*Console.WriteLine("======= Zadanie 10 ========");
            ConsoleKeyInfo cki;
            do
            {
                cki = Console.ReadKey();
                if ((cki.Modifiers & ConsoleModifiers.Alt) != 0) Console.Write(" ALT+");
                if ((cki.Modifiers & ConsoleModifiers.Shift) != 0) Console.Write(" SHIFT+");
                if ((cki.Modifiers & ConsoleModifiers.Control) != 0) Console.Write(" CTRL+");
                Console.WriteLine(cki.Key.ToString());
            } while (cki.Key != ConsoleKey.Escape);
            */
            Console.WriteLine("======= Zadanie 11 i 12 ========");

            ConsoleKeyInfo cki;
            int a = 0, b = 0, c = 0, temp = 0;
            Console.WriteLine("===============================");
            Console.WriteLine("? - menu");
            Console.WriteLine("a - wczytuje pierwszą liczbę");
            Console.WriteLine("b - wczytuje drugą liczbę");
            Console.WriteLine("+ - oblicza sumę a i b");
            Console.WriteLine("* - oblicza iloczyn a i b");
            Console.WriteLine("x - wyjście");
            Console.WriteLine("===============================");
            do
            {
            cki = Console.ReadKey();
                if (cki.Key == ConsoleKey.A)
                {
                    Console.WriteLine("");
                    Console.WriteLine("Podaj pierwszą liczbę:");
                    a = int.Parse(Console.ReadLine());
                }
                if (cki.Key == ConsoleKey.B)
                {
                    Console.WriteLine("");
                    Console.WriteLine("Podaj drugą liczbę:");
                    b = int.Parse(Console.ReadLine());
                }
                if (cki.Key == ConsoleKey.Add)
                {
                    Console.WriteLine("");
                    temp = a + b;
                    Console.WriteLine("SUMA: {0} + {1} = {2}", a, b, temp);
                }
                if (cki.Key == ConsoleKey.Multiply)
                {
                    Console.WriteLine("");
                    temp = a * b;
                    Console.WriteLine("ILOCZYN: {0} * {1} = {2}", a, b, temp);
                }
                if (cki.Key == ConsoleKey.Oem2)
                {
                    Console.WriteLine("");
                    Console.WriteLine("===============================");
                    Console.WriteLine("? - menu");
                    Console.WriteLine("a - wczytuje pierwszą liczbę");
                    Console.WriteLine("b - wczytuje drugą liczbę");
                    Console.WriteLine("+ - oblicza sumę a i b");
                    Console.WriteLine("* - oblicza iloczyn a i b");
                    Console.WriteLine("x - wyjście");
                    Console.WriteLine("===============================");
                }

            } while (cki.Key != ConsoleKey.X);
            Console.WriteLine("");
            Console.ReadKey(true);
            
        }
    }
}
