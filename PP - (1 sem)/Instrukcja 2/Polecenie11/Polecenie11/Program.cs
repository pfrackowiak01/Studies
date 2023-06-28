using System;

namespace Polecenie11
{
    class Program
    {
        static void Main(string[] args)
        {
            double w, a, i = 0;
            Random liczba = new Random();
            a = liczba.Next(0, 100);
            Console.WriteLine("Odgadnij jaką liczbę mam na myśli... Pomiędzy 0, a 100, lecz masz tylko 6 prób >:)");
            //Console.WriteLine("Wylosowana liczba {0}", a);
            do
            {
                Console.WriteLine("Proszę podać liczbę:");
                w = Double.Parse(Console.ReadLine());
                i = i + 1;
                if (w == a)
                {
                    Console.WriteLine("To była próba numer {0}", i);
                    Console.WriteLine("Gratulacje! Wygrałeś! Zgadłeś liczbe {0}", a);
                    break;
                }
                if (w < a)
                {
                    Console.WriteLine("Niestety... Musisz spróbować dać troszkę więcej.");
                    Console.WriteLine("To była próba numer {0}, zostało ci jeszcze podejść {1}", i, 6 - i);
                }
                else
                {
                    Console.WriteLine("Niestety... Musisz spróbować dać troszkę mniej.");
                    Console.WriteLine("To była próba numer {0}, zostało ci jeszcze podejść {1}", i, 6 - i);
                }
            }
            while (i < 6);
            if (w != a) Console.WriteLine("Niestety... Przegrałeś, wyczerpałeś liczbę prób. Może następnym razem się poszczęści ;)");
            Console.WriteLine("Jak chcesz to możesz spróbować jeszcze raz :D");

        }
    }
}