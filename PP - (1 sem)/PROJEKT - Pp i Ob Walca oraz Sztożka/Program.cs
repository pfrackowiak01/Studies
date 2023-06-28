using System;

namespace PROJEKT___Pp_i_Ob_Walca_oraz_Sztożka
{
    public static class Tools
    {
        public static Double Objetosc(Double promien, Double wysokosc)
        {
            Double ob = Math.Pow(promien, 2) * wysokosc;
            return ob;
        }
        public static Double PPWalca(Double promien, Double wysokosc)
        {
            Double pp = 2 *  promien * (wysokosc + promien);
            return pp;
        }
        public static Double PPStozka(Double promien, Double tworzaca)
        {
            Double pp = promien * (promien + tworzaca);
            return pp;
        }
        public static Double Dzialanie(Double walec, Double stozek)
        {
            Double wynik = (walec - stozek) / 4;
            return wynik;
        }
        public static Double BladR(Double r)
        {
            Double poprawione, promien = r;
            Console.WriteLine("===================== BŁĘDNY PROMIEŃ =====================");
            Console.WriteLine("      Nie uzupełniono danych lub podano złe parametry");
            Console.WriteLine("==========================================================");
            do
            {
                Console.WriteLine();
                Console.WriteLine("Proszę podać prawidłowy promień r większy od zera:");
                Console.Write("Nowy promień R = ");
                try { promien = Double.Parse(Console.ReadLine()); }
                catch { }
                poprawione = promien;
            } while (promien <= 0);
            Console.WriteLine();
            Console.WriteLine("       Promień R jest już prawidłowy i wynosi {0}.", promien);
            Console.WriteLine();
            Console.WriteLine("        Kliknij dowolny przycisk, aby kontynuować.");
            Console.WriteLine("==========================================================");
            Console.ReadKey();
            return poprawione;
        }
        public static Double BladH(Double h)
        {
            Double poprawione, wysokosc = h;
            Console.WriteLine("===================== BŁĘDNA WYSOKOŚĆ =====================");
            Console.WriteLine("      Nie uzupełniono danych lub podano złe parametry");
            Console.WriteLine("===========================================================");
            do
            {
                Console.WriteLine("");
                Console.WriteLine("Proszę podać prawidłową wysokość h większą od zera:");
                Console.Write("Nowa wysokość H = ");
                try { wysokosc = Double.Parse(Console.ReadLine()); }
                catch { }
                poprawione = wysokosc;
            } while (wysokosc <= 0);
            Console.WriteLine();
            Console.WriteLine("       Wysokość H jest już prawidłowa i wynosi {0}.", wysokosc);
            Console.WriteLine();
            Console.WriteLine("        Kliknij dowolny przycisk, aby kontynuować.");
            Console.WriteLine("==========================================================");
            Console.ReadKey();
            return poprawione;
        }
        public static Double BladDANE(Double blad)
        {
            Console.Clear();
            Console.WriteLine("============================== BŁĄD ===============================");
            Console.WriteLine();
            Console.WriteLine("          Dane jeszcze nie zostały przez ciebie podane.");
            Console.WriteLine();
            Console.WriteLine("--> Wpisz 'DD', żeby móc wrócić do zakładki dane i je uzupełnić <--");
            Console.WriteLine();
            Console.WriteLine("===================================================================");
            return blad;
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            ConsoleKeyInfo cki;
            Double h, r, l, ObWalca, ObStozka, PpWalca, PpStozka, OB, PP, blad = 0;
            goto reset;
        reset:
            h = 0;
            r = 0;
            l = 0;
            ObWalca = 0;
            ObStozka = 0;
            PpWalca = 0;
            PpStozka = 0;
            OB = 0;
            PP = 0;
        start:
            Console.Clear();
            Console.WriteLine("================================================================");
            Console.WriteLine("       PROGRAM DO WYLICZANIA OBJĘTOŚCI I POLA POWIERZCHNI");
            Console.WriteLine("                     DLA WALCA ORAZ STOŻKA");
            Console.WriteLine("================================================================");
            Console.WriteLine();
            Console.WriteLine("============================> MENU <============================");
            Console.WriteLine("Wciśnij klawisz: ");
            Console.WriteLine("? -  POMOC    - by dowiedzieć się do czego służy i jak działa program");
            Console.WriteLine("D -  DANE     - by wpisać dane");
            Console.WriteLine("Z -  ZADANIA  - by rozwiązać zadania");
            Console.WriteLine("C -  CLEAR    - by wyczyścić konsole i zachować dane");
            Console.WriteLine("X -  RESET    - by zresetować wszystkie dane");
            Console.WriteLine("Esc - EXIT    - by zakończyć działanie programu");
            Console.WriteLine("================================================================");
            do
            {
                Console.Write("MENU> ");
            wyjscie:
                cki = Console.ReadKey();
                if (cki.Key == ConsoleKey.Oem2)
                {
                    Console.WriteLine();
                    Console.WriteLine("=========================> POMOC/FAQ <==========================");
                    Console.WriteLine();
                    Console.WriteLine(" ---> Do czego służy program?");
                    Console.WriteLine();
                    Console.WriteLine("Program służy do obliczania objętości i pola powierzchni");
                    Console.WriteLine("takich brył jak walec oraz stożek. Posiada również dodatkowe");
                    Console.WriteLine("ZADANIE, które służy konkretnie do wyliczenia różnicy w ich");
                    Console.WriteLine("objętościach lub pól powierzchni i podzielenia wyniku przez 4.");
                    Console.WriteLine("Rzecz jasna różnica jest między walcem, a stożkiem.");
                    Console.WriteLine();
                    Console.WriteLine(" ---> Jak działa program?");
                    Console.WriteLine();
                    Console.WriteLine("Wpierw musisz przejść do zakładki DANE, by wpisać swoje");
                    Console.WriteLine("parametry (R,H) dla Walca i Stożka. Jest to konieczne, gdyż ");
                    Console.WriteLine("inaczej bez danych nie uzyskasz wyniku. Pamiętaj, by wprowadzić");
                    Console.WriteLine("promień oraz wysokość prawidłowo. Jedyny warunek - liczba musi");
                    Console.WriteLine("być większa od zera. Dozwolony jest ułamek z dwoma miejscami po przecinku.");
                    Console.WriteLine();
                    Console.WriteLine("Następnie przechodzisz do zakładni ZADANIA, by móc sprawdzić");
                    Console.WriteLine("swoje wyniki. Pamiętaj, że w każdym momencie możesz wrócić do danych");
                    Console.WriteLine("i je zmienić na inne.");
                    Console.WriteLine();
                    Console.WriteLine(" ---> Dlaczego DANE i ZADANIA zostały tak podzielone?");
                    Console.WriteLine();
                    Console.WriteLine("Ponieważ dzięki temu program wygląda ładniej i schludniej.");
                    Console.WriteLine("Ważne jest zadbanie o porządek, który stwarza przyjazne środowisko");
                    Console.WriteLine("dla użytkownika. Nie pogubisz się w wyświetlanych wiadomościach na ekranie.");
                    Console.WriteLine("Również dlatego została dodana opcja CLEAR, która czyści konsole.");
                    Console.WriteLine();
                    Console.WriteLine(" ---> Czy muszę wpisywać literki z Shiftem, jak chcę coś wybrać?");
                    Console.WriteLine();
                    Console.WriteLine("Nie, nie musisz. Program działa tak, że nie patrzy na wpisywany");
                    Console.WriteLine("przez ciebie znak, tylko na wciśnięty klawisz. 'D' czy 'd' nie robi różnicy.");
                    Console.WriteLine("Możesz również zamiast '?' pisać '/' i będzie działać ;)");
                    Console.WriteLine();
                    Console.WriteLine(" ---> Skąd mam mieć pewność czy działania i operacje matematyczne wykonają się dobrze?");
                    Console.WriteLine();
                    Console.WriteLine("W ZADANIA do wszystkich działań i obliczeń są zapisane parametry oraz wzory.");
                    Console.WriteLine("Więc wraz z wynikiem dostajesz jak na tacy cały proces rozwiązywania twojego zadania.");
                    Console.WriteLine("Całą legendę do znaków użytych tam znajdziesz w ZADANIA pod '?', więc możesz sam");
                    Console.WriteLine("w prosty sposób obliczyć czy wszystko się zgadza.");
                    Console.WriteLine();
                    Console.WriteLine(" --> Naciśnij 'C' by wyczyścić ekran i wrócić do samego MENU <--");
                    Console.WriteLine("=================================================================");
                }
                if (cki.Key == ConsoleKey.D)
                {
                dane:
                    Console.Clear();
                    Console.WriteLine("=========================> DANE <=========================");
                    Console.WriteLine("Wciśnij klawisz: ");
                    Console.WriteLine("? -  INFO     - by wyświetlić informacje na temat danych");
                    Console.WriteLine("W -  WYŚWIETL - by wyświetlić dane");
                    Console.WriteLine("D -  DANE     - by wpisać wszystkie dane");
                    Console.WriteLine("R -  PROMIEŃ  - by wpisać promień");
                    Console.WriteLine("H -  WYSOKOŚĆ - by wpisać wysokość");
                    Console.WriteLine("C -  CLEAR    - by wyczyścić konsole i zachować dane");
                    Console.WriteLine("Esc - EXIT    - by wrócić do menu");
                    Console.WriteLine("==========================================================");
                    do
                    {
                        Console.Write("MENU>DANE> ");
                        cki = Console.ReadKey();
                        if (cki.Key == ConsoleKey.Oem2)
                        {
                            Console.WriteLine();
                            Console.WriteLine("=========================> INFO <=========================");
                            Console.WriteLine("W tym miejscu wpisujesz swoje parametry dla Walca i Stożka.");
                            Console.WriteLine("         Pamiętaj, aby dane były większe od zera.");
                            Console.WriteLine("      Mogą być zapisane do dwóch miejsc po przecinku.");
                            Console.WriteLine("==========================================================");
                        }
                        if (cki.Key == ConsoleKey.W)
                        {
                            Console.WriteLine();
                            Console.WriteLine();
                            Console.WriteLine("Promień  R = {0:N2}", r);
                            Console.WriteLine("Wysokość H = {0:N2}", h);
                            if (r > 0 && h > 0)
                            {
                                Console.WriteLine();
                                Console.WriteLine("        Wszystkie dane są już wypełnione prawidłowo :)");
                                Console.WriteLine("         Program jest gotowy do wykonania zadań.");
                                Console.WriteLine();
                                Console.WriteLine("  --> Naciśnij Esc by wrócić do MENU i wybrać ZADANIA <--");
                                Console.WriteLine("==========================================================");
                            }
                            else
                            {
                                Console.WriteLine();
                                Console.WriteLine("        Dane jeszcze nie zostały uzupełnione.");
                                Console.WriteLine("By program mógł wykonać zadania, proszę o wpisanie danych.");
                                Console.WriteLine();
                                Console.WriteLine("==========================================================");
                            }
                        }
                        if (cki.Key == ConsoleKey.D)
                        {
                            Console.WriteLine();
                            Console.WriteLine();
                            Console.Write("Podaj nowy promień R = ");
                            try { r = Double.Parse(Console.ReadLine()); }
                            catch { }
                            Console.WriteLine();
                            if (r <= 0) r = Tools.BladR(r);
                            Console.Write("Podaj nową wysokość H = ");
                            try { h = Double.Parse(Console.ReadLine()); }
                            catch { }
                            Console.WriteLine();
                            if (h <= 0) h = Tools.BladH(h);
                            else Console.WriteLine("==========================================================");
                        }
                        if (cki.Key == ConsoleKey.R)
                        {
                            Console.WriteLine();
                            Console.WriteLine();
                            Console.Write("Podaj nowy promień R = ");
                            try { r = Double.Parse(Console.ReadLine()); }
                            catch { }
                            Console.WriteLine();
                            if (r <= 0)
                            {
                                r = Tools.BladR(r);
                                goto dane;
                            }
                        else Console.WriteLine("==========================================================");
                        }
                        if (cki.Key == ConsoleKey.H)
                        {
                            Console.WriteLine();
                            Console.WriteLine();
                            Console.Write("Podaj nową wysokość H = ");
                            try { h = Double.Parse(Console.ReadLine()); }
                            catch { }
                            Console.WriteLine();
                            if (h <= 0)
                            {
                                h = Tools.BladH(h); ;
                                goto dane;
                            }
                            else Console.WriteLine("==========================================================");
                        }
                        if (cki.Key == ConsoleKey.C) goto dane;
                    } while (cki.Key != ConsoleKey.Escape);
                    goto start;
                }
                if (cki.Key == ConsoleKey.Z)
                {
                    zadania:
                    Console.Clear();
                    Console.WriteLine("==================================> ZADANIA <================================");
                    Console.WriteLine("Wciśnij klawisz: ");
                    Console.WriteLine("?  -  INFO     - by wyświetlić informacje na temat zadań");
                    Console.WriteLine("DD -  DANE     - by wpisać/zmienić dane - przechodzi do DANE (kliknij dwókrotnie D)");
                    Console.WriteLine("W  -  WALEC    - by obliczyć objętość i pole powierzchni Walca");
                    Console.WriteLine("S  -  STOŻEK   - by obliczyć objętość i pole powierzchni Stożka");
                    Console.WriteLine("O  -  zad. OB. - by obliczyć różnicę Objętości podzieloną przez 4 między walcem a stożkiem");
                    Console.WriteLine("P  -  zad. PP. - by obliczyć różnicę Pól Powierzchni podzielonych przez 4 między walcem a stożkiem");
                    Console.WriteLine("C  -  CLEAR    - by wyczyścić konsole i zachować dane");
                    Console.WriteLine("Esc - EXIT     - by wrócić do menu");
                    Console.WriteLine("=============================================================================");
                    do
                    {
                        Console.Write("MENU>ZADANIA> ");
                        cki = Console.ReadKey();
                        if (cki.Key == ConsoleKey.Oem2)
                        {
                            Console.WriteLine("");
                            Console.WriteLine("==============================> INFO <==============================");
                            Console.WriteLine();
                            Console.WriteLine("W 'ZADANIA' możesz obliczyć objętość (V)");
                            Console.WriteLine("i pole powierzchni (Pp) dla Walca oraz Stożka.");
                            Console.WriteLine();
                            Console.WriteLine("Legenda:");
                            Console.WriteLine("R = Promień podstawy");
                            Console.WriteLine("H = Wysokość bryły");
                            Console.WriteLine("L = Tworząca stożka");
                            Console.WriteLine("V = Objętość bryły (zapisane też jako Ob lub OB)");
                            Console.WriteLine("Pp = Pole powierzchni całkowite");
                            Console.WriteLine("PI = Wartość liczby Pi (W zaokrągleniu 3,14)");
                            Console.WriteLine("^2 = Podnoszenie do potęgi drugiej, czyli do kwadratu");
                            Console.WriteLine("Sqrt = Pierwiastek");
                            Console.WriteLine("zad. OB. = Najpierw liczy różnice objętości między Walcem,");
                            Console.WriteLine("           a Stożkiem. Potem dzieli przez 4 i zwraca wynik.");
                            Console.WriteLine("zad. PP. = Najpierw liczy różnice pola powierzchni między Walcem,");
                            Console.WriteLine("           a Stożkiem. Potem dzieli przez 4 i zwraca wynik.");
                            Console.WriteLine("jednostek = tu podstawiasz swoje jednostki (np. mm, cm, dm, m, km)");
                            Console.WriteLine();
                            Console.WriteLine("                         Pamiętaj!");
                            Console.WriteLine("   Miej już uzupełnione dane, aby móc obliczyć zadania!");
                            Console.WriteLine("   Jeśli ich jeszcze nie podałeś to wróć do DANE w MENU");
                            Console.WriteLine();
                            Console.WriteLine("            Dane muszą być większe od zera.");
                            Console.WriteLine("      Mogą być zapisane do dwóch miejsc po przecinku.");
                            Console.WriteLine();
                            Console.WriteLine("====================================================================");
                        }
                        if (cki.Key == ConsoleKey.W)
                        {
                            if (r <= 0 && h <= 0) blad = Tools.BladDANE(blad);
                            else
                            {
                                Console.WriteLine();
                                Console.WriteLine("============================= Wyniki dla Walca ==============================");
                                Console.WriteLine();
                                Console.WriteLine("Promień  R = {0:N2} jednostek", r);
                                Console.WriteLine("Wysokość H = {0:N2} jednostek", h);
                                ObWalca = Tools.Objetosc(r, h);
                                Console.WriteLine("Objętość V = R^2 * H * PI = {0:N2}^2 * {1:N2} * PI = {2:N2} PI = {3:N2} jednostek^3", r, h, ObWalca, Math.PI * ObWalca);
                                PpWalca = Tools.PPWalca(r, h);
                                Console.WriteLine("Pole powierzchni Pp = 2 * R * (R + H) * PI = 2 * {0:N2} * ({0:N2} + {1:N2}) * PI = {2:N2} PI = {3:N2} jednostek^2", r, h, PpWalca, Math.PI * PpWalca);
                                Console.WriteLine();
                                Console.WriteLine("=============================================================================");
                            }
                        }
                        if (cki.Key == ConsoleKey.S)
                        {
                            if (r <= 0 && h <= 0) blad = Tools.BladDANE(blad);
                            else
                            {
                                Console.WriteLine();
                                Console.WriteLine("============================= Wyniki dla Stożka =============================");
                                Console.WriteLine();
                                Console.WriteLine("Promień  R = {0:N2} jednostek", r);
                                Console.WriteLine("Wysokość H = {0:N2} jednostek", h);
                                l = Math.Sqrt(Math.Pow(r, 2) + Math.Pow(h, 2));
                                Console.WriteLine("Tworząca L = Sqrt(R^2 + H^2) = Sqrt({0:N2}^2 + {1:N2}^2) = {2:N2} jednostek", r, h, l);
                                ObStozka = Tools.Objetosc(r, h) / 3;
                                Console.WriteLine("Objętość V = R^2 * H * PI/3 = {0:N2}^2 * {1:N2} * PI/3 = {2:N2} PI = {3:N2} jednostek^3", r, h, ObStozka, Math.PI * ObStozka);
                                PpStozka = Tools.PPStozka(r, l);
                                Console.WriteLine("Pole powierzchni Pp = R * (R + L) * PI = {0:N2} * ({0:N2} + {1:N2}) * PI = {2:N2} PI = {3:N2} jednostek^2", r, l, PpStozka, Math.PI * PpStozka);
                                Console.WriteLine();
                                Console.WriteLine("=============================================================================");
                            }
                        }
                        if (cki.Key == ConsoleKey.O)
                        {
                            if (r <= 0 && h <= 0) blad = Tools.BladDANE(blad);
                            else
                            {
                                Console.WriteLine();
                                Console.WriteLine("================================ Zadanie Ob. ================================");
                                Console.WriteLine();
                                ObWalca = Tools.Objetosc(r, h);
                                ObStozka = Tools.Objetosc(r, h) / 3;
                                OB = Tools.Dzialanie(ObWalca, ObStozka);
                                Console.WriteLine("[V(walca) - V(stożka)] / 4 = ({0:N2} - {1:N2}) * PI / 4 = {2:N2} PI = {3:N2} jednostek^3", ObWalca, ObStozka, OB, OB * Math.PI);
                                Console.WriteLine();
                                Console.WriteLine("=============================================================================");
                            }
                        }
                        if (cki.Key == ConsoleKey.P)
                        {
                            if (r <= 0 && h <= 0) blad = Tools.BladDANE(blad);
                            else
                            {
                                Console.WriteLine();
                                Console.WriteLine("================================ Zadanie Pp. ================================");
                                Console.WriteLine();
                                PpWalca = Tools.PPWalca(r, h);
                                l = Math.Sqrt(Math.Pow(r, 2) + Math.Pow(h, 2));
                                PpStozka = Tools.PPStozka(r, l);
                                PP = Tools.Dzialanie(PpWalca, PpStozka);
                                Console.WriteLine("[Pp(walca) - Pp(stożka)] / 4 = ({0:N2} - {1:N2}) * PI / 4 = {2:N2} PI = {3:N2} jednostek^2", PpWalca, PpStozka, PP, PP * Math.PI);
                                Console.WriteLine();
                                Console.WriteLine("=============================================================================");
                            }
                        }
                        if (cki.Key == ConsoleKey.C) goto zadania;
                        if (cki.Key == ConsoleKey.D) goto wyjscie;
                    } while (cki.Key != ConsoleKey.Escape);
                    goto start;
                }
                if (cki.Key == ConsoleKey.C) goto start;
                if (cki.Key == ConsoleKey.X) goto reset;
            } while (cki.Key != ConsoleKey.Escape);
            Console.Clear();
            Console.WriteLine("==================================================================");
            Console.WriteLine("Dziękujemy za skorzystanie z programu, widzimy się następnym razem.");
            Console.WriteLine("                          Miłego dnia :D");
            Console.WriteLine();
            Console.WriteLine("               Czy na pewno chcesz zamknąć program?");
            Console.WriteLine("                      T - Tak    /    N - Nie");
            Console.WriteLine("==================================================================");
            do
            {
                cki = Console.ReadKey();
                if (cki.Key == ConsoleKey.N)
                {
                    Console.Clear();
                    Console.WriteLine("===========================================================");
                    Console.WriteLine("  Czy chcesz przywrócić swój projekt, czy rozpocząć nowy?");
                    Console.WriteLine();
                    Console.WriteLine("               P - Przywróć    /    N - Nowy");
                    Console.WriteLine("===========================================================");
                    do
                    {
                        Console.Write("> ");
                        cki = Console.ReadKey();
                        if (cki.Key == ConsoleKey.P) goto start;
                        if (cki.Key == ConsoleKey.N) goto reset;
                    } while (cki.Key != ConsoleKey.Escape);
                }
            } while (cki.Key != ConsoleKey.T);
        }
    }
}
