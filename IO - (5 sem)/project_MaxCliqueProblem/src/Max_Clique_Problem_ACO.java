import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Max_Clique_Problem_ACO {

    private static int NUM_ANTS = 125;
    private static int MAX_ITER = 1000;
    private static double ALPHA = 1;
    private static double BETA = 1;
    private static double RHO = 0.1;
    private static double Q = 500;

    private static int[][] graf;
    private static double[][] feromony;
    private static int[] rozwiazanie;
    private static int wielkoscRozwiazania;

    public static void wczytajDane(String filename) throws FileNotFoundException {   // Wczytanie krawędzi z pliku

        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            String[] line;

            do line = scanner.nextLine().split(" ");
            while (!line[0].equals("p"));

            NUM_ANTS = Integer.parseInt(line[2]);
            graf = new int[NUM_ANTS][NUM_ANTS];

            for (int i = 0; i < NUM_ANTS; i++) {
                line = scanner.nextLine().split(" ");
                int v1 = Integer.parseInt(line[1]);
                int v2 = Integer.parseInt(line[2]);
                graf[v1][v2] = 1;
                graf[v2][v1] = 1;
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

    public static void maxCligueAco(double alfa, double beta, double rho, double q) {

        ALPHA = alfa;
        BETA = beta;
        RHO = rho;
        Q = q;

        // Inicjalizowanie feromonów dla każdej krawędzi w grafie
        feromony = new double[NUM_ANTS][NUM_ANTS];
        for (int i = 0; i < NUM_ANTS; i++) {
            for (int j = 0; j < NUM_ANTS; j++) {
                if (graf[i][j] == 1) feromony[i][j] = 1;
            }
        }

        // run ACO
        for (int iteration = 0; iteration < MAX_ITER; iteration++) {
            // create ants
            Ant[] ants = new Ant[NUM_ANTS];
            for (int i = 0; i < NUM_ANTS; i++) {
                ants[i] = new Ant(NUM_ANTS);
            }

            // have each ant find a solution
            for (int i = 0; i < NUM_ANTS; i++) {
                ants[i].findSolution();
            }

            // update pheromones
            for (int i = 0; i < NUM_ANTS; i++) {
                Ant ant = ants[i];
                for (int j = 0; j < ant.path.size() - 1; j++) {
                    int v1 = ant.path.get(j);
                    int v2 = ant.path.get(j + 1);
                    feromony[v1][v2] += Q / ant.path.size();
                    feromony[v2][v1] = feromony[v1][v2];
                }
            }

            // evaporate pheromones
            for (int i = 0; i < NUM_ANTS; i++) {
                for (int j = 0; j < NUM_ANTS; j++) {
                    feromony[i][j] *= (1 - RHO);
                }
            }

            // update best solution
            for (int i = 0; i < NUM_ANTS; i++) {
                Ant ant = ants[i];
                if (ant.path.size() > wielkoscRozwiazania) {
                    wielkoscRozwiazania = ant.path.size();
                    rozwiazanie = new int[wielkoscRozwiazania];
                    for (int j = 0; j < wielkoscRozwiazania; j++) {
                        rozwiazanie[j] = ant.path.get(j);
                    }
                }
            }
        }
    }

    private static class Ant {
        private int numVertices;
        private boolean[] visited;
        private List<Integer> path;

        public Ant(int numVertices) {
            this.numVertices = numVertices;
            this.visited = new boolean[numVertices];
            this.path = new ArrayList<>();
        }

        public void findSolution() {
            int currentVertex = (int) (Math.random() * numVertices);
            path.add(currentVertex);
            visited[currentVertex] = true;

            while (path.size() < numVertices) {
                int nextVertex = -1;
                double maxProbability = -1;

                for (int i = 0; i < numVertices; i++) {
                    if (!visited[i] && graf[currentVertex][i] == 1) {
                        double probability = probability(currentVertex, i);
                        if (probability > maxProbability) {
                            maxProbability = probability;
                            nextVertex = i;
                        }
                    }
                }

                if (nextVertex == -1) break;

                path.add(nextVertex);
                visited[nextVertex] = true;
                currentVertex = nextVertex;
            }
        }

        private double probability(int v1, int v2) {
            double numerator = Math.pow(feromony[v1][v2], ALPHA) *
                    Math.pow(1.0 / graf[v1][v2], BETA);
            double denominator = 0;
            for (int i = 0; i < numVertices; i++) {
                if (!visited[i] && graf[v1][i] == 1) {
                    denominator += Math.pow(feromony[v1][i], ALPHA) *
                            Math.pow(1.0 / graf[v1][i], BETA);
                }
            }
            return numerator / denominator;
        }
    }

    public static int srednia(int[] liczby) {
        int suma = 0;
        for (int i = 0; i < liczby.length; i++) suma+=liczby[i];
        return suma/liczby.length;
    }

    public static void main(String[] args) throws FileNotFoundException {

        String[] filenames = new String[] {
                "edges/C125.9.clq",
                "edges/C250.9.clq",
                "edges/C500.9.clq",
                "edges/C1000.9.clq",
                "edges/C2000.9.clq"
        };

        int[] bestknown = {34, 44, 57, 68, 80};

        for (int j = 0; j < filenames.length; j++) {
            int[] best = new int[10];
            wczytajDane(filenames[j]);
            System.out.println("\n" + (j+1) + ": " + filenames[j]);
            for (int i = 0; i < 10; i++) {
                //maxCligueAco(1, 5, 0.5, 1);
                maxCligueAco(2, 1, 0.1, 500);
                System.out.println("Max Clique:           " + Arrays.toString(rozwiazanie));
                System.out.println("Wielkość rozwiązania: " + wielkoscRozwiazania);
                best[i] = wielkoscRozwiazania;
            }
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("Najlepsza znana:      " + bestknown[j]);
            System.out.println("Średnia wielkość:     " + srednia(best));
            System.out.println("Średni błąd względny: " + ((bestknown[j]-srednia(best)) * 100 / bestknown[j]) + "%");
            System.out.println("============================================================================");
        }
    }
}
