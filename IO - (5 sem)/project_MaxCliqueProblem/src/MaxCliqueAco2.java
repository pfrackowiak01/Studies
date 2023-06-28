import java.util.*;

class MaxCliqueACO2 {
    private static final int NUM_ANTS = 10;
    private static final int NUM_ITERATIONS = 100;
    private static final double ALPHA = 1;
    private static final double BETA = 5;
    private static final double RHO = 0.1;
    private static final double Q = 500;

    private static int[][] graph;
    private static double[][] pheromones;
    private static int[] solution;
    private static int solutionSize;

    public static void main(String[] args) {
        // read edges from file
        int numVertices = NUM_ANTS;

        // construct graph from edges
        graph = new int[numVertices][numVertices];
        for (int[] edge : Arrays.asList(graph)) {
            int v1 = edge[0];
            int v2 = edge[1];
            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }

        // initialize pheromones
        pheromones = new double[numVertices][numVertices];
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                pheromones[i][j] = 1;
            }
        }

        // run ACO
        for (int iteration = 0; iteration < NUM_ITERATIONS; iteration++) {
            // create ants
            Ant[] ants = new Ant[NUM_ANTS];
            for (int i = 0; i < NUM_ANTS; i++) {
                ants[i] = new Ant(numVertices);
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
                    pheromones[v1][v2] += Q / ant.path.size();
                    pheromones[v2][v1] = pheromones[v1][v2];
                }
            }

            // evaporate pheromones
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    pheromones[i][j] *= (1 - RHO);
                }
            }

            // update best solution
            for (int i = 0; i < NUM_ANTS; i++) {
                Ant ant = ants[i];
                if (ant.path.size() > solutionSize) {
                    solutionSize = ant.path.size();
                    solution = new int[solutionSize];
                    for (int j = 0; j < solutionSize; j++) {
                        solution[j] = ant.path.get(j);
                    }
                }
            }
        }

        // print solution
        System.out.println("Max Clique: " + Arrays.toString(solution));
    }

    private static int getNumVertices(List<int[]> edges) {
        int maxVertex = 0;
        for (int[] edge : edges) {
            maxVertex = Math.max(maxVertex, edge[0]);
            maxVertex = Math.max(maxVertex, edge[1]);
        }
        return maxVertex + 1;
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
                    if (!visited[i] && graph[currentVertex][i] == 1) {
                        double probability = probability(currentVertex, i);
                        if (probability > maxProbability) {
                            maxProbability = probability;
                            nextVertex = i;
                        }
                    }
                }

                if (nextVertex == -1) {
                    break;
                }

                path.add(nextVertex);
                visited[nextVertex] = true;
                currentVertex = nextVertex;
            }
        }

        private double probability(int v1, int v2) {
            double numerator = Math.pow(pheromones[v1][v2], ALPHA) *
                    Math.pow(1.0 / graph[v1][v2], BETA);
            double denominator = 0;
            for (int i = 0; i < numVertices; i++) {
                if (!visited[i] && graph[v1][i] == 1) {
                    denominator += Math.pow(pheromones[v1][i], ALPHA) *
                            Math.pow(1.0 / graph[v1][i], BETA);
                }
            }
            return numerator / denominator;
        }
    }
}
