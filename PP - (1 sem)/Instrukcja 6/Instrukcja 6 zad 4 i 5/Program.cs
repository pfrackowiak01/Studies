using System;

namespace Instrukcja_6_zad_4
{
    public static class tools
    {
        public static Double suma(Double x, Double y)
        {
            Double suma = x + y;
            return suma;
        }
        public static Double roznica(Double x, Double y)
        {
            Double roznica = x - y;
            return roznica;
        }
        public static Double iloczyn(Double x, Double y)
        {
            Double iloczyn = x * y;
            return iloczyn;
        }
        public static Double iloraz(Double x, Double y)
        {
            Double iloraz = x / y;
            return iloraz;
        }
            public static Double sumaR(this Double x, Double y)
            {
                Double suma = x + y;
                return suma;
            }
            public static Double roznicaR(this Double x, Double y)
            {
                Double roznica = x - y;
                return roznica;
            }
            public static Double iloczynR(this Double x, Double y)
            {
                Double iloczyn = x * y;
                return iloczyn;
            }
            public static Double ilorazR(this Double x, Double y)
            {
                Double iloraz = y / x;
                return iloraz;
            }
    }
        class Program
    {
        static void Main(string[] args)
        {
            Double a, b, c, delta, x1, x2, Re, Im;
            Console.WriteLine("Podaj a (różne od zera): ");
            a = Double.Parse(Console.ReadLine());
            Console.WriteLine("Podaj b: ");
            b = Double.Parse(Console.ReadLine());
            Console.WriteLine("Podaj c: ");
            c = Double.Parse(Console.ReadLine());

            /*
            if (a != 0)
            {
                delta = tools.roznica(tools.iloczyn(b, b), tools.iloczyn(tools.iloczyn(4, a), c));
                Console.WriteLine("delta " + delta);
                if (delta >= 0)
                {
                    delta = Math.Sqrt(delta);
                    x1 = tools.iloraz(tools.roznica(-b, delta), tools.iloczyn(2, a));
                    x2 = tools.iloraz(tools.roznica(-b, -delta), tools.iloczyn(2, a));

                    Console.WriteLine("Pierwiastki dla delty większej od 0");
                    Console.WriteLine("x1 = {0:N2}", x1);
                    Console.WriteLine("x2 = {0:N2}", x2);
                }
                /*else if (delta == 0)
                {
                    x1 = tools.iloraz(-b, tools.iloczyn(2, a));

                    Console.WriteLine("Pierwiastek dwukrotny dla delty równej 0");
                    Console.WriteLine("x = {0:N2}", x1);
                } 
                else
                {
                    Re = tools.iloraz(-b, tools.iloczyn(2, a));
                    Im = tools.iloraz(Math.Sqrt(-delta), tools.iloczyn(2, a));
                    Console.WriteLine("Pierwiastki dla delty mniejszej od 0");
                    Console.WriteLine("{0:N2} - {1:N2}i", Re, Im);
                    Console.WriteLine("{0:N2} + {1:N2}i", Re, Im);
                }
            }
            else Console.WriteLine("Niestety podana funkcja nie jest kwadratowa");
            */
            #region Zad 5
            if (a != 0)
            {
                Double v = Math.Pow(b, 2);
                delta = v.roznicaR(c.iloczynR(a.iloczynR(4)));
                Console.WriteLine("Delta " + delta);
                Double s = a.iloczynR(2);
                if (delta > 0)
                {
                    delta = Math.Sqrt(delta);
                    x1 = s.ilorazR((-b).sumaR(delta));
                    x2 = s.ilorazR((-b).sumaR(-delta));

                    Console.WriteLine("Pierwiastki dla delty większej od 0");
                    Console.WriteLine("x1 = {0:N2}", x1);
                    Console.WriteLine("x2 = {0:N2}", x2);
                }
                else if (delta == 0)
                {
                    x1 = s.ilorazR(-b);

                    Console.WriteLine("Pierwiastek dla delty równej 0");
                    Console.WriteLine("x = {0:N2}", x1);
                }
                else
                {
                    delta = Math.Sqrt(-delta);
                    Re = s.ilorazR(-b);
                    Im = s.ilorazR(delta);

                    Console.WriteLine("Pierwiastki dla delty mniejszej od 0");
                    Console.WriteLine("{0:N2} - {1:N2}i", Re, Im);
                    Console.WriteLine("{0:N2} + {1:N2}i", Re, Im);
                }
            }
            else Console.WriteLine("Niestety podana funkcja nie jest kwadratowa");
            #endregion
            
        }
    }
}
