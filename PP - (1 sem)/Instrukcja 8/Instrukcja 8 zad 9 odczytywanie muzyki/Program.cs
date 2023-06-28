using System;
using System.IO;

namespace Instrukcja_8_zad_9_odczytywanie_muzyki
{
    class Program
    {
        static void Main(string[] args)
        {
            string path = Environment.GetFolderPath(Environment.SpecialFolder.Desktop) + @"\tada.wav";
            FileStream stream = File.Open(path, FileMode.Open); // tworzenie strumienia
            BinaryReader binary = new BinaryReader(stream);
            byte[] bytetab = binary.ReadBytes(36);
            Console.WriteLine("Number of channels {0}", bytetab[22]); // liczba kanałów
            Console.WriteLine("Sample rate {0:X} kHz", bytetab[24]); // częstotliwość 
            Console.WriteLine("Bites per sample = {0}", bytetab[34]); // rozdzileczośc próbkowania
            Console.ReadKey(true);
        }
    }
}
