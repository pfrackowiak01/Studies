package zajecia8;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

import static java.lang.Math.*;

public class HolderTable extends Funkcje {

    static int powt = 0;
    static int powtorzenia = 30;   //iloœæ powtórzeñ uruchomienia ca³ego algorytmu, aby wykres odzwierciedla³ wielkoœæ statyczn¹ (do wyci¹gniêcia œrednich wyników)

    public static float przystosowanieChromosomu(float x1, float x2) {
        float wynik = (float) -(abs(sin(x1)*cos(x2)*exp(abs(1-(sqrt(pow(x1,2)+pow(x2,2))/PI)))));
        return wynik;
    }

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

    public static void krzyzowanieDwupunktowe (int index) {

        while (true) {
            Random rand = new Random();
            String wycinek1 = "", wycinek2 = "", poczatek1 = "", poczatek2 = "", koncowka1 = "", koncowka2 = "", chromosomStary1, chromosomStary2;

            int indexPodzialuDolny = rand.nextInt(2 * dlugoscGenu);
            int indexPodzialuGorny = rand.nextInt(2 * dlugoscGenu);

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


            int maxIndex = (int)(max-min)*(int)Math.pow(10,dokladnosc);
            String genPom1 = chromosomNaGen1(chromosomNowy1);
            String genPom2 = chromosomNaGen2(chromosomNowy1);


            String genPom3 = chromosomNaGen1(chromosomNowy2);
            String genPom4 = chromosomNaGen2(chromosomNowy2);


            int index1 = Integer.parseInt(genPom1, 2);
            int index2 = Integer.parseInt(genPom2, 2);
            int index3 = Integer.parseInt(genPom3, 2);
            int index4 = Integer.parseInt(genPom4, 2);


            if (index1 < maxIndex && index2 < maxIndex && index3 < maxIndex && index4 < maxIndex) {
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

        do { // pêtla wykonuje siê a¿ mutacja bêdzie prawid³owa i zgodna z za³o¿eniami funkcji (gen nie mo¿e byæ wiêkszy od maxLiczby)
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

        min = -10;
        max = 10;
        dokladnosc = 5;
        wielkoscPopulacji = 500;
        dlugoscGenu = (int) Math.ceil(Math.log((max - min) * Math.pow(10, dokladnosc)) / Math.log(2));

        populacja = new String[wielkoscPopulacji];
        przystosowaniePopulacji = new Float[wielkoscPopulacji];
        Float[] srednieWartosci = new Float[ewaluacja];      // tablica z œrednimi wartoœciami FP (czyli suma wszystkich, któr¹ potem siê podzieli przez 'powtorzenia')
        Float[] srednieBestCurrenty = new Float[ewaluacja];  // tablica z œrednimi wartoœciami BestCurrent (czyli suma wszystkich, któr¹ potem siê podzieli przez 'powtorzenia')
        Float[] srednieBestGlobale = new Float[ewaluacja];   // tablica z œrednimi wartoœciami BestGlobal (czyli suma wszystkich, któr¹ potem siê podzieli przez 'powtorzenia')

        // zerowanie wszystkich tablic (wstawianie wszêdzie 0, ¿eby nie by³o wartoœci NULL)
        wyzerujTablice(srednieWartosci);
        wyzerujTablice(srednieBestCurrenty);
        wyzerujTablice(srednieBestGlobale);

        // pêtla do zliczania wszystkich wartoœci do tablic z œrednimi
        for(int j = 0; j < powtorzenia; j++) {

            bestCurrent = 0;
            bestGlobal = 100;
            ev = 0;

            populacja = tworzeniePopulacji();

            while (ev < ewaluacja) {

                obliczaniePrzystosowaniaPopulacji();                     //tworzy statyczn¹ tablice z wynikami funkcji dla populacji
                bestCurrent = sprawdzanieBestCurrent();                  //wylicza z tej tablicy najlepszy wynik                     (najlepszy osobnik z obecnej populacji)
                if (bestCurrent < bestGlobal) bestGlobal = bestCurrent;  //zapamiêtuje najlepszy wynik spoœród wszystkich pokoleñ    (najlepszy osobnik ze wszystkich pokoleñ)

                for (int i = 0; i < populacja.length; i++) {

                    current = przystosowaniePopulacji[i];
                    System.out.println("Wartoœæ przystosowania populacji wynosi: " + current);
                    System.out.println("Wartoœæ najlepszego przystosowania teraz: " + bestCurrent);
                    System.out.println("Wartoœæ najlepszego przystosowania globalnie: " + bestGlobal);

                    srednieWartosci[ev] = srednieWartosci[ev] + current;             //sumuje odpowiednie wyniki w tabeli œredniej wartoœci FP
                    srednieBestCurrenty[ev] = srednieBestCurrenty[ev] + bestCurrent; //sumuje odpowiednie wyniki w tabeli œredniej wartoœci BestCurrent
                    srednieBestGlobale[ev] = srednieBestGlobale[ev] + bestGlobal;    //sumuje odpowiednie wyniki w tabeli œredniej wartoœci BestGlobal

                    ev++;
                    System.out.println("Ev = " + ev + "\n");

                    // Warunek zatrzymania pêtli
                    if (ev >= ewaluacja) break;       //ewaluacja = 1000
                }

                // Selekcja chromosomów (Metoda ruletki)
                tworzeniePopulacjiRuletka();

                // Zastosowanie operatorów genetycznych - krzy¿owanie dwu-punktowe
                for (int i = 0; i < wielkoscPopulacji; i++) {
                    if (czyPrzechodzi(0.6)) krzyzowanieDwupunktowe(i);
                }

                // Zastosowanie operatorów genetycznych - mutacja
                for (int i = 0; i < wielkoscPopulacji; i++) {
                    if (czyPrzechodzi(0.02)) mutacja(i);
                }
            }
            powt++;
            System.out.println("Powt = " + powt);
        }

        //pêtla do dzielenia konkretnej sumy przez iloœæ 'powtorzenia', aby uzyskaæ uœredniony wynik. Potem zapisanie go do pliku tekstowego.
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

