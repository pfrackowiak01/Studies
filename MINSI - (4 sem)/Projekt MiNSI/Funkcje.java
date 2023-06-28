package zajecia8;

import java.util.Random;

import static java.lang.Math.*;

public class Funkcje {

    public static double min;
    public static double max;
    public static int dokladnosc;
    public static int dlugoscGenu = (int) Math.ceil(Math.log((max - min) * Math.pow(10, dokladnosc)) / Math.log(2)); //na ilu bitach jest zapisany gen
    public static int wielkoscPopulacji;
    static float current, bestCurrent, bestGlobal, sredniCurrent, srednibestCurrent, srednibestGlobal;
    static int ewaluacja = 1000;   //liczba oblicze� warto�ci (ewaluacji) funkcji przystosowania
    public static String[] populacja = new String[wielkoscPopulacji];
    public static Float[] przystosowaniePopulacji = new Float[wielkoscPopulacji];
    public static int ev = 0;

    //----------------------------------------------------------------------------------------------------------------//
    // funkcje do kodowania

    //Losowanie indexu min - minimalny zakres, max - maksymalny zakres, d - dok�adno�� po przecinku
    public static int losowanieIndexu() {
        Random r = new Random();
        return r.nextInt((int) (max - min) * (int) Math.pow(10, dokladnosc));
    }

    //Kodowanie indexu na gen
    public static String kodowanieGenu(int index) {
        String gen = Integer.toString(index, 2);
        while (true) {
            if (gen.length() < dlugoscGenu) gen = "0" + gen;
            else return gen;
        }
    }

    // dodawanie do siebie genow gen1 + gen2 to ca�y kod lmao i tworzy chromosom wiec nie wybrzydzaj
    public static String genyNaChromosom(String gen1, String gen2) {
        return gen1 + gen2;
    }

    //----------------------------------------------------------------------------------------------------------------//
    // funkcje do dekodowania:

    // podzial chromosomu na dwa geny (wyodr�bniamy gen 1)
    public static String chromosomNaGen1(String chromosom) {
        String gen = "";
        for (int i = 0; i < chromosom.length() / 2; i++) {
            gen = gen + chromosom.charAt(i);
        }
        return gen;
    }

    // podzial chromosomu na dwa geny (wyodr�bniamy gen 2)
    public static String chromosomNaGen2(String chromosom) {
        String gen = "";
        for (int i = chromosom.length() / 2; i < chromosom.length(); i++) {
            gen = gen + chromosom.charAt(i);
        }
        return gen;
    }

    // dekodowanie liczby z jej indexu
    public static int genNaIndex(String gen) {
        return Integer.parseInt(gen, 2);
    }


    // funkcja zamienia warto�� indeksu na odpowiedni� liczb� w przedziale od min do max
    public static float indexNaLiczbe(int index) {
        double krok = Math.pow(0.1, dokladnosc);
        return (float) (min + index * krok);
    }

    // funkcja licz�ca przystosowanie danego chromosomu
    public static float przystosowanieChromosomu(float x1, float x2) {
        float wynik = (-1 * (x1 * x1)) + (-1 * (x2 * x2)) + 2; //przykladowa funkcja dla zobrazowania pozyskiwania wyniku
        return wynik;
    }


    //----------------------------------------------------------------------------------------------------------------//
    // inne:

    //funkcja zwraca true je�li podany chromosom mie�ci si� w podanym zakresie, w przeciwnym wypadku zwraca false
    public static boolean sprawdzanieChromosomu(String chromosom) {
        int maxIndex = (int)(max-min)*(int)Math.pow(10,dokladnosc);
        int index1 = genNaIndex(chromosomNaGen1(chromosom));
        int index2 = genNaIndex(chromosomNaGen2(chromosom));
        if(index1 > maxIndex || index2 > maxIndex) return false;
        return true;
    }

