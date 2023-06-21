import java.util.Scanner;

public class zadanie_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Wczytaj trzy liczby ca³kowite z klawiatury. 
		//Wydrukuj najmniejsz¹ z nich.
		Scanner in = new Scanner(System.in);
		System.out.println("Proszê podaæ liczbê a");
		int a = in.nextInt();
		System.out.println("Proszê podaæ liczbê b");
		int b = in.nextInt();
		System.out.println("Proszê podaæ liczbê c");
		int c = in.nextInt();
		if(a<b&&a<c)
		{
		System.out.println("liczba "+ a +" jest najmniejsza");
		}
		else if(a>b&&b<c)
		{
		System.out.println("liczba "+ b +" jest najmniejsza");
		}
		else if(a==b&&a==c) 
		{
		System.out.println("liczby s¹ równe");
		}
		else if(a==b&&c<a) 
		{
			System.out.println("liczba "+ c +" jest najmniejsza");
		}
	}
}


