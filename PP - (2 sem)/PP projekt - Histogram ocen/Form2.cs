using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace PP_projekt___Histogram_ocen
{
    public partial class Form2 : Form
    {
        public Form2()
        {
            InitializeComponent();
        }

        private void Form2_Load(object sender, EventArgs e)
        {
            //wczytanie ustawień z przed zamknięcia okna
            checkBox1.Checked = Form1.check1;
            comboBox1.SelectedIndex = Form1.kolor;
            chart1.ChartAreas["ChartArea1"].BackColor = Form1.kolortla;
            //-------------------------------------------
            string[] result = Form1.Dane.Split(new Char[] { ':', '\n' });
            for (int i = 0; i < result.Length; i+=2)
                chart1.Series["Histogram"].Points.AddXY(Convert.ToString(result[i]), Convert.ToString(result[i + 1]));
        }

        private void checkBox1_CheckedChanged(object sender, EventArgs e)
        {
            if (chart1.Legends[0].Enabled == true) chart1.Legends[0].Enabled = false;
            else chart1.Legends[0].Enabled = true;
        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            Form1.kolor = comboBox1.SelectedIndex;
            switch (Form1.kolor)
            {
                case 0:
                    chart1.Series["Histogram"].Color = Color.Blue;
                    break;
                case 1:
                    chart1.Series["Histogram"].Color = Color.Green;
                    break;
                case 2:
                    chart1.Series["Histogram"].Color = Color.Red;
                    break;
            }
        }

        //zapis ustawień przed zamknięciem okienka z wykresem
        private void button1_Click(object sender, EventArgs e)
        {
            Form1.check1 = checkBox1.Checked;
            Form1.kolor = comboBox1.SelectedIndex;
            Form1.kolortla = colorDialog1.Color;
            this.Close();
        }

        private void chart1_Click(object sender, EventArgs e)
        {

        }

        //zmiana koloru tła wykresu
        private void button2_Click(object sender, EventArgs e)
        {
            if (colorDialog1.ShowDialog() == DialogResult.OK)
            {
                colorDialog1.ShowHelp = true;
                chart1.ChartAreas["ChartArea1"].BackColor = colorDialog1.Color;
            }
        }
    }
}
