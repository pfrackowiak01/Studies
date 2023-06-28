import java.util.ArrayList;
import java.util.Random;

public class LAB5 {

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

    public static void pokazChromosomy(ArrayList populacja){
        for (int i = 0; i < populacja.size(); i++) {
            System.out.println(populacja.get(i).toString());
        }
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

    public static void  pokazPrzystosowania(ArrayList populacja){
        double[] p = wyznaczFunkcjePrzystosowania(populacja);
        for (int i = 0; i < p.length; i++) {
            System.out.println(p[i]);
        }
    }

    public static void pokazChromosomyIPrzystosowania(ArrayList populacja){
        double[] wyniki = wyznaczFunkcjePrzystosowania(populacja);
        for(int i=0;i<populacja.size();i++) {
            System.out.println(String.format(populacja.get(i).toString()+" "+wyniki[i]));
        }
    }

    public static double obliczSredniePrzystosowanie(ArrayList populacja) {
        double[] wyniki = wyznaczFunkcjePrzystosowania(populacja);
        double sum = 0.0, sredniePrzystosowanie = 0.0;
        for (int i = 0; i < wyniki.length; i++) {
            sum+=wyniki[i];
        }
        sredniePrzystosowanie = sum/wyniki.length;
        return sredniePrzystosowanie;
    }

    public static int osobnikiPonizejSredniej(ArrayList populacja){
        int liczbaOsobnikow = 0;
        double[] wyniki = wyznaczFunkcjePrzystosowania(populacja);
        double srednia = obliczSredniePrzystosowanie(populacja);
        for (int i = 0; i < populacja.size(); i++) {
            if(wyniki[i] < srednia){
                liczbaOsobnikow++;
            }
        }
        return liczbaOsobnikow;
    }
    public static int osobnikiPowyzejRownySredniej(ArrayList populacja){
        int liczbaOsobnikow = 0;
        double[] wyniki = wyznaczFunkcjePrzystosowania(populacja);
        double srednia = obliczSredniePrzystosowanie(populacja);
        for (int i = 0; i < populacja.size(); i++) {
            if(wyniki[i] >= srednia){
                liczbaOsobnikow++;
            }
        }
        return liczbaOsobnikow;
    }


    public static void main(String[] args) {
        ArrayList pop  = generujPopulację(20);
        pokazChromosomy(pop);
        System.out.println();
        pokazPrzystosowania(pop);
        System.out.println();
        pokazChromosomyIPrzystosowania(pop);
        System.out.println();
        System.out.println("Liczba osobnikow ponizej sredniej: "+osobnikiPonizejSredniej(pop));
        System.out.println();
        System.out.println("Liczba osobnikow powyzej sredniej: "+osobnikiPowyzejRownySredniej(pop));
        System.out.println();
    }
}
