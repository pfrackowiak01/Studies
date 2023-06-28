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
		//Skonstruuj listê jednokierunkow¹ w oparciu o nazwy 5 stolic europejskich krajów s¹siaduj¹cych z 
		//Polsk¹ (spoœród siedmiu) podanych przez u¿ytkownika z klawiatury. Zaimplementuj nastêpuj¹ce 
		//wybrane operacje na tej liœcie i wydrukuj rezultat wykonania ka¿dej operacji:
		//a. Dodaj pozosta³e stolice do listy: na pocz¹tek - nazwê stolicy szóstego kraju, a na koniec -
		//nazwê stolicy siódmego kraju.
		//b. Usuñ nazwê stolicy o najmniejszej populacji (dane spoza struktury danych)
		Scanner in = new Scanner(System.in);
		element first = new element();
		element second = new element();
		element three = new element();
		element four = new element();
		element five = new element();
		System.out.println("Proszê podaæ 5 nazwy stolic krajów granicz¹cych z Polsk¹:");
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
		System.out.println("Proszê podaæ pozosta³e nazwy stolic:");
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