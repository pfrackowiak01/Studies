
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
		//Skonstruuj klasê jak w zadaniu 1, a nastêpnie zbuduj listê jednokierunkow¹ zawieraj¹c¹ dane 
		//wspomnianych studentów. Wydrukuj dane wszystkich studentów, a nastêpnie dane studenta o 
		//najmniejszym numerze albumu.
		element first = new element();
		element second = new element();
		element three = new element();
		first.i= new Student(40015, "Górski", "Wiktor");
		second.i= new Student(40115, "Janusz", "Marek");
		three.i= new Student(40215, "Dudek", "Micha³");
		first.next=second;
		second.next=three;
		for(element x=first; x!=null; x=x.next)
		{
			System.out.println(x.i);
		}
	}
}
