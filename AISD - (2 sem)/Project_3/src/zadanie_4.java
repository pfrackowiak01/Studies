import java.util.Scanner;
public class zadanie_4 
{
	static class Stolice
	{
		String Stolica;
		Stolice(String ns)
		{
			Stolica=new String(ns);
					
		}
		public String toString() 
		{
			return Stolica;
		}
		
	}
	static class element
	{
		Stolice i;
		element next;
	}
	public static void main(String[] args) 
	{
		//Skonstruuj list� jednokierunkow� w oparciu o nazwy 5 stolic europejskich kraj�w s�siaduj�cych z 
		//Polsk� (spo�r�d siedmiu) podanych przez u�ytkownika z klawiatury. Zaimplementuj nast�puj�ce 
		//wybrane operacje na tej li�cie i wydrukuj rezultat wykonania ka�dej operacji:
		//a. Dodaj pozosta�e stolice do listy: na pocz�tek - nazw� stolicy sz�stego kraju, a na koniec -
		//nazw� stolicy si�dmego kraju.
		//b. Usu� nazw� stolicy o najmniejszej populacji (dane spoza struktury danych)
		Scanner in = new Scanner(System.in);
		element first = new element();
		element second = new element();
		element three = new element();
		element four = new element();
		element five = new element();
		System.out.println("Prosz� poda� 5 nazwy stolic kraj�w granicz�cych z Polsk�:");
		System.out.println();
		first.i= new Stolice(in.nextLine());
		second.i= new Stolice(in.nextLine());
		three.i= new Stolice(in.nextLine());
		four.i= new Stolice(in.nextLine());
		five.i= new Stolice(in.nextLine());
		first.next=second;
		second.next=three;
		three.next=four;
		four.next=five;
		System.out.println();
		for(element x=first; x!=null; x=x.next)
		{
			System.out.println(x.i);
		}
		element start=new element();
		element koniec=new element();
		System.out.println("Prosz� poda� pozosta�e nazwy stolic:");
		System.out.println();
		start.i= new Stolice(in.nextLine());
		koniec.i= new Stolice(in.nextLine());
		start.next=first;
		first.next=second;
		second.next=three;
		three.next=four;
		four.next=five;
		five.next=koniec;
		System.out.println();
		for(element x=start; x!=null; x=x.next)
		{
			System.out.println(x.i);
		}
	}
}