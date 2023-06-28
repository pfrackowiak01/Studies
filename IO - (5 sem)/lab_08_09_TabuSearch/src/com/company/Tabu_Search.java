package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Tabu_Search {

    static int n;                      // Ilość przedmiotów
    static int B;                      // Pojemność plecaka
    static int[] w;                    // Wartość przedmiotu
    static int[] s;                    // Wielkość przedmiotu
    static double[] wagi;              // Wartość przez wielkość przedmiotu
    static int MAX_ITER = 10000;        // Ilość wykonań pętli algorytmu
    static int dlugoscListyTabu = 50;  // Długość listy Tabu

    static int[] vc;
    static int[] vn;
    static int[] best = new int[n];

    static List<Integer> listaPrzedmiotowWkladanych = new ArrayList<>();
    static List<Integer> listaPrzedmiotowWyciaganych = new ArrayList<>();
    static List<List<Integer>> ruch = new ArrayList<>();
    static List<List<Integer>> ruch_do_sprawdzenia = new ArrayList<>();
    static List<List<List<Integer>>> listaTabu = new ArrayList<>();

    public static void wczytajDane() {

        try {
            String filename = "large_instances/knapPI_1_10000_1000_1";
            File file = new File(filename);
            Scanner odczyt = new Scanner(file);

            String pierwszaLinia = odczyt.nextLine();
            n = Integer.parseInt(pierwszaLinia.split(" ")[0]);
            B = Integer.parseInt(pierwszaLinia.split(" ")[1]);
            //B = (int) ((Double.parseDouble(pierwszaLinia.split(" ")[1])) * 10000);                     // Dla wartości z ułamkiem
            vc = new int[n];
            vn = new int[n];
            w = new int[n];
            s = new int[n];
            wagi = new double[n];
            best = new int[n];
            String kolejnaLinia;

            for (int i = 0; i < n; i++) {
                kolejnaLinia = odczyt.nextLine();
                w[i] = (int) Math.floor(Double.parseDouble(kolejnaLinia.split(" ")[0]));
                s[i] = (int) Math.floor(Double.parseDouble(kolejnaLinia.split(" ")[1]));
                //w[i] = (int) ((Double.parseDouble(kolejnaLinia.split(" ")[0])) * 10000);               // Dla wartości z ułamkiem
                //s[i] = (int) ((Double.parseDouble(kolejnaLinia.split(" ")[1])) * 10000);               // Dla wartości z ułamkiem
                wagi[i] = (double) w[i] / (double) s[i];
            }
            odczyt.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("""
                    ===================================================================
                    Nie znaleziono pliku, aby wczytać dane - podaj prawidłową ścieżkę!
                    ===================================================================""");
            throw new RuntimeException(e);
        }
    }

    static public int funkcjaCelu(int[] dany_plecak) {            // Czyli liczenie wartości wszystkich przedmiotów w danym plecaku

        int suma = 0;
        for (int i = 0; i < n; i++) if(dany_plecak[i] == 1) suma = w[i] + suma;
        return suma;
    }

    static public boolean czy_przedmiot_miesci_sie_w_plecaku(int dany_przedmiot, int[] dany_plecak) {    // Sprawdzanie czy podany przedmiot zmieści się w podanym plecaku

        int pojemnosc_plecaka = 0;
        for (int i = 0; i < n; i++) if(dany_plecak[i] == 1) pojemnosc_plecaka = s[i] + pojemnosc_plecaka;
        return pojemnosc_plecaka + s[dany_przedmiot] <= B;
    }

    static public void przeszukiwanieTabu() {                  // Algorytm przeszukiwania Tabu

        listaTabu.clear();
        int wartosc_plecaka_vn, wartosc_plecaka_best, i = 0;

        wybierz_rozwiazanie_poczatkowe_losowe();
        //wybierz_rozwiazanie_poczatkowe_najoptymalniejsze();
        System.arraycopy(vc, 0, best, 0, n);
        do {
            wybierz_rozwiazanie_z_otoczenia();
            //wybierz_rozwiazanie_z_otoczenia2();
            System.arraycopy(vn, 0, vc, 0, n);
            wartosc_plecaka_vn = funkcjaCelu(vn);
            wartosc_plecaka_best = funkcjaCelu(best);
            if (wartosc_plecaka_vn > wartosc_plecaka_best) System.arraycopy(vn, 0, best, 0, n);
            uaktualnij_liste_tabu();
            i++;
            //System.out.println("===== Koniec iteracji " + i + " =====" + " f(vn) = " + wartosc_plecaka_vn + " | f(best) = " + wartosc_plecaka_best);
        } while (i < MAX_ITER);
    }

    static public void wybierz_rozwiazanie_z_otoczenia() {

        Random rand = new Random();
        int losowy_przedmiot_wyciagany, losowy_przedmiot_wkladany;
        boolean czy_jest_w_tabu;

        do {
            System.arraycopy(vc, 0, vn, 0, n);
            czy_jest_w_tabu = false;
            listaPrzedmiotowWyciaganych.clear();
            listaPrzedmiotowWkladanych.clear();
            ruch.clear();
            ruch_do_sprawdzenia.clear();

            //System.out.println("vn = " + Arrays.toString(vn));

            int k = 0;
            do {
                losowy_przedmiot_wyciagany = rand.nextInt(n);
                k++;
                if (k > 10) break;
            }
            while (vn[losowy_przedmiot_wyciagany] == 0);
            listaPrzedmiotowWyciaganych.add(losowy_przedmiot_wyciagany);
            vn[losowy_przedmiot_wyciagany] = 0;

            //System.out.println("Wyciągamy: " + listaPrzedmiotowWyciaganych.toString());
            //System.out.println("vn = " + Arrays.toString(vn));

            for (int i = 0; i < n * 2; i++) {
                k = 0;
                do {
                    losowy_przedmiot_wkladany = rand.nextInt(n);
                    k++;
                    if (k > 10) break;
                }
                while (vn[losowy_przedmiot_wkladany] == 1 || listaPrzedmiotowWyciaganych.contains(losowy_przedmiot_wkladany));
                if (czy_przedmiot_miesci_sie_w_plecaku(losowy_przedmiot_wkladany, vn)) {
                    listaPrzedmiotowWkladanych.add(losowy_przedmiot_wkladany);
                    vn[losowy_przedmiot_wkladany] = 1;
                }
            }

            //System.out.println("Wkładamy: " + listaPrzedmiotowWkladanych.toString());
            //System.out.println("vn = " + Arrays.toString(vn));

            ruch.add(listaPrzedmiotowWyciaganych);
            ruch.add(listaPrzedmiotowWkladanych);
            ruch_do_sprawdzenia.add(listaPrzedmiotowWkladanych);
            ruch_do_sprawdzenia.add(listaPrzedmiotowWyciaganych);

            for (Integer przedmiotyWyciagane : listaPrzedmiotowWyciaganych) vn[przedmiotyWyciagane] = 0;                // Sposób krótszy
            for (int i = 0; i < listaPrzedmiotowWkladanych.size(); i++) vn[listaPrzedmiotowWkladanych.get(i)] = 1;      // Sposób dłuższy

            if (funkcjaCelu(vn) > funkcjaCelu(best)) {
                if (listaTabu.contains(ruch) || listaTabu.contains(ruch_do_sprawdzenia)) czy_jest_w_tabu = true;
            }
            //System.out.println("Ruch: " + ruch.toString());
        } while (czy_jest_w_tabu);
    }

    static public void wybierz_rozwiazanie_z_otoczenia2() {

        Random rand = new Random();
        int losowy_przedmiot_wyciagany, losowy_przedmiot_wkladany, ilosc_wyciaganych;
        boolean czy_jest_w_tabu;

        do {
            System.arraycopy(vc, 0, vn, 0, n);
            czy_jest_w_tabu = false;
            listaPrzedmiotowWyciaganych.clear();
            listaPrzedmiotowWkladanych.clear();
            ruch.clear();
            ruch_do_sprawdzenia.clear();
            ilosc_wyciaganych = rand.nextInt(3) + 1;

            //System.out.println("vn = " + Arrays.toString(vn));

            for (int i = 0; i < ilosc_wyciaganych; i++) {
                int k = 0;
                do {
                    losowy_przedmiot_wyciagany = rand.nextInt(n);
                    k++;
                    if (k > 10) break;
                }
                while (vn[losowy_przedmiot_wyciagany] == 0);
                listaPrzedmiotowWyciaganych.add(losowy_przedmiot_wyciagany);
                vn[losowy_przedmiot_wyciagany] = 0;
            }

            //System.out.println("Wyciągamy: " + listaPrzedmiotowWyciaganych.toString());
            //System.out.println("vn = " + Arrays.toString(vn));

            for (int i = 0; i < n * 2; i++) {
                int k = 0;
                do {
                    losowy_przedmiot_wkladany = rand.nextInt(n);
                    k++;
                    if (k > 10) break;
                }
                while (vn[losowy_przedmiot_wkladany] == 1 || listaPrzedmiotowWyciaganych.contains(losowy_przedmiot_wkladany));
                if (czy_przedmiot_miesci_sie_w_plecaku(losowy_przedmiot_wkladany, vn)) {
                    listaPrzedmiotowWkladanych.add(losowy_przedmiot_wkladany);
                    vn[losowy_przedmiot_wkladany] = 1;
                }
            }

            //System.out.println("Wkładamy: " + listaPrzedmiotowWkladanych.toString());
            //System.out.println("vn = " + Arrays.toString(vn));

            ruch.add(listaPrzedmiotowWyciaganych);
            ruch.add(listaPrzedmiotowWkladanych);
            ruch_do_sprawdzenia.add(listaPrzedmiotowWkladanych);
            ruch_do_sprawdzenia.add(listaPrzedmiotowWyciaganych);

            for (Integer przedmiotyWyciagane : listaPrzedmiotowWyciaganych) vn[przedmiotyWyciagane] = 0;                // Sposób krótszy
            for (int i = 0; i < listaPrzedmiotowWkladanych.size(); i++) vn[listaPrzedmiotowWkladanych.get(i)] = 1;      // Sposób dłuższy

            if (funkcjaCelu(vn) > funkcjaCelu(best)) {
                if (listaTabu.contains(ruch) || listaTabu.contains(ruch_do_sprawdzenia)) czy_jest_w_tabu = true;
            }
            //System.out.println("Ruch: " + ruch.toString());
        } while (czy_jest_w_tabu);
    }

    static public void uaktualnij_liste_tabu() {

        List<List<Integer>> nowy_ruch = new ArrayList<>();
        List<Integer> listaPrzedmiotowWkladanych2 = new ArrayList<>(listaPrzedmiotowWyciaganych);
        List<Integer> listaPrzedmiotowWyciaganych2 = new ArrayList<>(listaPrzedmiotowWkladanych);
        nowy_ruch.add(listaPrzedmiotowWkladanych2);
        nowy_ruch.add(listaPrzedmiotowWyciaganych2);
        if (listaTabu.size() >= dlugoscListyTabu) listaTabu.remove(0);
        listaTabu.add(nowy_ruch);
        //System.out.println("Lista Tabu: " + listaTabu.toString());
    }

    static public void wybierz_rozwiazanie_poczatkowe_losowe() {

        Random rand = new Random();
        Arrays.fill(vc, 0);
        int losowy_przedmiot;

        for (int i=0; i<n*2; i++) {
            do losowy_przedmiot = rand.nextInt(n);
            while (vc[losowy_przedmiot] == 1);
            if (czy_przedmiot_miesci_sie_w_plecaku(losowy_przedmiot,vc)) vc[losowy_przedmiot] = 1;
        }
    }

    static public void wybierz_rozwiazanie_poczatkowe_najoptymalniejsze() {

        Arrays.fill(vc, 0);
        int najoptymalniejszy_przedmiot = 0;
        double max;
        for (int i=0; i<n; i++) {
            max = 0;
            for (int j=0; j<n; j++) if (wagi[j] > max && vc[j] == 0) { max = wagi[j]; najoptymalniejszy_przedmiot = j; }
            if (czy_przedmiot_miesci_sie_w_plecaku(najoptymalniejszy_przedmiot,vc)) vc[najoptymalniejszy_przedmiot] = 1;
        }
    }

    static void wypiszDanePoczatkowe() {

        String spacje, spacje2, spacje3;
        System.out.println("============= DANE =============");
        System.out.println("Ilość przedmiotów n: " + n);
        System.out.println("Pojemność plecaka B: " + B);
        System.out.println("Wartości (w) i wielkości (s) przedmiotów:");
        System.out.println("       w       s       (w/s = ilość wartości na 1 wielkości)");
        for (int i = 0; i < n ; i++) {
            if( w[i] > 99) spacje2 = "     ";
            else if ( w[i] > 9) spacje2 = "      ";
            else spacje2 = "       ";
            if( i > 98) spacje = ":   ";
            else if (i > 8) spacje = ":    ";
            else spacje = ":     ";
            if( s[i] > 99) spacje3 = "     ";
            else if (s[i] > 9) spacje3 = "      ";
            else spacje3 = "       ";
            System.out.println( i+1 + spacje + w[i] + spacje2 + s[i] + spacje3 + wagi[i]);
        }
        System.out.println("================================");
    }

    static void wypiszDaneKoncowe() {

        int pojemnosc_plecaka = 0;
        String spacje, spacje2, spacje3;
        for (int i = 0; i < n; i++) if(best[i] == 1) pojemnosc_plecaka = s[i] + pojemnosc_plecaka;
        System.out.println("============= WYNIK =============");
        System.out.println("Maksymalna pojemność plecaka B: " + B);
        System.out.println("Zajęte miejsce plecaka po Tabu: " + pojemnosc_plecaka);
        System.out.println("Wyliczona wartość plecaka po Tabu: " + funkcjaCelu(best));

        System.out.println("Przedmioty w plecaku:");
        System.out.println("       w       s       (w/s = ilość wartości na 1 wielkości)");
        for (int i = 0; i < n ; i++) {
            if( w[i] > 99) spacje2 = "     ";
            else if ( w[i] > 9) spacje2 = "      ";
            else spacje2 = "       ";
            if( i > 98) spacje = ":   ";
            else if (i > 8) spacje = ":    ";
            else spacje = ":     ";
            if( s[i] > 99) spacje3 = "     ";
            else if (s[i] > 9) spacje3 = "      ";
            else spacje3 = "       ";
            if( best[i] == 1) System.out.println( i+1 + spacje + w[i] + spacje2 + s[i] + spacje3 + wagi[i]);
        }
        System.out.println("================================");
    }

    public static void main(String[] args) {

        //wczytajDane();
        //wypiszDanePoczatkowe();
        //przeszukiwanieTabu();
        //wypiszDaneKoncowe();

        for (int i=0; i<10; i++) {
            wczytajDane();
            przeszukiwanieTabu();
            System.out.println(funkcjaCelu(best));
            //System.out.println((double) (funkcjaCelu(best)) / 10000);                     // Dla wartości z ułamkiem
        }
    }

}
