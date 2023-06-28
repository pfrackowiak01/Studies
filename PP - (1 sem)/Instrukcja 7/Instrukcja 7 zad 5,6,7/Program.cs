using System;

namespace Instrukcja_7_zad_5_6_7
{
    class Program
    {
        static void Main(string[] args)
        {
            String tekst, a;
            Int32 ile = 0, start = 0;
            Console.WriteLine("Podaj ciąg liczb rozdzielonymi przecinkami: ");
            tekst = Console.ReadLine();
            String[] tekst2 = tekst.Split(",");

            /*for (Int32 i = 0; i < tekst2.Length; i++)
            {
                Int32 liczba = Int32.Parse(tekst2[i]);
                Console.WriteLine("Kwadrat z {0} wynosi {1}", liczba, Math.Pow(liczba, 2));
            }
            */
            Int32[] tablica = new int[tekst2.Length];
            for (Int32 i = 0; i < tekst2.Length; i++)
            {
                a = tekst2[i];
                if (a == " ")
                {
                    tablica[i] = 0;
                    Console.WriteLine("Kwadrat z 0 wynosi 0");
                }
                else
                {
                    Int32 liczba = Int32.Parse(a);
                    tablica[i] = liczba;
                    Console.WriteLine("Kwadrat z {0} wynosi {1}", liczba, Math.Pow(liczba, 2));
                }
            }

            Console.WriteLine("=== Sprawdzenie tablicy ===");
            for (Int32 i = 0; i < tekst2.Length; i++)
            {
                Console.Write(tablica[i] + " ");
            }
            


            /*tekst += ",";
            for (int i = 0; i < tekst.Length; i++)
            {
                if (Char.IsDigit(tekst[i])) ile++;
                else
                {
                    start = i - ile;
                    a = tekst.Substring(start, ile);
                    if (a == " ") Console.WriteLine("Liczba 0 jej kwadrat to 0");
                    else
                    {
                        Int32 liczba = Int32.Parse(a);
                        Console.WriteLine("Liczba to {0} jej kwadrat to {1}", liczba, Math.Pow(liczba, 2));
                    }
                }
                ile = 0;
            }*/
        }
    }
}
