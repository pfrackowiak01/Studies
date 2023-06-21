import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class LAB7 {
    static Random rng = new Random();
    static int wielkoscPopulacji = 200; // zmienna wiekosc populacji
    static ArrayList<String> populacjaX = new ArrayList<String>(); //populacja chromosomów


    //wartość funkcji f(x1, x2)
    public static double f(double[] X){
        double f = (double) -X[0]*X[0] -X[1]*X[1]+2;
        return f;
    }

    //kodowanie binarne liczby
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

    public static double wartoscIndeksu(int indeks){
        float x = (float) (-2.0 + indeks * ( (2.0 - (-2.0) ) / (Math.pow(2,19)-1) ) ); // wyznaczenie wartosci x na podstawie
        return x;
    }

    public static double[] chromosomNaLiczby(String chromosom){
        double[] X = new double[3];
        int indeks1 = 0, indeks2 = 0;
        String czesc1 = chromosom.substring(0,(chromosom.length()/2));
        String czesc2 = chromosom.substring((chromosom.length()/2));
        indeks1 = Integer.parseInt(czesc1,2);
        indeks2 = Integer.parseInt(czesc2,2);
        X[0] = wartoscIndeksu(indeks1);
        X[1] = wartoscIndeksu(indeks2);
        return X;
    }

    //generowanie chromosomu
    private static String wygenerujChromosom(){
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

    // generowanie populacji
    public static void generujPopulację(int wielkoscPopulacji){
        String chromosom = "";
        for (int i = 0; i < wielkoscPopulacji; i++) {
            chromosom = wygenerujChromosom();
            populacjaX.add(chromosom);
        }
    }

    public static double wartoscFunkcjiPrzystosowania(String osobnik) {
        double wartoscFP = 0;
        double[] x1x2 = chromosomNaLiczby(osobnik);
        double x1 = x1x2[0];
        double x2 = x1x2[1];
        if( (x1 >= -2.0 && x1 <= 2.0) && (x2 >= -2.0 && x2 <= 2.0) ){
            wartoscFP = f(x1x2);
        }
        return wartoscFP;
    }

    // funkcja przystosowania
    public static double[] wyznaczFunkcjePrzystosowaniaPopulacji(ArrayList populacja){
        double[] wartosci = new double[populacja.size()];
        String obecnyOsobnik = "";
        double[] x1x2 = new double[2];
        double x1 = (double) 0.0, x2 = (double) 0.0;
        for (int i=0;i<populacja.size();i++) {
            obecnyOsobnik = (String) populacja.get(i);
            x1x2 = chromosomNaLiczby(obecnyOsobnik);
            x1 = x1x2[0];
            x2 = x1x2[1];
            if( (x1 >= -2.0 && x1 <= 2.0) && (x2 >= -2.0 && x2 <= 2.0) ){
                wartosci[i] = f(x1x2);
            }
            else {
                String drugiOsobnik = populacjaX.get(wybierzPartneraDoKrzyzowania(populacjaX.size()));
                int[] punktyKrzyzowania = wyznaczPunktyKrzyzowania(2,drugiOsobnik);
                krzyzowanieWielopunktowe(obecnyOsobnik,drugiOsobnik,punktyKrzyzowania[0],populacjaX);
            }
        }
        return wartosci;
    }

    // wyznaczenie najlepszych funckji przystosowania wymaganych do wykresu
    public static double wyznaczNajlepszaWartosc(ArrayList populacja){
        double[] wynikiFunkcji = wyznaczFunkcjePrzystosowaniaPopulacji(populacja);
        double maksymalnaWartosc = (float) 0.0;
        double obecnaWartosc = (float) 0.0;
        for (int i=0;i<populacja.size();i++) {
            obecnaWartosc = wynikiFunkcji[i];
            if(obecnaWartosc > maksymalnaWartosc){
                maksymalnaWartosc = obecnaWartosc;
            }
        }
        return maksymalnaWartosc;
    }


    // oblicznie funkcji przystosowania potrzebnej do rulatki
    public static double obliczSumePrzystosowania(ArrayList populacja){
        double[] p = wyznaczFunkcjePrzystosowaniaPopulacji(populacja);
        double suma = 0.0;
        for (int i = 0; i < p.length; i++) {
            suma += p[i];
        }
        return suma;
    }
    // Waga osobnika - określenie czy osobnik trafi do następnej populacji
    public static double[] wagaOsobnika(ArrayList populacja){
        double[] wagiOsobnikow = new double[populacja.size()];
        double[] fpopulacji = wyznaczFunkcjePrzystosowaniaPopulacji(populacja);
        double sumafpopulacji = obliczSumePrzystosowania(populacja);
        for (int i = 0; i < populacja.size(); i++) {
            wagiOsobnikow[i] = fpopulacji[i] / sumafpopulacji;
        }
        return wagiOsobnikow;
    }
    // wyznaczenie liczby kopii - określa ile kopii chromosomu dostało się do kolejnej populacji
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
    // Utworzenie tymczasowej populacji
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
    // Wybieranie partnera, z którym będą się krzyżować chromosomy
    public static int wybierzPartneraDoKrzyzowania(int wielkoscOryginalnejPopulacji){
        Random rand = new Random();
        int indeksPartnera = rand.nextInt(0,wielkoscOryginalnejPopulacji);
        return indeksPartnera;
    }
    // wyznacznie losowe punktów krzyżowania względem których dojdzie do krzyżowania chromosoów
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
    // krzyżowanie wielopunktowe - tworzenie potomków na podstawie punktów krzyżowania
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
    // druga populacja na podstawie populacjie oryginalnej i tymczasowej
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
    // wyznaczenie drugiej populacji ruletkowo
    public static ArrayList wyznaczPopulacjeRuletkowo(ArrayList oryginalnaPopulacja){
        wyznaczFunkcjePrzystosowaniaPopulacji(oryginalnaPopulacja);
        wagaOsobnika(oryginalnaPopulacja);
        wyznaczLiczbeKopiiChromosomu(oryginalnaPopulacja);
        ArrayList popT = utworzPopulacjeT(oryginalnaPopulacja);
        ArrayList populacjaKoncowa = utworzPopulacje2(oryginalnaPopulacja,popT);
        return populacjaKoncowa;
    }
    // mutowanie osobników całej populacji
    public static void  mutujPopulacje (ArrayList populacja) {
        Random rng = new Random();
        double pm = 0.02; //szansa na mutację danego osobnika
        double r=0;
        String gen = ""; //pojedynczy gen w chromosomie
        for(int j=0; j<populacja.size();j++){ //przejście przez wszystkie chromosomy w populacji
            String chromosom = (String) populacja.get(j); // tymczasowa zmienna przechowująca pojedynczy chromosom z populacji
            for(int i = 0; i< chromosom.length(); i++) //przejście przez wszystkie geny w chromosomie
            {
                r = rng.nextDouble();
                gen = String.valueOf(chromosom.charAt(i)); //tymczasowa zmienna przechowująca pojedynczy gem w chromosomie
                if(r < pm){
                    if(gen.equals("0")){
                        gen = "1";
                    }
                    else {
                        gen = "0";
                    }
                }
            }
            populacja.set(j, chromosom); //podmianka chromosomu w populacji
        }
    }

    public static void main(String[] args) throws IOException {
        generujPopulację(wielkoscPopulacji);
//      krzyzowaniePopulacji(populacja);
        mutujPopulacje(populacjaX);
        //generujRuletka(populacjaX);
        int indeksOsobnika=0;
        double wartoscFunkcjiPrzystosowania, najlepszaLokalnaWartosc, najlepszaGlobalnaWartosc=0.0;
        File wyniki = new File("wyniki.txt");
        FileWriter zapiszWyniki = new FileWriter(wyniki);
        zapiszWyniki.write("i    current    fmax    global_fmax\r\n");

        for(int j=1;j<=1000;j++){
            populacjaX.clear();
            generujPopulację(wielkoscPopulacji);
//            krzyzowaniePopulacji(populacja);
            mutujPopulacje(populacjaX);
            //ruletka
            //wyznaczPopulacjeRuletkowo(populacjaX);
            indeksOsobnika = 1000 % populacjaX.size();
            wartoscFunkcjiPrzystosowania = wartoscFunkcjiPrzystosowania(populacjaX.get(indeksOsobnika));
            najlepszaLokalnaWartosc = wyznaczNajlepszaWartosc(populacjaX);
            if(najlepszaGlobalnaWartosc < najlepszaLokalnaWartosc){
                najlepszaGlobalnaWartosc = najlepszaLokalnaWartosc;
            }
            zapiszWyniki.append(j+" "+String.format("%.5f", wartoscFunkcjiPrzystosowania)+" "+String.format("%.5f", najlepszaLokalnaWartosc)+" "+String.format("%.5f", najlepszaGlobalnaWartosc)+"\r\n");

        }
        zapiszWyniki.close();
    }
}