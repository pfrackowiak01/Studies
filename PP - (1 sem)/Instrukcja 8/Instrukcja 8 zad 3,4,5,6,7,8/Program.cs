using System;
using System.IO;

namespace Instrukcja_8_zad_3_4_5_6_7_8
{
    class Program
    {
        static void Main(string[] args)
        {
            string desktop_path = Environment.GetFolderPath(Environment.SpecialFolder.Desktop);
            string user_filename;

            Console.WriteLine(@"Podaj nazwę pliku bez rozszerzenia albo z (nazwa pliku to 'plik')");
            user_filename = Console.ReadLine();
            if (!user_filename.EndsWith(".txt")) user_filename += ".txt"; // sprawdza zakończenie stringa
            //string file_path = desktop_path + @"\"+user_filename;
            string file_path = Path.Combine(desktop_path, user_filename); // tworzenie ścieżki za pomocą path combine 

            try // spróbuj
            {
                using (StreamReader reader = File.OpenText(file_path))
                {
                    string text;
                    int temp;
                    while ((text = reader.ReadLine()) != null)
                    {
                        foreach (char s in text) // dla każdego elementu w tablicy
                        {
                            if (char.IsDigit(s))
                            {
                                temp = Convert.ToInt32(s);
                                Console.WriteLine(s + " kwadrat tej liczby to " + Math.Pow(temp - 48, 2));
                            }
                        }
                        Console.WriteLine("");
                    }
                }
            }
            catch (System.IO.FileNotFoundException) // złap ten błąd
            {
                Console.WriteLine("plik o podanej nazwie nie istnieje");
            }
            Console.ReadKey(true);
        }
    }
}
