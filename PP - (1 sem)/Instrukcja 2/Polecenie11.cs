using System;

namespace FOR_Polecenie11
{
    class Program
    {
        static void Main(string[] args)
        {
            double w, a, i = 0;
            Random liczba = new Random();
            a = liczba.Next(0, 100);

            do
            {
                Console.WriteLine("Proszę podać liczbę");
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
                    Console.ReadKey(true);
                }
                else
                {
                    Console.WriteLine("Niestety... Musisz spróbować dać troszkę mniej.");
                    Console.WriteLine("To była próba numer {0}, zostało ci jeszcze podejść {1}", i, 6 - i);
                    Console.ReadKey(true);
                }
            }
            while (i <= 6);
            Console.WriteLine("Niestety... Przegrałeś, może następnym razem się poszczęści ;)");
            Console.WriteLine("Spróbuj jeszcze raz");


        }
    }
}