import java.util.Scanner;

public class zadanie_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Wczytaj liczb� naturaln� z klawiatury. 
		//Sprawd�, czy podana liczba jest liczb� pierwsz�, a
		//nast�pnie wydrukuj na ekranie stosowny komunikat.
		Scanner in = new Scanner(System.in);
		System.out.println("Prosz� poda� liczb�");
		int a=in.nextInt();
		int ile=0;
		for(int i=1;i<=a;i++)
		{
			if(a%i==0)
			{
				ile++;
			}
		}
		if(ile==2) 
		{
		System.out.println("liczba jest pierwsza");
		}
		else
		{
		System.out.println("liczba nie jest pierwsza");
		}
	}

}
