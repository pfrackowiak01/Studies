import java.util.Scanner;

public class zadanie_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Wczytaj z klawiatury 8 wyraz�w i zapisz je w tablicy element�w typu String.
		// Wyznacz i wydrukuj:
		// a. Najd�u�szy wyraz
		// b. Wyraz zawieraj�cy najwi�cej wielkich liter
		// c. Wyraz o najwi�kszej liczbie samog�osek
		Scanner in = new Scanner(System.in);
		String a;
		String max="";
		String[] tab = new String[8];
		for (int i = 0; i < 8; i++) {
			System.out.print("Podaj znak: ");
			a = in.nextLine();
			tab[i] = a;
		}
		System.out.print("Tablica string�w: ");
		for (int i = 0; i < 8; i++) 
		{
			System.out.print(tab[i]+" ");
		}
		System.out.println();
		System.out.print("Najd�u�szy string: ");
		for(int i=0;i<8;i++)
		{
			if(tab[i].length()>max.length())
			{
				max=tab[i];
			}
		}
		System.out.print(max);
		System.out.println();
		System.out.print("Najwi�cej du�ych liter: ");
	}

}
