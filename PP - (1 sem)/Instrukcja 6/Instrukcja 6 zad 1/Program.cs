using System;

namespace Instrukcja_6_zad_1
{
    public static class tools
    {
        public static Double deg2rad(Double fi)
        {
            Double rad = (fi * Math.PI) / 180;
            return rad;
        }
        public static Double SinFmDeg(Double fi)
        {
            Double rad = Math.Sin((fi * Math.PI) / 180);
            return rad;
        }
        public static Double CosFmDeg(Double fi)
        {
            Double rad = Math.Cos((fi * Math.PI) / 180);
            return rad;
        }
        public static Double SinFmDeg2(this Double fi)
        {
            Double rad = Math.Sin((fi * Math.PI) / 180);
            return rad;
        }
        public static Double cosFmDeg2(this Double fi)
        {
            Double rad = Math.Cos((fi * Math.PI) / 180);
            return rad;
        }
    }
    class Program
    {


        static void Main(string[] args)
        {
            Double sinus, cosinus, a;

            #region a)
            Console.WriteLine("wariant a)");
            Console.WriteLine("stopnie      sinusy          cosinusy");
            for (a = 0; a <= 90; a += 10)
            {
                if (a == 0)
                {
                    sinus = Math.Sin((a * Math.PI) / 180);
                    cosinus = Math.Cos((a * Math.PI) / 180);
                    Console.WriteLine("{0}           {1:N6}         {2:N6}", a, sinus, cosinus);
                    a += 10;
                }
                while (a <= 90)
                {
                    Console.Write(a);
                    sinus = Math.Sin((a * Math.PI) / 180);
                    Console.Write("          {0:N6}", sinus);
                    cosinus = Math.Cos((a * Math.PI) / 180);
                    Console.WriteLine("         {0:N6}", cosinus);
                    a += 10;
                }
            }
            Console.WriteLine();
            #endregion

            #region b)
            Console.WriteLine("wariant b)");
            Console.WriteLine("stopnie      sinusy          cosinusy");
            for (a = 0; a <= 90; a += 10)
            {
                if (a == 0)
                {
                    sinus = Math.Sin(tools.deg2rad(a));
                    cosinus = Math.Cos(tools.deg2rad(a));
                    Console.WriteLine("{0}           {1:N6}         {2:N6}", a, sinus, cosinus);
                }
                else
                {
                    Console.Write(a);
                    sinus = Math.Sin(tools.deg2rad(a));
                    Console.Write("          {0:N6}", sinus);
                    cosinus = Math.Cos(tools.deg2rad(a));
                    Console.WriteLine("         {0:N6}", cosinus);
                }

            }
            Console.WriteLine();
            #endregion

            #region c)
            Console.WriteLine("wariant c)");
            Console.WriteLine("stopnie      sinusy          cosinusy");
            for (a = 0; a <= 90; a += 10)
            {
                if (a == 0)
                {
                    sinus = tools.SinFmDeg(a);
                    cosinus = tools.CosFmDeg(a);
                    Console.WriteLine("{0}           {1:N6}         {2:N6}", a, sinus, cosinus);
                }
                else
                {
                    Console.Write(a);
                    sinus = tools.SinFmDeg(a);
                    Console.Write("          {0:N6}", sinus);
                    cosinus = tools.CosFmDeg(a);
                    Console.WriteLine("         {0:N6}", cosinus);
                }

            }
            Console.WriteLine();
            #endregion)

            #region d)
            Console.WriteLine("wariant d)");
            Console.WriteLine("stopnie      sinusy          cosinusy");
            for (a = 0; a <= 90; a += 10)
            {
                if (a == 0)
                {
                    sinus = a.SinFmDeg2();
                    cosinus = a.cosFmDeg2();
                    Console.WriteLine("{0}           {1:N6}         {2:N6}", a, sinus, cosinus);
                }
                else
                {
                    Console.Write(a);
                    sinus = a.SinFmDeg2();
                    Console.Write("          {0:N6}", sinus);
                    cosinus = a.cosFmDeg2();
                    Console.WriteLine("         {0:N6}", cosinus);
                }
            }
            #endregion
        }
    }
}