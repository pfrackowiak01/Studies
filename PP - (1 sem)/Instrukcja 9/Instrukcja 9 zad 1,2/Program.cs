using System;
using System.Collections.Generic;

namespace Instrukcja_9_zad_1_2
{
    /*struct Temperature
    {
        public double Celsius;
    }*/
    class Temperature
    {
        public double Celsius;
    }
    class Program
    {
        static void Main(string[] args)
        {
            Temperature Temp1 = new Temperature();
            Temperature Temp2 = new Temperature();
            Temp1.Celsius = 36.6;
            Temp2.Celsius = Temp1.Celsius;

            Console.WriteLine("Temp struktury 2 = " + Temp2.Celsius);
            Console.ReadKey(true);
        }
    }
}
