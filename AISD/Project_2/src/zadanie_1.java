import java.util.Random;
import java.util.Scanner;

public class zadanie_1 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//Wygeneruj tablic� 12 losowych liczb ca�kowitych z przedzia�u [0, 100), a nast�pnie wydrukuj 
		//powsta�� tablic�. Wykonaj podstawowe operacje na tablicy:
		//Wyznacz, kt�ry element jest wi�kszy: pierwszy czy ostatni?
		//Wstaw liczb� 51 na pocz�tek/koniec/okre�lon� pozycj� (np. 5) tablicy
		//Usu� element z pocz�tku/ko�ca/okre�lonej pozycji (np. 5) tablicy.
		Random r = new Random(); 
		int[] tab=new int[12];
		System.out.print("Wy�wietlona tablica: ");
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
		System.out.print("Element wi�kszy: ");
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
		System.out.print("Prosz� poda� indeks zamiany w zakresie od 0 do 11: ");
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
		System.out.print("Prosz� poda� indeks do usuni�cia w zakresie od 0 do 11: ");
		int u = in.nextInt();
		System.out.print("Usuni�cie element�w: ");
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
