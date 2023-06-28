import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AntColony {

    public static int[] trasa;
    public static double Optymalna = 7526;

    public static int n;                  // Ilość miast - oraz - Ilość mrówek - to ta sama liczba

    public static double[][] V;           // Zbiór miast
    public static double[][] E;           // Zbiór krawędzi (połączeń między miastami)
    public static double[][] F;           // Tablica feromonów (ilość feromonów w danym mieście)
    public static int[] x;                // Wektor zmienny tworzący permutacje (reprezentacja ścieżkowa)
    public static int[] najlepsza_trasa;  // wektor z rozwiązaniem np. 0 5 3 12

    public static int MAX_ITER = 100;    // Maksymalna ilość wykonań algorytmu

    public static void wczytajDane(String filename) throws FileNotFoundException {   // Wczytanie współrzędnych miast z pliku

        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            for (int i=0; i<3; i++) scanner.nextLine();
            String[] line = scanner.nextLine().split(" ");

            n = Integer.parseInt(line[1]);
            V = new double[n][2];
            E = new double[n][n];
            F = new double[n][n];
            x = new int[n];
            najlepsza_trasa = new int[n];

            for (int i=0; i<2; i++) scanner.nextLine();
            for (int i=0; i<n; i++) {
                line = scanner.nextLine().split(" ");
                V[i][0] = Double.parseDouble(line[1]);
                V[i][1] = Double.parseDouble(line[2]);
            }
            scanner.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("""
                    ===================================================================
                    Nie znaleziono pliku, aby wczytać dane - podaj prawidłową ścieżkę!
                    ===================================================================""");
            throw new RuntimeException(e);
        }
    }

    public static double euklides(int miasto1, int miasto2) {
        return Math.sqrt( Math.pow(V[miasto1-1][0] - V[miasto2-1][0], 2) + Math.pow(V[miasto1-1][1] - V[miasto2-1][1], 2));
    }

    public static double dlugoscTrasy(int[] trasa) {

        int suma = 0;
        for (int i=0; i<trasa.length-1; i++) suma += euklides(trasa[i],trasa[i+1]);
        suma += euklides(trasa[trasa.length-1],trasa[0]);
        return suma;
    }

    public static void antColony_wersja1(double a, double b, double r) throws FileNotFoundException {


        trasa = new int[n];
        int[] ants = new int[n];
        ArrayList<Integer>[] trasy = new ArrayList[n];

        for(int i=0; i<n; i++) {
            trasy[i] = new ArrayList<>();
            ants[i] = i+1;                               // Umieszczenie mrówki k w pewnym węźle początkowym
            trasy[i].add(ants[i]);
            for(int j=0; j<n; j++) F[i][j]=1;            // Inicjalizowanie feromonów τij dla każdej krawędzi (i,j) ∈ E
        }

        for(int i=0; i<n-1; i++) {

            //Dla k wybierz probabilistycznie następny wierzchołek na ścieżce
            for(int j=0; j<n; j++) {
                double sum = 0;
                for(int k=0; k<n; k++) {
                    if(!trasy[j].contains(k+1) && euklides(ants[j],k+1)!=0) {
                        sum += Math.pow(F[ants[j]-1][k],a)*Math.pow(1d/euklides(ants[j],k+1),b);
                    }
                }
                double[] p = new double[n];

                for(int k=0; k<n; k++) {
                    if(!trasy[j].contains(k+1) && euklides(ants[j],k+1)!=0)
                        p[k] = (Math.pow(F[ants[j]-1][k],a)*Math.pow(1d/euklides(ants[j],k+1),b))/sum;
                    else
                        p[k] = 0;
                }

                double suma = 0;
                double los = Math.min(Math.random(),0.9999999999d);
                int nm = 0;
                for(int k=0; k<p.length; k++) {
                    suma += p[k];
                    if(los<=suma && p[k]!=0) {
                        nm = k;
                        break;
                    }
                }
                trasy[j].add(nm+1);
                ants[j] = nm+1;
            }

            // Uaktualnienie zawartości feromonu na ścieżkach
            double dtk[][] = new double[n][n];
            double Q = 100;
            for(int i2=0; i2<n; i2++) {
                for(int j2=0; j2<n; j2++) {
                    if(euklides(i2+1,j2+1) != 0)
                        dtk[i2][j2] = Q/euklides(i2+1, j2+1);
                    else
                        dtk[i2][j2] = 0;
                }
            }

            double dt[][] = new double[n][n];
            for(int i2=0; i2<n; i2++) {
                for (int j2 = 0; j2 < n; j2++) {
                    dt[i2][j2] = 0;
                    for (int k2 = 0; k2 < n; k2++) {
                        if(ants[k2] == i2+1 && ants[k2] == j2+1)
                            dt[i2][j2] += dtk[i2][j2]/2d;     //wykonany jest 2 razy, stąd dzielenie przez 2
                    }
                }
            }

            for(int i2=0; i2<n; i2++) {
                for (int j2 = 0; j2 < n; j2++) {
                    F[i2][j2] = (1-r) * F[i2][j2] + dt[i2][j2];
                }
            }
        }

        ArrayList<Integer> besttrasa = trasy[0];
        double bestResult = Double.MAX_VALUE;
        for(int i=0; i<n; i++) {
            int[] trasa = new int[n];
            for(int j=0; j<n; j++) trasa[j] = trasy[i].get(j);
            if(dlugoscTrasy(trasa)<bestResult) {
                besttrasa = trasy[i];
                bestResult = dlugoscTrasy(trasa);
            }
        }
        for(int i=0; i<besttrasa.size(); i++) najlepsza_trasa[i] = besttrasa.get(i);
        //return besttrasa;
    }

    public static void antColony_wersja2(double a, double b, double r, double Q){

        trasa = new int[n];

        int[] ants = new int[n];
        ArrayList<Integer>[] trasy = new ArrayList[n];

        ArrayList<Integer> besttrasa = trasy[0];
        double bestResult = Double.MAX_VALUE;

        for(int x=0; x<MAX_ITER; x++) {

            for (int i = 0; i < n; i++) {
                trasy[i] = new ArrayList<>();
                ants[i] = i+1;                                 // Umieszczenie mrówki k w pewnym węźle początkowym
                trasy[i].add(ants[i]);
                for (int j = 0; j < n; j++) F[i][j] = 1;       // Inicjalizowanie feromonów τij dla każdej krawędzi (i,j) ∈ E
            }

            for (int i = 0; i < n - 1; i++) {

                //Dla k wybierz probabilistycznie następny wierzchołek na ścieżce
                for (int j = 0; j < n; j++) {
                    double sum = 0;
                    for (int k = 0; k < n; k++) {
                        if (!trasy[j].contains(k + 1) && euklides(ants[j], k + 1) != 0) {
                            sum += Math.pow(F[ants[j] - 1][k], a) * Math.pow(1d / euklides(ants[j], k + 1), b);
                        }
                    }
                    double[] p = new double[n];

                    for (int k = 0; k < n; k++) {
                        if (!trasy[j].contains(k + 1) && euklides(ants[j], k + 1) != 0)
                            p[k] = (Math.pow(F[ants[j] - 1][k], a) * Math.pow(1d / euklides(ants[j], k + 1), b)) / sum;
                        else
                            p[k] = 0;
                    }

                    double suma = 0;
                    double los = Math.min(Math.random(), 0.9999999999d);
                    int nm = 0;
                    for (int k = 0; k < p.length; k++) {
                        suma += p[k];
                        if (los <= suma && p[k] != 0) {
                            nm = k;
                            break;
                        }
                    }
                    trasy[j].add(nm + 1);
                    ants[j] = nm + 1;
                }
            }

            // Uaktualnienie zawartości feromonu na ścieżkach
            double dtk[][] = new double[n][n];
            for (int i2 = 0; i2 < n; i2++) {
                for (int j2 = 0; j2 < n; j2++) {
                    if (euklides(i2 + 1, j2 + 1) != 0)
                        dtk[i2][j2] = Q / euklides(i2 + 1, j2 + 1);
                    else
                        dtk[i2][j2] = 0;
                }
            }

            double dt[][] = new double[n][n];
            for (int i2 = 0; i2 < n; i2++) {
                for (int j2 = 0; j2 < n; j2++) {
                    dt[i2][j2] = 0;
                    for (int k2 = 0; k2 < n; k2++) {
                        if (ants[k2] == i2 + 1 && ants[k2] == j2 + 1)
                            dt[i2][j2] += dtk[i2][j2] / 2d;         //wykonany jest 2 razy, stąd dzielenie przez 2
                    }
                }
            }

            for (int i2 = 0; i2 < n; i2++) {
                for (int j2 = 0; j2 < n; j2++) F[i2][j2] = (1 - r) * F[i2][j2] + dt[i2][j2];
            }

            for(int i=0; i<n; i++) {
                int[] trasa = new int[n];
                for(int j=0; j<n; j++)
                    trasa[j] = trasy[i].get(j);
                if(dlugoscTrasy(trasa)< bestResult) {
                    besttrasa = new ArrayList<>();
                    for(int j=0; j<n; j++)
                        besttrasa.add(trasa[j]);
                    bestResult = dlugoscTrasy(trasa);
                }
            }

        }
        for(int i=0; i<besttrasa.size(); i++) najlepsza_trasa[i] = besttrasa.get(i);
        //return besttrasa;
    }

    public static void main(String[] args) throws FileNotFoundException {

        /*
        wczytajDane("ant_tours/kroA100.tsp");
        //ArrayList<Integer> trasa = antColony_wersja1(1,5,0.5);
        ArrayList<Integer> trasa = antColony_wersja2(1,5,0.5,1);

        System.out.print("Znaleziona trasa: ");
        int[] ary = new int[n];
        for(int i=0; i<trasa.size(); i++) {
            System.out.print(trasa.get(i)+"-");
            ary[i] = trasa.get(i);
        }
        System.out.println(trasa.get(0));
        System.out.println("Długość tej trasy = " + dlugoscTrasy(ary));
        System.out.println("Rozwiązanie gorsze od optimum o " + (100*(dlugoscTrasy(ary)/Optymalna-1))+" %");
        */

        String[] filenames = new String[] {
                "ant_tours/kroA100.tsp",
                "ant_tours/kroA150.tsp",
                "ant_tours/kroA200.tsp",
                "ant_tours/kroB100.tsp",
                "ant_tours/kroB150.tsp",
                "ant_tours/kroB200.tsp",
                "ant_tours/kroC100.tsp",
                "ant_tours/kroD100.tsp",
                "ant_tours/kroE100.tsp"
        };

        for (int j=0; j<filenames.length; j++) {
            wczytajDane(filenames[j]);
            System.out.println("\n" + (j+1) + ": wersja1 - " + filenames[j]);
            for (int i = 0; i < 10; i++) {
                antColony_wersja1(1, 5, 0.5);
                System.out.println(Math.round(dlugoscTrasy(najlepsza_trasa)));
            }
            System.out.println("\n" + (j+1) + ": wersja2 - " + filenames[j]);
            for (int i = 0; i < 10; i++) {
                antColony_wersja2(1, 5, 0.5, 1);
                System.out.println(Math.round(dlugoscTrasy(najlepsza_trasa)));
            }
        }

    }
}
