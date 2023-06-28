using System;
using System.IO;

namespace Instrukcja_8_zad_10_11
{
    class Program
    {
        static void Main(string[] args)
        {
            string path = Environment.GetFolderPath(Environment.SpecialFolder.Desktop);
            bool command_exit = false;
            while (!command_exit)
            {
                Console.WriteLine("Jesteś tutaj ===>   " + path);
                Console.WriteLine("Wpisz komendę (dir/cd/type/exit)");
                string command = Console.ReadLine();
                if (command == "dir")
                {
                    string[] file_list = Directory.GetFiles(path);
                    string[] dir_list = Directory.GetDirectories(path);
                    foreach (string dir in dir_list)
                    {
                        Console.WriteLine(dir);
                    }
                    foreach (string file in file_list)
                    {
                        Console.WriteLine(file);
                    }
                }
                else if (command == "cd")
                {
                    Console.WriteLine("Podaj lokalizację");
                    string cd = Console.ReadLine();
                    if (Directory.Exists(cd))
                    {
                        path = cd;
                    }
                    else
                    {
                        Console.WriteLine("Błąd: nie podano ścieżki lub ścieżka nie istnieje");
                    }
                }
                else if (command == "type")
                {
                    // zadanie 11
                    try
                    {
                        string type = Console.ReadLine();
                        using (StreamReader reader = File.OpenText(path + @"\" + type))
                        {
                            string text;
                            while ((text = reader.ReadLine()) != null)
                            {
                                Console.WriteLine(text);
                            }
                        }
                    }
                    catch (System.IO.FileNotFoundException)
                    {
                        Console.WriteLine("Błąd: plik o podanej nazwie nie istnieje");
                    }
                    catch (System.IO.DirectoryNotFoundException)
                    {
                        Console.WriteLine("Błąd: nie podano nazwy pliku");
                    }
                }
                else if (command == "exit")
                {
                    command_exit = true;
                }
            }
        }
    }
}
