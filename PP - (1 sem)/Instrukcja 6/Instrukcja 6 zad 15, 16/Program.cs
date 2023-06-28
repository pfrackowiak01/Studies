using System;

namespace Instrukcja_6_zad_15__16
{
    public delegate int Delegacja(int a, int b);

    public static class Tools
    {
        public static int Suma(int a, int b)
        {
            return a + b;
        }
        public static int Iloczyn(int a, int b)
        {
            return a * b;
        }
    }

        class Program
    {
        static void Main(string[] args)
        {

            int a, b, c;
            Console.WriteLine("Podaj pierwszą liczbę: ");
            a = int.Parse(Console.ReadLine());
            Console.WriteLine("Podaj drugą liczbę: ");
            b = int.Parse(Console.ReadLine());

            Delegacja delegacja = new Delegacja(Tools.Suma);
            //Delegacja Lambda = new Delegacja(Tools.Suma2);


            Console.WriteLine("Napisz: ");
            Console.WriteLine("0: Jeżeli chcesz liczyć przez delegacje");
            Console.WriteLine("1: Jeżeli chcesz liczyć przez wyrażenie lambda");
            c = int.Parse(Console.ReadLine());
            switch(c)
            {
                case 0:
                    {
                        Console.WriteLine("========= DELEGACJA =========");
                        Console.WriteLine("Suma: {0} + {1} = {2}", a, b, delegacja(a, b));
                        delegacja = Tools.Iloczyn;
                        Console.WriteLine("Iloczyn: {0} * {1} = {2}", a, b, delegacja(a, b));

                    }
                    break;
                case 1:
                    {
                        Console.WriteLine("======== WYRAŻENIE LAMBDA ========");
                        Func<int, int, int> lambdasuma = (a, b) => a + b;
                        Console.WriteLine("Suma: {0} + {1} = {2}", a, b, lambdasuma(a, b));
                        Func<int, int, int> lambdailoczyn = (a, b) => a * b;
                        Console.WriteLine("Iloczyn: {0} * {1} = {2}", a, b, lambdailoczyn(a, b));
                    }
                    break;
            }
             

        }
    }
}
