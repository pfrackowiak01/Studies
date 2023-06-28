import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Komiwojazer {

    public static String name;
    public static String type;

    public static int n = 52;    //Ilość miast

    public static double[][] V = new double[n][2];     //Zbiór miast
    //public static double[][] V = new double[n][2];     //Zbiór miast
    public static double[][] E = new double[n][n];     //Zbiór krawędzi (połączeń między miastami)
    public static int[] x = new int[n];     //Wektor zmienny tworzący permutacje (reprezentacja ścieżkowa)
    public static int odwiedzone[] = new int[n+1];    //wektor z rozwiązaniem np. 0 5 3 12

    public static void WczytajMiasta() throws FileNotFoundException {

        File file = new File("D:\\Semestr 5\\IO\\lab_02\\berlin52tsp.sec");
        Scanner odczyt = new Scanner(file);

        String pierwszalinia = odczyt.nextLine();
        String[] pierwszaLinia_podzielona = pierwszalinia.split(" ");
        name = pierwszaLinia_podzielona[1];

        String drugalinia = odczyt.nextLine();
        String[] drugaLinia_podzielona = drugalinia.split(" ");
        type = drugaLinia_podzielona[1];

        String trzecialinia = odczyt.nextLine();
        String czwartalinia = odczyt.nextLine();
        String[] czwartaLinia_podzielona = czwartalinia.split(" ");
        n = Integer.parseInt(czwartaLinia_podzielona[1]);

        String piatalinia = odczyt.nextLine();
        String szostalinia = odczyt.nextLine();

        V = new double[n][n];
        E = new double[n][n];
        x = new int[n];

        for (int k = 0; k < n; k++) {
            String kolejnaLinia = odczyt.nextLine();
            String[] kolejnaLinia_podzielona = kolejnaLinia.split(" ");
            V[k][0] = Float.parseFloat(kolejnaLinia_podzielona[1]);
            V[k][1] = Float.parseFloat(kolejnaLinia_podzielona[2]);
        }
/*
        // tablica[y][x]
        double wysokosc, dlugosc;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (x == y) {
                    E[y][x] = 999999;
                }
                else {
                    wysokosc = V[y][0] - V[y][1];
                    dlugosc = V[x][0] - V[x][1];
                    E[y][x] = Math.sqrt(wysokosc * wysokosc + dlugosc * dlugosc);
                }
            }
        }
*/
        // tablica[y][x]
        double wysokosc, dlugosc;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (x == y) {
                    E[x][y] = 999999;
                }
                else {
                    dlugosc = V[y][0] - V[x][0];
                    wysokosc = V[y][1] - V[x][1];
                    E[x][y] = Math.sqrt(wysokosc * wysokosc + dlugosc * dlugosc);
                }
            }
        }
    }

    public static void WypiszTabliceOdleglosci() {
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                System.out.print(E[x][y]+", ");
            }
            System.out.println();
        }
    }

    static class Punkt {
        double x;
        double y;
        boolean odwiedzone;
        public Punkt(double x, double y) {
            this.x = x;
            this.y = y;
            odwiedzone = false;
        }
        public String toString() {
            return "Współrzędne x = " + x + " y = " + y;
        }
    }

    public static void SzukanieNajkrotszejDrogi() {

        //int odwiedzone[] = new int[n+1];    //wektor z rozwiązaniem np. 0 5 3 12
        double lower;                     //przechowuje najkrótszą trasę
        int nextLine = 0;                 //przechowuje kolejne miasto do sprawdzenia tras
        boolean czyOdwiedzony;            //czy dane miasto było odwiedzone
        //double dlugosctrasy = 0;          //dlugość trasy końcowej

        //szukamy najbliższego sąsiada
        for (int i = 0; i < n; i++) {

            lower = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {

                //sprawdzamy czy odwiedzone
                czyOdwiedzony = false;
                for (int k = 0; k < n; k++) {
                    if (j == odwiedzone[k]) czyOdwiedzony = true;
                }

                if (!czyOdwiedzony && lower > E[nextLine][j]) {
                    lower = E[nextLine][j];
                    odwiedzone[i+1] = j;
                    //Może tu, ale wtedy zlicza wszystkie potencjalnie dobre
                }
            }
            nextLine = odwiedzone[i+1];
            //dlugosctrasy += lower; //TRZEBA W DOBRYM MIEJSCU WSTAWIĆ LICZENIE DLUGOSCI TRASY
        }

        //wypisanie wyniku na ekranie
        System.out.println("\nNajkrótsza trasa:");
        int k = 0, najlepszaOptymalnaTrasa = 7500;
        do {
            System.out.print(" " + odwiedzone[k] + " -->");
            k++;
        } while (k < n);
        System.out.print(" " + odwiedzone[k]);

        System.out.println("\n\nA wynosi ona: " + dlugoscTrasy(odwiedzone) + " metry");

        System.out.println("\n\nJakość tego rozwiązania wynosi " + najlepszaOptymalnaTrasa/dlugoscTrasy(odwiedzone)*100 + " %  \n(czyli o ile procent jest ono gorsze od rozwiązania\n" +
                        "wskazanego jako rozwiązanie najlepsze znane " + najlepszaOptymalnaTrasa + ")");
    }

    public static double dlugoscTrasy(int[] trasa) {

        double dlugosctrasy = 0;
        for (int i = 0; i < n; i++) dlugosctrasy += E[trasa[i]][trasa[i+1]];
        return dlugosctrasy;
    }

    public static void main(String[] args) throws FileNotFoundException {

        WczytajMiasta();
        //System.out.println(Arrays.deepToString(E));
        WypiszTabliceOdleglosci();

        SzukanieNajkrotszejDrogi();
    }
}
