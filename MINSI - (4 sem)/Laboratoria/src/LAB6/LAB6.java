import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class LAB6 {

    public static double f(double x1, double x2){
        double f = (double) -x1*x1 -x2*x2+2;
        return f;
    }
    public static double[] chromosomNaLiczby(String chromosom){
        double[] X = new double[3];
        int indeks1 = 0, indeks2 = 0;
        String czesc1 = chromosom.substring(0,(chromosom.length()/2));
        String czesc2 = chromosom.substring((chromosom.length()/2));
        indeks1 = Integer.parseInt(czesc1,2);
        indeks2 = Integer.parseInt(czesc2,2);
        X[0] = (double)  (-2.0 + indeks1 * ( (2.0 - (-2.0) ) / (Math.pow(2,19)-1) ) );
        X[1] = (double)  (-2.0 + indeks2 * ( (2.0 - (-2.0) ) / (Math.pow(2,19)-1) ) );
        return X;
    }

    public static String decToBinary(int n)
    {
        String binarnyIndeks = "";
        for (int i = 18; i >= 0; i--) {
            int k = n >> i;
            if ((k & 1) > 0)
                binarnyIndeks += "1";
            else
                binarnyIndeks += "0";
        }
        return binarnyIndeks;
    }
    public static String wygenerujChromosom(){
        Random rng = new Random();
        final int dlugoscChromosomu = 38;
        double min=-2.0;
        double max=2.0;
        int maxIloscIndeksow = 400001;

        int indeksx1 = rng.nextInt(0,maxIloscIndeksow);
        int indeksx2 = rng.nextInt(0,maxIloscIndeksow);
        String binarnyIndeks1 = "";
        String binarnyIndeks2 = "";
        if(indeksx1 != indeksx2){
            binarnyIndeks1 = decToBinary(indeksx1);
            binarnyIndeks2 = decToBinary(indeksx2);
        }
        String binarnyIndeks = binarnyIndeks1 + binarnyIndeks2;
        return binarnyIndeks;
    }

    public static ArrayList generujPopulację(int wielkoscPopulacji){
        ArrayList<String> populacja = new ArrayList<String>(wielkoscPopulacji);
        String chromosom = "";
        for (int i = 0; i < wielkoscPopulacji; i++) {
            chromosom = wygenerujChromosom();
            populacja.add(chromosom);
        }
        return populacja;
    }

    public static double[] wyznaczFunkcjePrzystosowania(ArrayList populacja){
        double[] przystosowania = new double[populacja.size()];
        double [] x = new double[2];
        for (int i = 0; i < populacja.size(); i++) {
            x = chromosomNaLiczby(populacja.get(i).toString());
            przystosowania[i] = f(x[0],x[1]);
        }
        return przystosowania;
    }

    public static double obliczSumePrzystosowania(ArrayList populacja){
        double[] p = wyznaczFunkcjePrzystosowania(populacja);
        double suma = 0.0;
        for (int i = 0; i < p.length; i++) {
            suma += p[i];
        }
        return suma;
    }

    public static double[] wagaOsobnika(ArrayList populacja){
        double[] wagiOsobnikow = new double[populacja.size()];
        double[] fpopulacji = wyznaczFunkcjePrzystosowania(populacja);
        double sumafpopulacji = obliczSumePrzystosowania(populacja);
        for (int i = 0; i < populacja.size(); i++) {
            wagiOsobnikow[i] = fpopulacji[i] / sumafpopulacji;
        }
        return wagiOsobnikow;
    }

    public static int[] wyznaczLiczbeKopiiChromosomu (ArrayList populacja){
        Random rng = new Random();
        int[] liczbaKopii = new int[populacja.size()];
        double randomowaWartosc = 0.0;
        double[] wagi = wagaOsobnika(populacja);
        for (int i = 0; i < populacja.size(); i++) {
            randomowaWartosc = rng.nextDouble();
            if(randomowaWartosc >= wagi[i]){
                liczbaKopii[i]++;
            }
            else {
                continue;
            }
        }
        return liczbaKopii;
    }

    public static ArrayList utworzPopulacjeT(ArrayList populacja){
        int wielkoscOryginalnejPopulacji = populacja.size();
        ArrayList populacjaT = new ArrayList(wielkoscOryginalnejPopulacji);
        int[] liczbaKopiiChromosomu = wyznaczLiczbeKopiiChromosomu(populacja);
        for (int i = 0; i < wielkoscOryginalnejPopulacji; i++) {
            for (int j = 0; j < liczbaKopiiChromosomu[i]; j++) {
                populacjaT.add(populacja.get(i));
            }
        }
        if(populacjaT.size()< wielkoscOryginalnejPopulacji){
            for(int i = populacjaT.size();i<wielkoscOryginalnejPopulacji;i++){
                populacjaT.add("000000000000000000000000000000000000");
            }
        }
        return populacjaT;
    }

    public static int wybierzPartneraDoKrzyzowania(int wielkoscOryginalnejPopulacji){
        Random rand = new Random();
        int indeksPartnera = rand.nextInt(0,wielkoscOryginalnejPopulacji);
        return indeksPartnera;
    }

    public static int[] wyznaczPunktyKrzyzowania(int iloscPunktowKrzyzowania, String chromosom){
        Random rng = new Random();
        int[] punktySkrzyzowania = new int[iloscPunktowKrzyzowania]; // wyznaczenie tablicy dla wartości punktów krzyżowania
        for(int i=0;i<iloscPunktowKrzyzowania;i++){
            punktySkrzyzowania[i] = rng.nextInt(1,chromosom.length()); //wyznaczenie poszczególnych punktow krzyżowania
            for (int j = 0; j < i; j++) {
                if (punktySkrzyzowania[i] == punktySkrzyzowania[j]) {
                    punktySkrzyzowania[j] = rng.nextInt(1,chromosom.length());
                }
            }
        }
        Arrays.sort(punktySkrzyzowania);
        return punktySkrzyzowania;

    }

    public static String[] krzyzowanieWielopunktowe(String chromosom1, String chromosom2, int iloscPunktowKrzyzowania, ArrayList populacja){
        String[] czesciChromosoma1 = new String[iloscPunktowKrzyzowania+1];  // deklaracja podziału chromosomu1 względem punktu krzyżowania
        String[] czesciChromosoma2 = new String[iloscPunktowKrzyzowania+1];  // deklaracja podziału chromosomu2 względem punktu krzyżowania
        String potomek1="",potomek2=""; // potomkowie po skrzyżowaniu
        int[] punktySkrzyzowania = wyznaczPunktyKrzyzowania(iloscPunktowKrzyzowania, chromosom1);
        czesciChromosoma1[0] = chromosom1.substring(0,punktySkrzyzowania[0]);
        czesciChromosoma2[0] = chromosom2.substring(0,punktySkrzyzowania[0]);
        for (int j = 1; j <= iloscPunktowKrzyzowania; j++) {
            if(j==iloscPunktowKrzyzowania){
                czesciChromosoma1[j] = chromosom1.substring(punktySkrzyzowania[j-1]);
                czesciChromosoma2[j] = chromosom2.substring(punktySkrzyzowania[j-1]);
            }
            else {
                czesciChromosoma1[j] = chromosom1.substring(punktySkrzyzowania[j-1],punktySkrzyzowania[j]);
                czesciChromosoma2[j] = chromosom2.substring(punktySkrzyzowania[j-1],punktySkrzyzowania[j]);
            }
        }
        for(int i=1;i<czesciChromosoma1.length;i++){
            if(i%2==0){
                potomek1 += czesciChromosoma1[i];
                potomek2 += czesciChromosoma2[i];
            }
            else {
                potomek1 += czesciChromosoma2[i];
                potomek2 += czesciChromosoma1[i];
            }
        }
        String[] potomkowie = new String[]{potomek1,potomek2};
        return potomkowie;

    }

    public static ArrayList utworzPopulacje2 (ArrayList populacja1, ArrayList populacjaTemp){
        int wielkoscPopulacji = populacja1.size();
        ArrayList populacja2 = new ArrayList(wielkoscPopulacji);
        for (int i = 0; i < wielkoscPopulacji; i++) {
            populacja2.add("");
        }
        for (int i = 0; i < populacja1.size(); i++) {
             int osobnikT = wybierzPartneraDoKrzyzowania(wielkoscPopulacji);
             String[] noweOsobniki = krzyzowanieWielopunktowe(populacja1.get(i).toString(),populacjaTemp.get(osobnikT).toString(),2,populacja1);
             populacja2.set(i,noweOsobniki[0]);
             populacja2.set(osobnikT,noweOsobniki[1]);
        }
        return populacja2;
    }

    public static int ustalIndeks(double value) {
        int index = 0;
        if (value > 0) {
            index = (int) Math.abs((2 - value) / Math.pow(10, -5));
        } else {
            index = (int) Math.abs((-2 + value) / Math.pow(10, -5));
        }
        return index;
    }

    public static ArrayList wyznaczPopulacjeRuletkowo(ArrayList oryginalnaPopulacja){
        wyznaczFunkcjePrzystosowania(oryginalnaPopulacja);
        wagaOsobnika(oryginalnaPopulacja);
        wyznaczLiczbeKopiiChromosomu(oryginalnaPopulacja);
        ArrayList popT = utworzPopulacjeT(oryginalnaPopulacja);
        ArrayList populacjaKoncowa = utworzPopulacje2(oryginalnaPopulacja,popT);
        return populacjaKoncowa;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Podaj wielkosc populacji: ");
        int wielkoscPopulacji = in.nextInt();
        ArrayList pop = generujPopulację(wielkoscPopulacji);
        wyznaczFunkcjePrzystosowania(pop);
        wagaOsobnika(pop);
        wyznaczLiczbeKopiiChromosomu(pop);
        ArrayList popT = utworzPopulacjeT(pop);
        ArrayList pop2 = utworzPopulacje2(pop,popT);
        double[] finalneWartosci = wyznaczFunkcjePrzystosowania(pop2);
        System.out.println("Chromosom:                             f");
        for (int i = 0; i < finalneWartosci.length; i++) {
            double[] wielkosciChromosomu = chromosomNaLiczby(pop2.get(i).toString());
            String chromosom = decToBinary(ustalIndeks(wielkosciChromosomu[0])) + decToBinary(ustalIndeks(wielkosciChromosomu[1]));
            System.out.println(chromosom+" "+String.format("%.4f",finalneWartosci[i]));
        }
    }
}
