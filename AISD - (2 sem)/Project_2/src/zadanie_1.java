import java.util.Random;
import java.util.Scanner;

public class zadanie_1 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//Wygeneruj tablicê 12 losowych liczb ca³kowitych z przedzia³u [0, 100), a nastêpnie wydrukuj 
		//powsta³¹ tablicê. Wykonaj podstawowe operacje na tablicy:
		//Wyznacz, który element jest wiêkszy: pierwszy czy ostatni?
		//Wstaw liczbê 51 na pocz¹tek/koniec/okreœlon¹ pozycjê (np. 5) tablicy
		//Usuñ element z pocz¹tku/koñca/okreœlonej pozycji (np. 5) tablicy.
		Random r = new Random(); 
		int[] tab=new int[12];
		System.out.print("Wyœwietlona tablica: ");
		for(int i=0;i<tab.length;i++)
		{
			tab[i]=r.nextInt(101);
		}
		for(int i=0;i<tab.length;i++)
		{
			System.out.print(tab[i]+", ");
		}
		/////////////////////////////////////////////////////////////////////////
		System.out.println();
		System.out.print("Element wiêkszy: ");
		if(tab[0]<tab[11])
		{
			System.out.print(tab[11]);	
		}
		else
		{
			System.out.print(tab[0]);
		}
		/////////////////////////////////////////////////////////////////////////
		System.out.println();
		System.out.println("Zmiana elementu na 51: ");
		Scanner in = new Scanner(System.in);
		System.out.print("Proszê podaæ indeks zamiany w zakresie od 0 do 11: ");
		int z = in.nextInt();
		int[] tab2 = new int[tab.length+1];
		for(int i=0;i<tab2.length;i++)
		{
			if(z>i)
				tab2[i]=tab[i];
			else if(z==i)
				tab2[i]=51;
			else
				tab2[i]=tab[i-1];
		}
		for(int i=0;i<tab2.length;i++)
		{
			System.out.print(tab2[i]+", ");
		}
		////////////////////////////////////////////////////////////////////////
		System.out.println();
		System.out.print("Proszê podaæ indeks do usuniêcia w zakresie od 0 do 11: ");
		int u = in.nextInt();
		System.out.print("Usuniêcie elementów: ");
		for(int i=u+1;i<tab.length;i++)
		{
			tab[i-1]=tab[i];	
		}
		tab[tab.length-1]=0;
		for(int i=0;i<tab.length;i++)
		{
			System.out.print(tab[i]+", ");
		}
	}

}
