using System;

namespace Instrukcja_7_zad_1_2_3_4
{
    class Program
    {
        static void Main(string[] args)
        {
            string s;
            Console.WriteLine("Wpisz łańcuch znaków:");
            String a = Console.ReadLine();
            Console.WriteLine("Wszystkie cyfry to");
            if (char.IsDigit(a, 0)) Console.Write(a[0]);
            for (int i = 1; i < a.Length; i++)
            {
                if (a[i] == 'e' && char.IsDigit(a, i - 1))
                {
                    if (char.IsDigit(a, i + 1))
                    {
                        s = 'e' + a[i + 1].ToString();
                        Console.Write(s);
                        i = i + 2;
                    }
                }
                if (a[i] == 'e' && char.IsDigit(a, i - 1) && a[i+1] == '-' && char.IsDigit(a, i + 2))
                {
                    s = "e-" + a[i + 2].ToString();
                    Console.Write(s);
                    i = i + 3;
                }
                if (a[i] == ',' && char.IsDigit(a, i - 1) && char.IsDigit(a, i + 1)) Console.Write(a[i]);
                if (char.IsDigit(a, i))
                {
                    if (char.IsDigit(a, i - 1)) Console.Write(a[i]);
                    else Console.Write(" " + a[i]);
                }
            }
        }
    }
}