    // funkcja por�wnuj�ca przystosowanie dw�ch chromosom�w
    public static boolean czyMniejszy(String chromosomStary, String chromosomNowy)
    {
        String genA1 = chromosomNaGen1(chromosomStary);
        String genA2 = chromosomNaGen2(chromosomStary);
        String genB1 = chromosomNaGen1(chromosomNowy);
        String genB2 = chromosomNaGen2(chromosomNowy);

        int indexA1 = genNaIndex(genA1);
        int indexA2 = genNaIndex(genA2);
        int indexB1 = genNaIndex(genB1);
        int indexB2 = genNaIndex(genB2);

        float liczbaA1 = indexNaLiczbe(indexA1);
        float liczbaA2 = indexNaLiczbe(indexA2);
        float liczbaB1 = indexNaLiczbe(indexB1);
        float liczbaB2 = indexNaLiczbe(indexB2);

        float wynik1 = przystosowanieChromosomu(liczbaA1, liczbaA2);
        float wynik2 = przystosowanieChromosomu(liczbaB1, liczbaB2);

        if(wynik1 <= wynik2) return true;
        return false;
    }

    // losowanie od 0 do 1, je�eli wylosuje liczbe pomi�dzy 0, a "procent" to zwraca true, w przeciwnym razie - false
    public static boolean czyPrzechodzi(double procent)
    {
        Random r = new Random();
        if (procent >= r.nextDouble()) return true;
        return false;
    }

    // funkcja do wyznaczania najlepiej przystosowanego osobnika
    public static float sprawdzanieBestCurrent()
    {
        float bestCurrent = przystosowaniePopulacji[0];

        for(int i = 0; i < wielkoscPopulacji; i++)
        {
            if(przystosowaniePopulacji[i] < bestCurrent)
                bestCurrent = przystosowaniePopulacji[i];
        }
        return bestCurrent;
    }


    //----------------------------------------------------------------------------------------------------------------//
    //   DU�E FUNKCJE

    //Tworzy populacje losowo generowanych osobnik�w w ilo�ci okre�lonej przez u�ytkownika
    public static String[] tworzeniePopulacji() {
        for (int i = 0; i < wielkoscPopulacji; i++) {
            String osobnik = genyNaChromosom(kodowanieGenu(losowanieIndexu()), kodowanieGenu(losowanieIndexu()));
            populacja[i] = osobnik;
        }
        return populacja;
    }

    //Liczymy przystosowanie wszystkich osobnik�w w populacji
    public static void obliczaniePrzystosowaniaPopulacji() {
        int i = 0;
        while(i < wielkoscPopulacji) {

            String gen1 = chromosomNaGen1(populacja[i]);
            String gen2 = chromosomNaGen2(populacja[i]);

            int index1 = genNaIndex(gen1);
            int index2 = genNaIndex(gen2);

            float liczba1 = indexNaLiczbe(index1);
            float liczba2 = indexNaLiczbe(index2);

            przystosowaniePopulacji[i] = przystosowanieChromosomu(liczba1, liczba2);
            i++;
        }
    }

    public static int losowaniePartnera (int index) {
        Random r = new Random();
        int indexPartnera;
        do {
            indexPartnera = r.nextInt(wielkoscPopulacji);
        } while (index == indexPartnera);
        return indexPartnera;
    }

    //Krzy�uje ze sob� dwa chromosomy w 2 losowych punktach
    public static void krzyzowanieDwupunktowe (int index) {
        String wycinek1 = "", wycinek2 = "", poczatek1 = "", poczatek2 = "", koncowka1 = "", koncowka2 = "", chromosomStary1, chromosomStary2;
        int indexPodzialuDolny = (int) Math.floor(Math.random() * (2 * dlugoscGenu) + 0);
        int indexPodzialuGorny = (int) Math.floor(Math.random() * (2 * dlugoscGenu) + 0);

        while (indexPodzialuDolny == indexPodzialuGorny) {
            indexPodzialuDolny = (int) Math.floor(Math.random() * (2 * dlugoscGenu) + 0);
        }

        if (indexPodzialuDolny > indexPodzialuGorny) {
            int kubek = indexPodzialuDolny;
            indexPodzialuDolny = indexPodzialuGorny;
            indexPodzialuGorny = kubek;
        }

        int indexPartnera = losowaniePartnera(index);
        String chromosom1 = populacja[index];
        String chromosom2 = populacja[indexPartnera];

        for (int i = 0; i < indexPodzialuDolny; i++) {
            poczatek1 = poczatek1 + chromosom1.charAt(i);
            poczatek2 = poczatek2 + chromosom2.charAt(i);
        }

        for (int i = indexPodzialuDolny; i < indexPodzialuGorny; i++) {
            wycinek1 = wycinek1 + chromosom1.charAt(i);
            wycinek2 = wycinek2 + chromosom2.charAt(i);
        }

        for (int i = indexPodzialuGorny; i < (2 * dlugoscGenu); i++) {
            koncowka1 = koncowka1 + chromosom1.charAt(i);
            koncowka2 = koncowka2 + chromosom2.charAt(i);
        }

        String chromosomNowy1 = poczatek1 + wycinek2 + koncowka1;
        String chromosomNowy2 = poczatek2 + wycinek1 + koncowka2;

        if (!sprawdzanieChromosomu(chromosom1) || !sprawdzanieChromosomu(chromosom2)) {
            krzyzowanieDwupunktowe(index);
        } else {
            if (czyMniejszy(chromosomNowy1, populacja[index])) populacja[index] = chromosomNowy1;
            if (czyMniejszy(chromosomNowy1, populacja[indexPartnera])) populacja[indexPartnera] = chromosomNowy2;
        }
    }


