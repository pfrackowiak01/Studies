import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Ant_Colony {

    public static String name;
    public static String type;

    public static int n;    // Ilość miast

    public static double[][] V = new double[n][2];     // Zbiór miast
    public static double[][] E = new double[n][n];     // Zbiór krawędzi (połączeń między miastami)
    public static double[][] F = new double[n][n];     // Tablica feromonów (ilość feromonów w danym mieście)
    public static int[] x = new int[n];                // Wektor zmienny tworzący permutacje (reprezentacja ścieżkowa)
    public static int odwiedzone[] = new int[n+1];     // wektor z rozwiązaniem np. 0 5 3 12

    public static int K;               // Ilość mrówek
    public static int MAX_ITER = 1000;      // Maksymalna ilość wykonań algorytmu

    public static void WczytajMiasta() throws FileNotFoundException {

        try {
            File file = new File("berlin52tsp.sec");
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
            K = n;

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

            // tablica[y][x] - pierwszy wiersz, druga kolumna
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
        catch(FileNotFoundException e) {
            System.out.println("""
                    ===================================================================
                    Nie znaleziono pliku, aby wczytać dane - podaj prawidłową ścieżkę!
                    ===================================================================""");
            throw new RuntimeException(e);
        }
    }

    public static void AlgorytmMrowkowy_1() {

        inicjuj_feromony();
        for (int k=0; k<K; k++) {
            //umieść mrówkę k w pewnym węźle początkowym
        }
        for (int i=1; i<MAX_ITER; i++) {
            for (int k=0; k<K; k++) {
                //dla k wybrać następny wierzchołek na ścieżce
            }
            //uaktualnij ilość feromonów na ścieżkach
        }
        //return best
    }

    public static void inicjuj_feromony() {
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                F[x][y] = 1;
            }
        }
    }

    public static void WypiszTabliceKosztow() {

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                System.out.print(E[x][y] + ", ");
            }
            System.out.println();
        }
    }

    public static double dlugoscTrasy(int[] trasa) {

        double dlugosctrasy = 0;
        for (int i = 0; i < n; i++) dlugosctrasy += E[trasa[i]][trasa[i+1]];
        return dlugosctrasy;
    }

    public static void main(String[] args) throws FileNotFoundException {

        WczytajMiasta();
        WypiszTabliceKosztow();
    }

}
