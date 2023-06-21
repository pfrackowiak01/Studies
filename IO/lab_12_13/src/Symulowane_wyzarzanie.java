package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Symulowane_wyzarzanie {

    public static String name;
    public static String type;

    public static int m;                 // Ilość pracowników (taka sama jak ilość zadań)

    public static int[][] C;             // Tablica (2-wymiarowa) ze wszystkimi kosztami zadań wykonanych przez każdego pracownika z osobna
    public static int[] rozwiazanie;     // Tablica z rozwiązaniem (index to pracownik, a wartość to nr zadania, do którego jest przydzielony)
    public static int[] vc;              // Stare rozwiązanie (lub początkowe/losowe)
    public static int[] vn;              // Nowe rozwiązanie
    public static double T;              // Temperatura
    public static double alfa;           // Stopień schładzania
    public static int N;                 // Ilość wykonań wewnętrznej pętli (ilość dokonanych zmian w jednej iteracji)
    public static int MAX_ITER;          // Ilość wykonań zewnętrznej pętli


    public static void wczytajMiasta() throws FileNotFoundException {

        String filename = "assign100.txt";
        File file = new File(filename);
        Scanner odczyt = new Scanner(file);

        String pierwszaLinia = odczyt.nextLine();
        m = Integer.parseInt(pierwszaLinia.trim());
        C = new int[m][m];
        rozwiazanie = new int[m];
        vc = new int[m];
        vn = new int[m];

        int wiersze = 8;
        String caly_wiersz = "";
        if (filename == "assign100.txt") wiersze = 8;
        if (filename == "assign500.txt") wiersze = 39;

        for (int y = 0; y < m; y++) {
            int x = 0;
            caly_wiersz = "";
            for (int i = 0; i < wiersze; i++) {                  // dla "assign100.txt" i < 8, a dla "assign500.txt" i < 39
                String kolejnaLinia = odczyt.nextLine();
                caly_wiersz += kolejnaLinia;
            }
            String[] podzielony_wiersz = caly_wiersz.trim().split(" ");
            for (int k = 0; k < podzielony_wiersz.length; k++) {
                C[x][y] = Integer.parseInt(podzielony_wiersz[k]);
                x++;
            }
        }
    }

    public static void WypiszTabliceKosztow() {
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < m; x++) {
                System.out.print(C[x][y] + ", ");
            }
            System.out.println();
        }
    }

    public static void Symulowane_wyzarzanie() {

        Random r = new Random();
        double los, warunek;
        int i = 0, k, koszt_vc, koszt_vn, koszt_rozwiazania, p = 0;

        for (int j = 0; j < m; j++) rozwiazanie[i] = i;

        T = 100;
        alfa = 0.50 ;
        N = 10;
        MAX_ITER = 200;

        do {
            losowe_rozwiazanie();
            k = 0;
            do {
                //rozwiazanie_z_otoczenia();
                //rozwiazanie_z_otoczenia2();
                rozwiazanie_z_otoczenia3();
                los = r.nextDouble();
                koszt_vc = koszt_wykonania_zadan(vc);
                koszt_vn = koszt_wykonania_zadan(vn);
                koszt_rozwiazania = koszt_wykonania_zadan(rozwiazanie);
                warunek = Math.exp((koszt_vc - koszt_vn) / T);
                //System.out.println("Rozwiązanie vc: " + Arrays.toString(vc));
                //System.out.println("Koszt vc: " + koszt_vc);
                //System.out.println("Rozwiązanie vn: " + Arrays.toString(vn));
                //System.out.println("Koszt vn: " + koszt_vn);
                //System.out.println("Koszt roz: " + koszt_rozwiazania);
                //System.out.println("k = " + k);
                //System.out.println("i = " + i);
                //System.out.println("p = " + p);
                //System.out.println("los = " + los);
                //System.out.println("exp^vn = " + warunek);
                //System.out.println("T = " + T);
                if (koszt_vn <= koszt_vc) {
                    System.arraycopy(vn, 0, vc, 0, m);
                    k++;
                    if (koszt_vn <= koszt_rozwiazania) System.arraycopy(vn, 0, rozwiazanie, 0, m);
                } else if (los < warunek) {
                    System.arraycopy(vn, 0, vc, 0, m);
                    k++;
                }
                p++;
            } while (k < N && p < 1000);
            T = alfa * T;
            p = 0;
            i++;
        } while (i < MAX_ITER);
        System.arraycopy(vc, 0, rozwiazanie, 0, m);
    }

    public static void losowe_rozwiazanie() {

        Random r = new Random();
        int a, b, pom;

        for (int i = 0; i < m; i++) vc[i] = i;

        for (int i = 0; i < m * 2; i++) {

            do {
                a = r.nextInt(m);
                b = r.nextInt(m);
            } while (a == b);

            pom = vc[a];
            vc[a] = vc[b];
            vc[b] = pom;
        }
    }

    public static void rozwiazanie_z_otoczenia3() {   //szuka najlepszej pary do zamienienia się ze sobą zadaniami wśród możliwości dla jednego wylosowanego pracownika

        int[] pom_tablica = new int[m];
        int[] naj_tablica = new int[m];
        int i, koszt_pom, koszt_naj = Integer.MAX_VALUE, koszt_rozwiazania = koszt_wykonania_zadan(rozwiazanie);;
        Random r = new Random();

        i = r.nextInt(m);

        for (int j=0; j<m; j++){
            if (i != j) {
                System.arraycopy(vc, 0, pom_tablica, 0, m);
                pom_tablica[i] = vc[j];
                pom_tablica[j] = vc[i];
                koszt_pom = koszt_wykonania_zadan(pom_tablica);
                if (koszt_pom < koszt_naj && koszt_pom != koszt_rozwiazania) System.arraycopy(pom_tablica, 0, naj_tablica, 0, m);
                koszt_naj = koszt_wykonania_zadan(naj_tablica);
            }
        }

        System.arraycopy(naj_tablica, 0, vn, 0, m);
    }

    public static void rozwiazanie_z_otoczenia2() {   //szuka najlepszej pary do zamienienia się ze sobą zadaniami wśród wszystkich możliwości

        int[] pom_tablica = new int[m];
        int[] naj_tablica = new int[m];
        int koszt_pom, koszt_naj = Integer.MAX_VALUE, koszt_rozwiazania = koszt_wykonania_zadan(rozwiazanie);;

        for (int i=0; i<m; i++){
            for (int j=0; j<m; j++){
                if (i != j) {
                    System.arraycopy(vc, 0, pom_tablica, 0, m);
                    pom_tablica[i] = vc[j];
                    pom_tablica[j] = vc[i];
                    koszt_pom = koszt_wykonania_zadan(pom_tablica);
                    if (koszt_pom < koszt_naj && koszt_pom != koszt_rozwiazania) System.arraycopy(pom_tablica, 0, naj_tablica, 0, m);
                    koszt_naj = koszt_wykonania_zadan(naj_tablica);
                }
            }
        }
        System.arraycopy(naj_tablica, 0, vn, 0, m);
    }

    public static void rozwiazanie_z_otoczenia() {

        Random r = new Random();
        int a, b;

        System.arraycopy(vc, 0, vn, 0, m);

        do {
            a = r.nextInt(m);
            b = r.nextInt(m);
        } while (a == b);

        vn[a] = vc[b];
        vn[b] = vc[a];
    }

    public static int koszt_wykonania_zadan(int[] zadania) {

        int koszt = 0;
        for (int i = 0; i < m; i++) koszt += C[i][zadania[i]];
        return koszt;
    }

    //public static int

    public static void main(String[] args) throws FileNotFoundException {

        wczytajMiasta();
        //System.out.println(Arrays.deepToString(E));
        //WypiszTabliceKosztow();
        Symulowane_wyzarzanie();
        System.out.println("\n<================( Przypisanie " + m + " pracowników do " + m + " zadań )================>");
        System.out.println("Zaczynając od pierwszego pracownika przypisywane są im numery zadań: " + Arrays.toString(rozwiazanie));
        System.out.println("Łączny koszt wykonania zadań przez pracowników: \n" + koszt_wykonania_zadan(rozwiazanie));

        for (int i=0; i<9; i++) {
            Symulowane_wyzarzanie();
            System.out.println(/*"Iteracja " + i +" : " + */koszt_wykonania_zadan(rozwiazanie));
        }
    }
}
