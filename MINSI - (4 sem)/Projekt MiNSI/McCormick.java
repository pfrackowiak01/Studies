package zajecia8;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

import static java.lang.Math.*;

public class McCormick extends Funkcje {

    public static double minx1;
    public static double minx2;
    public static int dlugoscGenu1;
    public static int dlugoscGenu2;
    static int powt = 0;
    static int powtorzenia = 30;   //ilo�� powt�rze� uruchomienia ca�ego algorytmu, aby wykres odzwierciedla� wielko�� statyczn� (do wyci�gni�cia �rednich wynik�w)

    public static int losowanieIndexu1() {
        Random r = new Random();
        return r.nextInt((int) (max - minx1) * (int) Math.pow(10, dokladnosc));
    }

    public static int losowanieIndexu2() {
        Random r = new Random();
        return r.nextInt((int) (max - minx2) * (int) Math.pow(10, dokladnosc));
    }

    public static String kodowanieGenu1(int index) {
        String gen = Integer.toString(index, 2);
        while (true) {
            if (gen.length() < dlugoscGenu1) gen = "0" + gen;
            else return gen;
        }
    }

    public static String kodowanieGenu2(int index) {
        String gen = Integer.toString(index, 2);
        while (true) {
            if (gen.length() < dlugoscGenu2) gen = "0" + gen;
            else return gen;
        }
    }

    public static String chromosomNaGen1(String chromosom) {
        String gen = "";
        for (int i = 0; i < dlugoscGenu1; i++) {
            gen = gen + chromosom.charAt(i);
        }
        return gen;
    }

    // podzial chromosomu na dwa geny (wyodr�bniamy gen 2)
    public static String chromosomNaGen2(String chromosom) {
        String gen = "";
        for (int i = dlugoscGenu1; i < chromosom.length(); i++) {
            gen = gen + chromosom.charAt(i);
        }
        return gen;
    }

    public static float indexNaLiczbe1(int index) {
        double krok = Math.pow(0.1, dokladnosc);
        return (float) (minx1 + index * krok);
    }

    public static float indexNaLiczbe2(int index) {
        double krok = Math.pow(0.1, dokladnosc);
        return (float) (minx2 + index * krok);
    }

    public static float przystosowanieChromosomu(float x1, float x2) {
        float wynik = (float) (sin(x1+x2)+Math.pow((x1-x2),2)-1.5*x1+2.5*x2+1);
        return wynik;
    }

    public static boolean sprawdzanieChromosomu(String chromosom) {
        int maxIndex1 = (int)(max-minx1)*(int)Math.pow(10,dokladnosc);
        int maxIndex2 = (int)(max-minx2)*(int)Math.pow(10,dokladnosc);
        int index1 = genNaIndex(chromosomNaGen1(chromosom));
        int index2 = genNaIndex(chromosomNaGen2(chromosom));
        if(index1 > maxIndex1 || index2 > maxIndex2) return false;
        return true;
    }

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

        float liczbaA1 = indexNaLiczbe1(indexA1);
        float liczbaA2 = indexNaLiczbe2(indexA2);
        float liczbaB1 = indexNaLiczbe1(indexB1);
        float liczbaB2 = indexNaLiczbe2(indexB2);

        float wynik1 = przystosowanieChromosomu(liczbaA1, liczbaA2);
        float wynik2 = przystosowanieChromosomu(liczbaB1, liczbaB2);

