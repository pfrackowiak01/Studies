import java.util.Scanner;

public class zadanie_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Wczytaj dwie liczby ca³kowite z klawiatury. 
		//Wydrukuj wiêksz¹ z nich.
		Scanner in = new Scanner(System.in);
		System.out.println("Proszê podaæ liczbê a");
		int a = in.nextInt();
		System.out.println("Proszê podaæ liczbê b");
		int b = in.nextInt();
		if(a>b)
		{
			System.out.println("liczba "+ a +" jest wiêksza");
		}
		else if(a<b)
		{
			System.out.println("liczba "+ b +" jest wiêksza");
		}
		else
		{
			System.out.println("liczba s¹ równe");
		}
	}

}
