
public class zadanie_3 
{
	static class Student
	{
		int NrAlbumu;
		String imie;
		String nazwisko;
		Student(int nA, String nz, String im)
		{
			NrAlbumu = nA;
			nazwisko=new String(nz);
			imie=new String(im);
					
		}
		public String toString() 
		{
			return NrAlbumu+" "+nazwisko+" "+imie;
		}
		
	}
	static class element
	{
		Student i;
		element next;
	}
	public static void main(String[] args) 
	{
		//Skonstruuj klas� jak w zadaniu 1, a nast�pnie zbuduj list� jednokierunkow� zawieraj�c� dane 
		//wspomnianych student�w. Wydrukuj dane wszystkich student�w, a nast�pnie dane studenta o 
		//najmniejszym numerze albumu.
		element first = new element();
		element second = new element();
		element three = new element();
		first.i= new Student(40015, "G�rski", "Wiktor");
		second.i= new Student(40115, "Janusz", "Marek");
		three.i= new Student(40215, "Dudek", "Micha�");
		first.next=second;
		second.next=three;
		for(element x=first; x!=null; x=x.next)
		{
			System.out.println(x.i);
		}
	}
}
