import java.util.Scanner;

public class zadanie_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Wczytaj trzy liczby ca�kowite z klawiatury. 
		//Wydrukuj najmniejsz� z nich.
		Scanner in = new Scanner(System.in);
		System.out.println("Prosz� poda� liczb� a");
		int a = in.nextInt();
		System.out.println("Prosz� poda� liczb� b");
		int b = in.nextInt();
		System.out.println("Prosz� poda� liczb� c");
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
		System.out.println("liczby s� r�wne");
		}
		else if(a==b&&c<a) 
		{
			System.out.println("liczba "+ c +" jest najmniejsza");
		}
	}
}