    // funkacja do mutacji chromosom�w
    public static void mutacja(int index)
    {
        String nowyChromosom = "";
        String rozpatrywanyChromosom = populacja[index];

        for(int i = 0; i < rozpatrywanyChromosom.length(); i++)
        {
            if(czyPrzechodzi(0.1))
            {
                if(rozpatrywanyChromosom.charAt(i) == '0')
                {
                    nowyChromosom = nowyChromosom + '1';
                }
                else
                {
                    nowyChromosom = nowyChromosom + '0';
                }
            }
        }
        if (!sprawdzanieChromosomu(nowyChromosom)) mutacja(index);

        populacja[index] = rozpatrywanyChromosom;
    }




    public static void tworzeniePopulacjiRuletka()
    {
        float[] pomocniczePrzystosowanie = new float[wielkoscPopulacji];
        float[] przedzialy = new float[wielkoscPopulacji+1];
        String[] ruletkaPopulacja = new String[wielkoscPopulacji];

        //sprawdzanie najwi�kszej wartosci funkcji w populacji
        float najwiekszy = przystosowaniePopulacji[0];
        int indexNajwiekszego = 0;
        for(int i = 0; i < wielkoscPopulacji; i++)
        {
            if(przystosowaniePopulacji[i] > najwiekszy)
            {
                najwiekszy = przystosowaniePopulacji[i];
                indexNajwiekszego = i;
            }
        }
        najwiekszy = abs(najwiekszy);
        for(int i = 0; i < wielkoscPopulacji; i++)
        {
            pomocniczePrzystosowanie[i] = abs(przystosowaniePopulacji[i] - najwiekszy);
        }

        for(int i = 0; i < wielkoscPopulacji; i++)
        {
            pomocniczePrzystosowanie[i] = (pomocniczePrzystosowanie[i]/najwiekszy)*100;
        }

        float rownePrzedzialy = 100/wielkoscPopulacji;

        for(int i = 0; i < wielkoscPopulacji; i++)
        {
            pomocniczePrzystosowanie[i] = pomocniczePrzystosowanie[i]+rownePrzedzialy;
        }

        // liczenie przedzia��w
        przedzialy[0] = 0;
        for(int i = 1; i< wielkoscPopulacji; i++)
        {
            przedzialy[i] = przedzialy[i-1] + pomocniczePrzystosowanie[i];
        }

        // obliczanie sumy wynik�w pomocniczej populacji
        float sumaWynikow = przedzialy[wielkoscPopulacji-1];


        // p�tla g��wna, kt�ra pos�u�y do losowania warto�ci, kt�re nast�pnie b�d� por�wnywane wielokrotnie
        // do kolejnych warto�ci z kolejnych przedzia��w w celu wylosowania osobnika do selekcji
        for(int i = 0; i < wielkoscPopulacji; i++)
        {
            // losowanie wyniku od 0 do sumy wynik�w
            float losowanieOsobnika = (float)(Math.random() * (sumaWynikow + 0));

            // mniejsza p�tla, kt�ra pozwala na kolejne por�wnywanie wylosowanej liczby z kolejnymi przedzia�ami
            for(int j = 0; j < wielkoscPopulacji; j++)
            {
                if(losowanieOsobnika >= przedzialy[j] && losowanieOsobnika < przedzialy[j+1])
                {
                    ruletkaPopulacja[i] = populacja[j];
                    break;
                }
            }
        }
        for(int i = 0; i < wielkoscPopulacji; i++)
        {
            populacja[i] = ruletkaPopulacja[i];
        }
    }
}

