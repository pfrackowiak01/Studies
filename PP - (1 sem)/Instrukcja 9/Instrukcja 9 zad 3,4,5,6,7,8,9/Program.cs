using System;
using System.Collections.Generic;

namespace Instrukcja_9_zad_3_4_5_6_7_8_9
{
    class Temperature
    {
        public Temperature(double tm)
        {
            celsius = tm;
        }

        private double celsius;
        public double Celsius
        {
            get
            {
                return celsius;
            }
            set
            {
                celsius = value;
            }
        }
        public override string ToString()
        {
            return "Temp = " + celsius + " stopni Celsjusza";
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            
            // Zadanie 3 i 4
            Temperature Temp1 = new Temperature(1);
            Temperature Temp2 = new Temperature(1);

            Temp1.Celsius = 36.6;
            Temp2.Celsius = 18.2;

            Console.WriteLine("Temp obiekt1 wynosi: " + Temp1.Celsius);
            Console.WriteLine("Temp obiekt2 wynosi: " + Temp2.Celsius);

            double temp = Temp1.Celsius;
            Temp1.Celsius = Temp2.Celsius;
            Temp2.Celsius = temp;

            Console.WriteLine("Temp obiekt1 po zmianie wynosi: " + Temp1.Celsius);
            Console.WriteLine("Temp obiekt2 po zmianie wynosi: " + Temp2.Celsius);
            Console.ReadKey(true);
            
            
            //Zadanie 5,6,7,8,9
            bool exit = false;
            Temperature Temp = new Temperature(36.5); //{Celsius = 36.5}; // zad 7 
            List<Temperature> temp_list = new List<Temperature>();
            double tm;

            while (exit == false)
            {
                Console.WriteLine("set/get/exit/getf/setf/string/list_add/list_view");
                string command = Console.ReadLine();

                if (command == "set")
                {
                    Console.WriteLine("ustaw temperaturę:");
                    Temp.Celsius = double.Parse(Console.ReadLine());
                }
                else if (command == "get")
                {
                    Console.WriteLine("temperatura:");
                    Console.WriteLine(Temp.Celsius);
                }
                else if (command == "exit")
                {
                    exit = true;
                }
                else if (command == "setf")
                {
                    Console.WriteLine("ustaw temperaturę:");
                    Temp.Celsius = (double.Parse(Console.ReadLine()) - 32) / 1.8;
                }
                else if (command == "getf")
                {
                    Console.WriteLine("temperatura:");
                    Console.WriteLine((Temp.Celsius * 1.8) + 32);
                }
                else if (command == "string")//8
                {
                    Console.WriteLine(Temp.ToString());
                }
                else if (command == "list_add")//9
                {
                    Console.WriteLine("dodaj temperaturę do listy:");
                    tm = double.Parse(Console.ReadLine());
                    temp_list.Add(new Temperature(tm));
                }
                else if (command == "list_view")//9
                {
                    Console.WriteLine("lista:");
                    foreach (var Temperature in temp_list)  // zamiast var może być Temperature
                    {
                        Console.WriteLine("Temp: {0}", Temperature.Celsius);
                    }
                }
            }
            
        }
    }
}
