using System;
using System.IO;
using System.Text;

namespace Instrukcja_8_1_2
{
    class Program
    {
        static void Main(string[] args)
        {
            /*
            Console.WriteLine("=== Zad 1 ===");
            string desktop_path = Environment.GetFolderPath(Environment.SpecialFolder.Desktop);
            string file_path = desktop_path + @"\plik.txt";

            StreamWriter writer; // tworzymy obiekt do pisania w pliku
            writer = new StreamWriter(file_path, File.Exists(file_path));
            //nadpisujemy parametry obiektu 
            //jeżeli plik istnieje dane są dopisane
            //jeżeli nie plik zostanie nadpisany

            Console.WriteLine("text:");
            string text = Console.ReadLine();
            writer.WriteLine(text);
            writer.Close();

            Console.ReadKey(true);
            */
            
            Console.WriteLine("=== Zad 2 ===");
            string desktop_path = Environment.GetFolderPath(Environment.SpecialFolder.Desktop);
            string file_path = desktop_path + @"\plik.txt";
            StreamWriter writer; // tworzymy obiekt do pisania w pliku
            string text;
            Encoding ascii = Encoding.ASCII;
            Encoding unicode = Encoding.Unicode;
            Encoding utf7 = Encoding.UTF7;
            Encoding utf8 = Encoding.UTF8;
            Encoding winiso = Encoding.GetEncoding("windows-1250");
            Encoding iso = Encoding.GetEncoding("iso08859-2");
            writer = new StreamWriter(file_path, File.Exists(file_path));
            bool end = true;
            do
            {
                text = Console.ReadLine();
                if (text == "stop")
                {
                    end = false;
                }
                else
                {
                    byte[] text_as_byte = unicode.GetBytes(text); // zamienia text na bajty 

                    //ascii
                    byte[] ASCII_as_byte = Encoding.Convert(unicode, ascii, text_as_byte); // zamiana na ucicode 
                    char[] ASCII_Chars = new char[ascii.GetCharCount(ASCII_as_byte, 0, ASCII_as_byte.Length)]; //zmiana na char
                    ascii.GetChars(ASCII_as_byte, 0, ASCII_as_byte.Length, ASCII_Chars, 0);
                    string asciiString = new string(ASCII_Chars); // zmiana na string 

                    // utf7
                    byte[] u7Bajty = Encoding.Convert(unicode, utf7, text_as_byte); // zamiana na utf7
                    char[] utf7Chars = new char[utf7.GetCharCount(u7Bajty, 0, u7Bajty.Length)]; //zmiana na char
                    utf7.GetChars(u7Bajty, 0, u7Bajty.Length, utf7Chars, 0);
                    string utf7String = new string(ASCII_Chars); // zmiana na string 

                    byte[] u8Bajty = Encoding.Convert(unicode, utf8, text_as_byte);
                    char[] utf8Chars = new char[utf8.GetCharCount(u8Bajty, 0, u8Bajty.Length)];
                    utf8.GetChars(u8Bajty, 0, u8Bajty.Length, utf8Chars, 0);
                    string utf8String = new string(ASCII_Chars);
                    
                    byte[] winisoBajty = Encoding.Convert(unicode, winiso, text_as_byte);
                    char[] winisoChars = new char[winiso.GetCharCount(winisoBajty, 0, winisoBajty.Length)];
                    winiso.GetChars(u7Bajty, 0, u7Bajty.Length, winisoChars, 0);
                    string winisoString = new string(ASCII_Chars);

                    byte[] isoBajty = Encoding.Convert(unicode, iso, text_as_byte);
                    char[] isoChars = new char[iso.GetCharCount(isoBajty, 0, isoBajty.Length)];
                    iso.GetChars(isoBajty, 0, isoBajty.Length, isoChars, 0);
                    string isoString = new string(ASCII_Chars);
                    
                    // wyjście
                    writer.WriteLine("Unicode: " + text); //unicode wypisuje domyślnie
                    writer.WriteLine("Ascii: " + asciiString); // wypisuje ascii
                    writer.WriteLine("UTF7: " + utf7String); // wypisuje UTF7 
                    writer.WriteLine("UTF8: " + utf8String);
                    writer.WriteLine("winiso-1250: " + winisoString);
                    writer.WriteLine("iso-8859-2: " + isoString);
                }
            } while (end == true);
            writer.Close();
            Console.ReadKey(true);
            
        }
    }
}
