package Exhaustive_greedy_search;

public class Plecak {

    static int n = 8;
    static int B = 21;
    static int[] s = new int[]{3, 9, 12, 4, 6, 2, 1, 6};
    static int[] w = new int[]{6, 4, 7, 9, 13, 11, 5, 6};
    static double[] wartoscNa1 = new double[n];
    static int[] posortowane = new int[n];

    static int[] plecak = new int[n];
    static int[] najlepszy = new int[n];


    public int funkcjaCelu() {
        int suma = 0;
        for (int i = 0; i <= n; i++) {
            if(plecak[i] == 1) suma = plecak[i] + suma;
        }
        return suma;
    }

    public boolean czyMiesci() {
        int pojemnosc = 0;
        for (int i = 0; i < 9; i++) {
            if(plecak[i] == 1) pojemnosc = plecak[i] + pojemnosc;
            if(pojemnosc > B) return false;
        }
        return true;
    }

    public void sortuj() {
        double waga;
        for (int i = 0; i <= n; i++) {
            waga = w[i] / s[i];
            wartoscNa1[i] = waga;
        }
/*
        int temp;
        int zmiana = 1;
        while(zmiana > 0){
            zmiana = 0;
            for(int i=0; i<tab.length-1; i++){
                if(tab[i]>tab[i+1]){
                    temp = tab[i+1];
                    tab[i+1] = tab[i];
                    tab[i] = temp;
                    zmiana++;
                }
            }*/
        }

    static void ExhaustiveSearch() {
        char[] rozwiazanie;
        String binarnie;
        for (int i = 0; i < Math.pow(2,n); i++) {
            binarnie = Integer.toBinaryString(i);
            rozwiazanie = binarnie.toCharArray();
            System.out.println(binarnie);

            for (int j = n - 1; j >= 0; j--) {
                for (int g = binarnie.length() - 1; g >= 0; g--) {
                    plecak[j] = rozwiazanie[g];
                    j--;
                }
                plecak[j] = 0;
            }
            wypiszTablice(plecak);
        }
    }

    static void wypiszTablice(int[] tab) {
        for (int i = 0; i <= tab.length ; i++) {
            System.out.println(tab[i]);
        }
    }


    public static void main(String[] args) {

        ExhaustiveSearch();
    }

}
