import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;

import static java.util.Arrays.sort;
import static java.util.Collections.reverseOrder;

public class Main {

    public static int B = 0;    //Pojemność pojemnika
    public static int n = 0;    //Ilość Przedmiotów
    public static int Popt = 0; //najoptymalniejszy wynik
    public static int M = n;    //Ilość Pojemników
    public static int[] zajetoscPojemnika = new int[M];    //zajetosc pojemnika
    public static Integer[] Przedmioty = new Integer[n];   //wartości wszystkich przedmiotów
    public static int[] x = new int[n];   //wektor zmiennych, czyli do których pojemników są zapisane przedmioty

    public static void WczytajPrzedmioty() throws FileNotFoundException {

        File file = new File("binpack1.txt");
        Scanner odczyt = new Scanner(file);
        String pierwszalinia = odczyt.nextLine();

        String[] pierwszaLinia_podzielona = pierwszalinia.split(" ");
        B = Integer.parseInt(pierwszaLinia_podzielona[0]);
        n = Integer.parseInt(pierwszaLinia_podzielona[1]);
        Popt = Integer.parseInt(pierwszaLinia_podzielona[2]);

        M = n;
        Przedmioty = new Integer[n];
        x = new int[n];
        zajetoscPojemnika = new int[M];

        for(int k=0; k<n; k++) {
            String kolejnaLinia = odczyt.nextLine();
            Przedmioty[k] = Integer.parseInt(kolejnaLinia);
        }
    }

    public static void WypiszTablice(int[] tablica) {
        for (int i = 0; i < n; i++) System.out.println("Przedmiot " + (i+1) + " jest w pojemniku " + (tablica[i]+1));
    }

    public static int NajbardziejWypelniony(int przedmiot) {
        int max = -1, wynik = 0;
        for (int i = 0; i < M; i++) if((Przedmioty[przedmiot] + zajetoscPojemnika[i]) <= B && zajetoscPojemnika[i] > max) {wynik = i; max = zajetoscPojemnika[i];}
        return wynik;
    }

    public static int NajmniejWypelniony(int przedmiot) {
        int min = 999999, wynik = 0;
        for (int i = 0; i < M; i++) if((Przedmioty[przedmiot] + zajetoscPojemnika[i]) <= B && zajetoscPojemnika[i] < min) {wynik = i; min = zajetoscPojemnika[i];}
        return wynik;
    }

    public static int next_fit() {
        int pojemnik = 0, i = 0;
        while (i < n) {
            if (Przedmioty[i] < (150 - zajetoscPojemnika[pojemnik])) {
                zajetoscPojemnika[pojemnik] = zajetoscPojemnika[pojemnik] + Przedmioty[i];
                x[i] = pojemnik;
                i++;
            }
            else pojemnik++;
        }
        return pojemnik+1;   //+1 bo uwzględniamy pojemnik o zerowym indeksie
    }

    public static int first_fit() {
        int pojemnik = 0, i = 0, max = 0; //max - zlicza wszystkie uzyte pojemniki
        while (i < n) {
            if ((Przedmioty[i] + zajetoscPojemnika[pojemnik]) <= B) {
                zajetoscPojemnika[pojemnik] = zajetoscPojemnika[pojemnik] + Przedmioty[i];
                x[i] = pojemnik;
                i++;
                if (pojemnik > max) max = pojemnik;
                pojemnik = 0;
            } else pojemnik++;
        }
        return max+1;  //dodajemy 1, bo należy uwzględnić jeszcze pojemnik o indeksie 0
    }

    public static int best_fit() {
        int pojemnik = 0, i = 0, max = 0; //max - zlicza wszystkie uzyte pojemniki
        while (i < n) {
            pojemnik = NajbardziejWypelniony(i);
            zajetoscPojemnika[pojemnik] = zajetoscPojemnika[pojemnik] + Przedmioty[i];
            x[i] = pojemnik;
            i++;
            if (pojemnik > max) max = pojemnik;
        }
        return max+1;  //dodajemy 1, bo należy uwzględnić jeszcze pojemnik o indeksie 0
    }

    public static int worst_fit() {
        int pojemnik = 0, i = 0, max = 0; //max - zlicza wszystkie uzyte pojemniki
        while (i < n) {
            pojemnik = NajmniejWypelniony(i);
            zajetoscPojemnika[pojemnik] = zajetoscPojemnika[pojemnik] + Przedmioty[i];
            x[i] = pojemnik;
            i++;
            if (pojemnik > max) max = pojemnik;
        }
        return max+1;  //dodajemy 1, bo należy uwzględnić jeszcze pojemnik o indeksie 0
    }

    public static int first_fit_decreasing() {
        int pojemnik = 0, i = 0, max = 0; //max - zlicza wszystkie uzyte pojemniki
        Arrays.sort(Przedmioty, reverseOrder());
        while (i < n) {
            if ((Przedmioty[i] + zajetoscPojemnika[pojemnik]) <= B) {
                zajetoscPojemnika[pojemnik] = zajetoscPojemnika[pojemnik] + Przedmioty[i];
                x[i] = pojemnik;
                i++;
                if (pojemnik > max) max = pojemnik;
                pojemnik = 0;
            } else pojemnik++;
        }
        return max+1;  //dodajemy 1, bo należy uwzględnić jeszcze pojemnik o indeksie 0
    }

    public static void main(String[] args) throws FileNotFoundException {

        WczytajPrzedmioty();
        //int wynik = next_fit();                 //wynik = 65
        //int wynik = first_fit();                //wynik = 50
        //int wynik = best_fit();                 //wynik = 50
        //int wynik = worst_fit();                //wynik = 120
        int wynik = first_fit_decreasing();     //wynik = 49
        System.out.println("=====================================");
        System.out.println("Zajetych pojemników jest " + wynik);
        System.out.println("Pojemność pojemnika to " + B);
        System.out.println("Ilość wszystkich pojemników " + n);
        System.out.println("Najlepszy wynik to " + Popt);
        System.out.println("=====================================");
        System.out.println("Tablica z przedmiotami:");
        System.out.println(Arrays.toString(Przedmioty));
        System.out.println("Tablica ze wskaźnikami, czyli który przedmiot wyląduje w którym pojemniku:");
        WypiszTablice(x);
        System.out.println("Tablica z wagą przedmiotów w każdym pojemniku (nie może być większa od " + B + "):");
        System.out.println(Arrays.toString(zajetoscPojemnika));
    }
}