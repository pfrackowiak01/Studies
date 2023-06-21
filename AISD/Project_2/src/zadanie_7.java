import java.util.Scanner;


public class zadanie_7 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//Wczytaj z klawiatury dodatni¹ liczbê naturaln¹ M. Wyznacz i wydrukuj wszystkie liczby pierwsze 
		//mniejsze od podanej liczby M wykorzystuj¹c algorytm zwany „sito Eratostenesa”
		Scanner in = new Scanner(System.in);
		int j;
		int d;
		System.out.println("zakres od 1 do a(liczba podana przez u¿ytownika): ");
		System.out.print("Podaj górny zakres: ");
		int m=in.nextInt();
		System.out.println("Liczny pierwsze: ");
        int[] tab = new int[1000000];
        d = (int)Math.floor(Math.sqrt(m));         
        for (int i = 1; i <= m; i++) 
            tab[i] = i;        
        for (int i = 2; i <= d; i++)
        {
            if (tab[i] != 0)
            {
                j = i + i;
                while (j <= m)
                {
                    tab[j] = 0;
                    j += i;
                }
            }
        }      
        for (int i = 2; i < m; i++)
        {
            if (tab[i] != 0)
            {
            	System.out.print(" "+tab[i] + " ");
            }
        }
	}

}
