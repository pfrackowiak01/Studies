import javax.xml.stream.Location;
import java.util.ArrayList;
import java.util.Random;

public class RojCzastek {


    static int MAX_ITER = 100;          // Ilość wykonań pętli algorytmu
    static int n = 50;                  // Wielkość roju
    static int d = 2;                   // Dimension - przestrzeń
    static double d_min = -5.12;
    static double d_max = 5.12;
    static double d_przecinek = 2;       // Ilość zer po przecinku
    static double fi1 = 0.2;            // Współczynnik przyspieszenia 1
    static double fi2 = 0.2;            // Współczynnik przyspieszenia 2

    static private ArrayList<Particle> swarm;
    static private double[] fitnessValueList;
    static private double[] pBest;
    static private double[] gBest;
    static private ArrayList<Location> pBestLocation;
    static private ArrayList<Location> gBestLocation;

    static double[][] x = new double[n][d];
    static double[][] v = new double[n][d];
    static double[] y = new double[n];


    public static int losowanieCzasteczki() {
        Random rand = new Random();
        int max = rand.nextInt((int) (d_max * (Math.pow(10,d_przecinek))));
        int int_random = rand.nextInt(d_max - d_min + 1);

    }

    public static void funkcjaPrzystosowania(double d){

    }


    public static double sphere (double[] x) {
        double sum = 0;
        for(int i=0; i<x.length; i++) {

        }
        return sum;
    }


    public static void main(String[] args) {

        System.out.println("Hello world!");
    }

}
