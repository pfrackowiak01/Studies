using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace PP_projekt___Histogram_ocen
{
    public partial class Form1 : Form
    {
        public static int dolneGrupy = 100, gorneGrupy = 0, iloscGrup = 0, kolor;
        public static bool check1;
        public static string stringPrzekazany = "", Dane;
        public static Color kolortla;

        public Form1()
        {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void label9_Click(object sender, EventArgs e)
        {

        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox3_TextChanged(object sender, EventArgs e)
        {

        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            Form2 F2 = new Form2();
            F2.ShowDialog();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            SaveFileDialog saveFileDialog1 = new SaveFileDialog();

            saveFileDialog1.Filter = "txt files (*.txt)|*.txt";
            saveFileDialog1.FilterIndex = 2;
            saveFileDialog1.RestoreDirectory = true;

            if (saveFileDialog1.ShowDialog() == DialogResult.OK)
            {
                String zapisDirectory = saveFileDialog1.InitialDirectory;
                String zapisFileName = saveFileDialog1.FileName;
                String zapisPath = Path.Combine(zapisDirectory, zapisFileName);

                using (StreamWriter eksport = new StreamWriter(zapisPath))
                {
                    eksport.WriteLine(label6.Text + " " + textBox2.Text);
                    eksport.WriteLine(label8.Text);
                    eksport.WriteLine(textBox3.Text);
                    eksport.Close();
                }
                if (File.Exists(zapisPath)) MessageBox.Show("Plik zapisano pomyślnie.", "Sukces!", MessageBoxButtons.OK, MessageBoxIcon.Information);
                else MessageBox.Show("Błąd przy zapisie pliku.", "Błąd!", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void label8_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            using (OpenFileDialog openFileDialog = new OpenFileDialog())
            {
                openFileDialog.InitialDirectory = "c:\\";
                openFileDialog.Filter = "txt files (*.txt)|*.txt";
                openFileDialog.FilterIndex = 2;
                openFileDialog.RestoreDirectory = true;

                if (openFileDialog.ShowDialog() == DialogResult.OK)
                {
                    //Ścieżka do pliku, którą podaje użytkownik
                    string sciezka = openFileDialog.FileName;

                    if (openFileDialog.CheckFileExists)
                    {
                        //Odczytanie zawartości pliku
                        stringPrzekazany = File.ReadAllText(sciezka);
                        try
                        {
                            WyswietlanieDanych();
                            button2.Enabled = true;
                            button3.Enabled = true;
                            textBox1.Enabled = false;
                            textBox2.Enabled = false;
                        }
                        catch
                        {
                            MessageBox.Show("Niewłaściwe dane w pliku.", "Błąd!", MessageBoxButtons.OK, MessageBoxIcon.Error);
                        }
                    }
                    else MessageBox.Show("Nie można otworzyć pliku.", "Błąd!", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
            }
        }

        public void WyswietlanieDanych()
        {
            //------------------------------------
            //Resetowanie wcześniejszych ustawień
            textBox1.Text = null;
            textBox2.Text = null;
            textBox3.Text = null;
            dolneGrupy = 100;
            gorneGrupy = 0;
            //------------------------------------

            textBox1.Text = stringPrzekazany;
            char charSeparator = ';';
            string[] result;
            result = stringPrzekazany.Split(charSeparator, (char)StringSplitOptions.None);
            Double ocena;
            int k = 0;
            Double[] tablicaOcen = new Double[result.Length - 2];
            foreach (var value in result)
            {
                Double.TryParse(value, out ocena);
                if (ocena < dolneGrupy) dolneGrupy = Convert.ToInt32(Math.Floor(ocena));
                if (ocena > gorneGrupy) gorneGrupy = Convert.ToInt32(Math.Ceiling(ocena));
                if (Double.TryParse(value, out ocena))
                {
                    tablicaOcen[k] = ocena;
                    k++;
                }
            }
            iloscGrup = gorneGrupy - dolneGrupy;
            textBox2.Text = Convert.ToString(iloscGrup);
            //--------------------------------------------------

            //Sortowanie Ocen
            double temp = 0;
            for (int i = 0; i < tablicaOcen.Length; i++)
            {
                for (int j = 0; j < tablicaOcen.Length - 1; j++)
                {
                    if (tablicaOcen[j] > tablicaOcen[j + 1])
                    {
                        temp = tablicaOcen[j + 1];
                        tablicaOcen[j + 1] = tablicaOcen[j];
                        tablicaOcen[j] = temp;
                    }
                }
            }
            //--------------------------------------------------

            //Liczenie ile jest ocen w poszczególnych grupach 
            Double dolne = dolneGrupy;
            int iloscOcen = 0;
            for (int i = 0; i < tablicaOcen.Length; i++)
            {
                if (Math.Floor(tablicaOcen[i]) == dolne) iloscOcen++;
                else
                {
                    textBox3.Text = textBox3.Text + Convert.ToString(dolne) + "-" + Convert.ToString(dolne + 1) + ": " + Convert.ToString(iloscOcen) + Environment.NewLine;
                    iloscOcen = 0;
                    dolne++;
                    i--;
                }
            }
            textBox3.Text = textBox3.Text + Convert.ToString(dolne) + "-" + Convert.ToString(dolne + 1) + ": " + Convert.ToString(iloscOcen);
            Dane = textBox3.Text;
            //--------------------------------------------------

            MessageBox.Show("Plik odczytano pomyślnie.", "Sukces!", MessageBoxButtons.OK, MessageBoxIcon.Information);
        }
    }
}
