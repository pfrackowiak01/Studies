import java.util.Scanner;

public class zadanie_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Wczytaj dwie liczby ca�kowite z klawiatury. 
		//Wydrukuj wi�ksz� z nich.
		Scanner in = new Scanner(System.in);
		System.out.println("Prosz� poda� liczb� a");
		int a = in.nextInt();
		System.out.println("Prosz� poda� liczb� b");
		int b = in.nextInt();
		if(a>b)
		{
			System.out.println("liczba "+ a +" jest wi�ksza");
		}
		else if(a<b)
		{
			System.out.println("liczba "+ b +" jest wi�ksza");
		}
		else
		{
			System.out.println("liczba s� r�wne");
		}
	}

}