        if(wynik1 <= wynik2) return true;
        return false;
    }

    public static String[] tworzeniePopulacji() {
        for (int i = 0; i < wielkoscPopulacji; i++) {
            String osobnik = genyNaChromosom(kodowanieGenu1(losowanieIndexu1()), kodowanieGenu2(losowanieIndexu2()));
            populacja[i] = osobnik;
        }
        return populacja;
    }

    public static void obliczaniePrzystosowaniaPopulacji() {
        int i = 0;
        while(i < wielkoscPopulacji) {

            String gen1 = chromosomNaGen1(populacja[i]);
            String gen2 = chromosomNaGen2(populacja[i]);

            int index1 = genNaIndex(gen1);
            int index2 = genNaIndex(gen2);

            float liczba1 = indexNaLiczbe1(index1);
            float liczba2 = indexNaLiczbe2(index2);

            przystosowaniePopulacji[i] = przystosowanieChromosomu(liczba1, liczba2);
            i++;
        }
    }

    public static void krzyzowanieDwupunktowe (int index) {

        while (true) {
            Random rand = new Random();
            String wycinek1 = "", wycinek2 = "", poczatek1 = "", poczatek2 = "", koncowka1 = "", koncowka2 = "", chromosomStary1, chromosomStary2;

            int indexPodzialuDolny = rand.nextInt(dlugoscGenu1 + dlugoscGenu2);
            int indexPodzialuGorny = rand.nextInt(dlugoscGenu1 + dlugoscGenu2);

            while (indexPodzialuDolny == indexPodzialuGorny) {
                indexPodzialuDolny = (int) Math.floor(Math.random() * (dlugoscGenu1 + dlugoscGenu2) + 0);
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

            for (int i = indexPodzialuGorny; i < (dlugoscGenu1 + dlugoscGenu2); i++) {
                koncowka1 = koncowka1 + chromosom1.charAt(i);
                koncowka2 = koncowka2 + chromosom2.charAt(i);
            }

            String chromosomNowy1 = poczatek1 + wycinek2 + koncowka1;
            String chromosomNowy2 = poczatek2 + wycinek1 + koncowka2;

            int maxIndex1 = (int)(max-minx1)*(int)Math.pow(10,dokladnosc);
            int maxIndex2 = (int)(max-minx2)*(int)Math.pow(10,dokladnosc);

            String genPom1 = chromosomNaGen1(chromosomNowy1);
            String genPom2 = chromosomNaGen2(chromosomNowy1);

            String genPom3 = chromosomNaGen1(chromosomNowy2);
            String genPom4 = chromosomNaGen2(chromosomNowy2);

            int index1 = Integer.parseInt(genPom1, 2);
            int index2 = Integer.parseInt(genPom2, 2);
            int index3 = Integer.parseInt(genPom3, 2);
            int index4 = Integer.parseInt(genPom4, 2);

            if (index1 < maxIndex1 && index2 < maxIndex2 && index3 < maxIndex1 && index4 < maxIndex2) {
                if (czyMniejszy(chromosomNowy1, populacja[index])) populacja[index] = chromosomNowy1;
                if (czyMniejszy(chromosomNowy1, populacja[indexPartnera])) populacja[indexPartnera] = chromosomNowy2;
                break;
            }
        }
    }

    public static void mutacja1(int index) {
        while (true) {
            String nowyChromosom = "";
            String rozpatrywanyChromosom = populacja[index];

            for (int i = 0; i < rozpatrywanyChromosom.length(); i++) {
                if (czyPrzechodzi(0.1)) {
                    if (rozpatrywanyChromosom.charAt(i) == '0') {
                        nowyChromosom = nowyChromosom + '1';
                    } else {
                        nowyChromosom = nowyChromosom + '0';
                    }
                }else nowyChromosom = nowyChromosom + rozpatrywanyChromosom.charAt(i);
            }
            if (sprawdzanieChromosomu(nowyChromosom))
            {
                populacja[index] = nowyChromosom;
                break;
            }
        }
    }

    public static void mutacja (int index) {
        Random r = new Random();
        String chromosom = populacja[index];
        String chrom = "";

        do { // p�tla wykonuje si� a� mutacja b�dzie prawid�owa i zgodna z za�o�eniami funkcji (gen nie mo�e by� wi�kszy od maxLiczby)
            chrom = "";
            int liczba = r.nextInt(chromosom.length());
            for (int i = 0; i < chromosom.length(); i++) {
                if (i == liczba) {
                    if (chromosom.charAt(i) == '1') chrom = chrom + '0';
                    else chrom = chrom + '1';
                }
                else {
                    if (chromosom.charAt(i) == '1') chrom = chrom + '1';
                    else chrom = chrom + '0';
                }
            }
        } while (!sprawdzanieChromosomu(chrom));
        if (czyMniejszy(chromosom,chrom)) populacja[index] = chromosom;
        else populacja[index] = chrom;
    }

    public static void wyzerujTablice(Float[] tablica) {
        for (int i = 0; i < tablica.length; i++) tablica[i] = Float.valueOf(0);
    }

    public static void main(String[] args) throws FileNotFoundException {

        PrintWriter currentZapis = new PrintWriter("current.txt");
        PrintWriter bestCurrentZapis = new PrintWriter("bestcurrent.txt");
        PrintWriter bestGlobalZapis = new PrintWriter("bestglobal.txt");

        minx1 = -1.5;
        minx2 = -3;
        max = 4;
        dokladnosc = 5;
        wielkoscPopulacji = 1000;
        dlugoscGenu1 = (int) Math.ceil(Math.log((max - minx1) * Math.pow(10, dokladnosc)) / Math.log(2));
        dlugoscGenu2 = (int) Math.ceil(Math.log((max - minx2) * Math.pow(10, dokladnosc)) / Math.log(2));

        populacja = new String[wielkoscPopulacji];
        przystosowaniePopulacji = new Float[wielkoscPopulacji];
        Float[] srednieWartosci = new Float[ewaluacja];      // tablica z �rednimi warto�ciami FP (czyli suma wszystkich, kt�r� potem si� podzieli przez 'powtorzenia')
        Float[] srednieBestCurrenty = new Float[ewaluacja];  // tablica z �rednimi warto�ciami BestCurrent (czyli suma wszystkich, kt�r� potem si� podzieli przez 'powtorzenia')
        Float[] srednieBestGlobale = new Float[ewaluacja];   // tablica z �rednimi warto�ciami BestGlobal (czyli suma wszystkich, kt�r� potem si� podzieli przez 'powtorzenia')

        // zerowanie wszystkich tablic (wstawianie wsz�dzie 0, �eby nie by�o warto�ci NULL)
        wyzerujTablice(srednieWartosci);
        wyzerujTablice(srednieBestCurrenty);
        wyzerujTablice(srednieBestGlobale);

        // p�tla do zliczania wszystkich warto�ci do tablic z �rednimi
        for(int j = 0; j < powtorzenia; j++) {

            bestCurrent = 0;
            bestGlobal = 100;
            ev = 0;

            populacja = tworzeniePopulacji();

            while (ev < ewaluacja) {

                obliczaniePrzystosowaniaPopulacji();                     //tworzy statyczn� tablice z wynikami funkcji dla populacji
                bestCurrent = sprawdzanieBestCurrent();                  //wylicza z tej tablicy najlepszy wynik                     (najlepszy osobnik z obecnej populacji)
                if (bestCurrent < bestGlobal) bestGlobal = bestCurrent;  //zapami�tuje najlepszy wynik spo�r�d wszystkich pokole�    (najlepszy osobnik ze wszystkich pokole�)

                for (int i = 0; i < populacja.length; i++) {

                    current = przystosowaniePopulacji[i];
                    System.out.println("Warto�� przystosowania populacji wynosi: " + current);
                    System.out.println("Warto�� najlepszego przystosowania teraz: " + bestCurrent);
                    System.out.println("Warto�� najlepszego przystosowania globalnie: " + bestGlobal);

                    srednieWartosci[ev] = srednieWartosci[ev] + current;             //sumuje odpowiednie wyniki w tabeli �redniej warto�ci FP
                    srednieBestCurrenty[ev] = srednieBestCurrenty[ev] + bestCurrent; //sumuje odpowiednie wyniki w tabeli �redniej warto�ci BestCurrent
                    srednieBestGlobale[ev] = srednieBestGlobale[ev] + bestGlobal;    //sumuje odpowiednie wyniki w tabeli �redniej warto�ci BestGlobal

                    ev++;
                    System.out.println("Ev = " + ev + "\n");

                    // Warunek zatrzymania p�tli
                    if (ev >= ewaluacja) break;       //ewaluacja = 1000
                }

                // Selekcja chromosom�w (Metoda ruletki)
                tworzeniePopulacjiRuletka();

                // Zastosowanie operator�w genetycznych - krzy�owanie dwu-punktowe
                for (int i = 0; i < wielkoscPopulacji; i++) {
                    if (czyPrzechodzi(0.6)) krzyzowanieDwupunktowe(i);
                }

                // Zastosowanie operator�w genetycznych - mutacja
                for (int i = 0; i < wielkoscPopulacji; i++) {
                    if (czyPrzechodzi(0.02)) mutacja(i);
                }
            }
            powt++;
            System.out.println("Powt = " + powt);
        }

        //p�tla do dzielenia konkretnej sumy przez ilo�� 'powtorzenia', aby uzyska� u�redniony wynik. Potem zapisanie go do pliku tekstowego.
        for (int i = 0; i < ewaluacja; i++) {

            sredniCurrent = srednieWartosci[i] / powtorzenia;
            srednibestCurrent = srednieBestCurrenty[i] / powtorzenia;
            srednibestGlobal = srednieBestGlobale[i] / powtorzenia;

            currentZapis.println(sredniCurrent);
            bestCurrentZapis.println(srednibestCurrent);
            bestGlobalZapis.println(srednibestGlobal);
        }

        currentZapis.close();
        bestCurrentZapis.close();
        bestGlobalZapis.close();
    }
}


