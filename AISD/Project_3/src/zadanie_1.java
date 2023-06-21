
public class zadanie_1 
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
	public static void main(String[] args) 
	{
		//Skonstruuj klasê Student, zawieraj¹c¹ atrybuty: nrAlbumu, nazwisko oraz imiê. Zbuduj tablicê 3 
		//obiektów typu Student, zawieraj¹c¹ Twoje dane oraz dwóch s¹siadów z sali laboratoryjnej. 
		//Wydrukuj nazwiska studentów zapisanych w tablicy
	Student[] tab1=new Student[3];
	Student s0 = new Student(40015, "Górski", "Wiktor");
	Student s1 = new Student(40115, "Janusz", "Marek");
	Student s2 = new Student(40215, "Dudek", "Micha³");
	tab1[0]=s0;
	tab1[1]=s1;
	tab1[2]=s2;
	for(int i =0;i<tab1.length;i++) 
	{
	//System.out.println(tab1[i].NrAlbumu +" "+ tab1[i].nazwisko +" "+ tab1[i].imie);
	System.out.println(tab1[i]);
	}
	
	}

}

