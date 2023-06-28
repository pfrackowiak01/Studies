import java.io.FileNotFoundException;
import java.util.ArrayList;

public class AntColonyReport {
    public static double[] optima = new double[] {
            21282,	26524,	29368,	22141,	26130,	29437,	20749,	21294,	22068
    };
    public static String[] filenames = new String[] {
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

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Integer> trasa;
        //trasa = AntColony.milingona(filenames[2], 1,5,0.5);
        //trasa = AntColony.milingona2(filenames[2],1,5,0.5,1,100);

        /*
        System.out.print("Znaleziona trasa: ");
        int[] ary = new int[AntColony.n];
        for(int i=0; i<trasa.size(); i++) {
            System.out.print(trasa.get(i)+",");
            ary[i] = trasa.get(i);
        }
        System.out.println(trasa.get(0));
        System.out.println("Długość tej trasy = "+AntColony.dlugoscTrasy(ary));
        System.out.println("Rozwiązanie gorsze od optimum o "+(100*(AntColony.dlugoscTrasy(ary)/optima[2]-1))+"%");
        */

        /*
        System.out.println("Algorytm 1");
        System.out.println();
        for(int i=0; i<9; i++) {
            System.out.println("Trasa "+(i+1));
            for(int j=0; j<10; j++) {
                trasa = AntColony.milingona(filenames[i], 1,5,0.5);
                int[] ary = new int[AntColony.n];
                for(int k=0; k<trasa.size(); k++)
                    ary[k] = trasa.get(k);
                System.out.println((int)AntColony.dlugoscTrasy(ary));
            }
            System.out.println();
        }
         */
/*
        System.out.println("Algorytm 2");
        System.out.println();
        for(int i=0; i<9; i++) {
            System.out.println("Trasa "+(i+1));
            for(int j=0; j<10; j++) {
                trasa = AntColony.milingona2(filenames[i], 1,5,0.5,1,100);
                int[] ary = new int[AntColony.n];
                for(int k=0; k<trasa.size(); k++)
                    ary[k] = trasa.get(k);
                System.out.println((int)AntColony.dlugoscTrasy(ary));
            }
            System.out.println();
        }
 */
    }
}
